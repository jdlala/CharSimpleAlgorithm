import java.util.*;

public class TopNPopularPathServiceImpl{
    private static String[][] useData = null;
    public void setup(String[][] data) {
        this.useData = data;
    }
    public String[] getTopNPopularPathes(int n) {
        if (useData == null) return new String[0];
        List<String> urlList = new ArrayList<>();
        Set<String> urlSet = new HashSet<>();
        Map<String,Integer> urlMap = new TreeMap<>();
        for (int i=0;i < useData.length;i++){
            String url = "";
            if (useData[i].length <= 3) {
                for (int k = 0; k < useData[i].length; k++)
                    url += useData[i][k];
                urlList.add(url);//将拼接好的url放入list数组中
                urlSet.add(url);//将拼接好的url放入lset数组中，去重
            } else {
                int j = 0,length = 3;
                while (length <= useData[i].length) {
                    for (int k = j; k < j + 3; k++)//第一位循环3位，第二位循环3位......
                        url += useData[i][k];
                    urlList.add(url);
                    urlSet.add(url);
                    j++;length++;url="";
                }
            }
        }
        int num = 0,urlSetSize = 0;
        List<String> urlSetToList = new ArrayList<>(urlSet);
        while (urlSetSize < urlSetToList.size()) {
            for (String urlStr : urlList)
                if ((urlSetToList.get(urlSetSize)).equals(urlStr)) num++;
            urlMap.put(urlSetToList.get(urlSetSize),num);//将set里的元素和list里的元素比较，得出个数
            urlSetSize++;num = 0;
        }
        String [] result = new String[n];
        Comparator<Map.Entry<String,Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {//排序比较器
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
                //o2.getValue()-o1.getValue();数组按value降序排列
                //o1.getValue()-o2.getValue();数组按value升序排列
            }
        };
        List<Map.Entry<String,Integer>> valueList = new ArrayList<>(urlMap.entrySet());//map转list排序
        Collections.sort(valueList,valueComparator);//排序
        int stringLength = 0;
        while (stringLength < n){
            result[stringLength] = valueList.get(stringLength).getKey();
            stringLength++;
        }
        return result;
    }
}

class Data {
    public static void main(String[] args) {
        TopNPopularPathServiceImpl pathService = new TopNPopularPathServiceImpl();
        String[][] data = {{"/", "subscribers", "filter", "export"}, {"/", "subscribers", "filter", "export"}, {"/", "catalog", "edit"}};
        pathService.setup(data);
        Utils utils = new Utils();
        System.out.println(utils.strArray(pathService.getTopNPopularPathes(3)));
    }
}
