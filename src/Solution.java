public class Solution {
    public static String reverseString(String s) {
        char [] chars = s.toCharArray();
        for (int low = 0,height = chars.length - 1;low <= height;low++,height--) {
            char tmp = chars[low];
            chars[low] = chars[height];
            chars[height] = tmp;
        }
        return new String(chars);
    }
    public static void main(String[]args){
        String str = "A man, a plan, a canal: Panama";
        System.out.println(reverseString(str));
    }
}
