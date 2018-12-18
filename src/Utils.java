import java.util.List;

public class Utils {
    //将数组转换成字符串打印出来
    public String array(List a) {
        String array = "[";
        for (int i = 0;i < a.size();i++) {
            if (i != a.size() - 1) {
                array += a.get(i) + ",";
            } else {
                array += a.get(i);
            }
        }
        array += "]";
        return array;
    }

    //将数组转换成字符串打印出来
    public String intArray(int [] a) {
        String array = "[";
        for (int i = 0;i < a.length;i++) {
            if (i != a.length - 1) {
                array += a[i] + ",";
            } else {
                array += a[i];
            }
        }
        array += "]";
        return array;
    }
    public String strArray(String [] a) {
        String array = "[";
        for (int i = 0;i < a.length;i++) {
            if (i != a.length - 1) {
                array += a[i] + ",";
            } else {
                array += a[i];
            }
        }
        array += "]";
        return array;
    }
}
