package easy;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * @author shc
 * @date 2020-09-01
 */
public class ReverseWords {


    public static String reverseWord(String str){
        StringBuffer ret = new StringBuffer();
        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            String s = strArray[i];
            String[] chars = s.split("");
            for(int j = chars.length-1; j>=0;j--){
                ret.append(chars[j]);
            }
            ret.append(" ");
        }
        return ret.substring(0, ret.length()-1);
    }

    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWord("Let's take LeetCode contest"));
    }
}
