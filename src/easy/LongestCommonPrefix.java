package easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author shc
 * @date 2019-05-15
 **/
public class LongestCommonPrefix {


    public static String getSameString(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 0) {
            return result.toString();
        }
        if (strs.length == 1) {
            result.append(strs[0]);
            return result.toString();
        }
        String min = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (min.length() > strs[i].length()) {
                min = strs[i];
            }
        }
        for (int i = 0; i < min.length(); i++) {
            String a = min.substring(i, i + 1);
            boolean temp = false;
            for (int j = 0; j < strs.length; j++) {
                String b = strs[j].substring(i, i + 1);
                if (a.equals(b)) {
                    temp = true;
                } else {
                    return result.toString();
                }
            }
            if (temp) {
                result.append(a);
            }
        }
        return result.toString();
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] array = {"casdfasf", "aafsasfdasf"};
        String sameString = longestCommonPrefix(array);
        System.out.println(sameString);
    }
}
