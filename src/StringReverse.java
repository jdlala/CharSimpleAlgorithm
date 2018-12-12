import java.util.ArrayList;
import java.util.List;

public class StringReverse {

    public static String arrayPairSum(String str) {
        List<Integer> indexs = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        String newString = "";
        char [] chars = str.toCharArray();
        for (int i = 0; i < chars.length;i++)
            if (chars[i] >= 65 && chars[i] <= 90) indexs.add(i);
        for (int i = 0;i < indexs.size();i++)
            strings.add((i != indexs.size() - 1) ?
                    str.substring(indexs.get(i),indexs.get(i + 1))
                    : str.substring(indexs.get(i)));
        for (String string : strings){
            char [] chars1 = string.toCharArray();
            for (int low = 0,high = chars1.length - 1;low < high;low++,high--){
                char tmp = chars1[low];
                chars1[low] = chars1[high];
                chars1[high] = tmp;
            }
            newString += new String(chars1);
        }
        return newString;
    }

    public static void main(String[]args){
        String str = "MyNameIsTom";
        System.out.println(arrayPairSum(str));
    }
}
