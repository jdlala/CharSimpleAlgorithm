public class LetterConversion {

    //大写转小写
    public static String toLowerCase(String str) {
        char [] a = str.toCharArray();
        for (int i = 0;i < str.length();i++) {
            if (a[i] >= 65 && a[i]<= 90) {
                a[i] = (char)(a[i] + 32);
            }
        }
        return new String(a);
    }
    //小写转大写
    public static String toHigherCase(String str) {
        char [] a = str.toCharArray();
        for (int i = 0;i < str.length();i++) {
            if (a[i] >= 97 && a[i]<= 122) {
                a[i] = (char)(a[i] - 32);
            }
        }
        return new String(a);
    }

    public static void main(String[]args){
        String str = "Hello World";
        System.out.println("大写转小写:"+toLowerCase(str));
        System.out.println("小写转大写:"+toHigherCase(str));
    }
}
