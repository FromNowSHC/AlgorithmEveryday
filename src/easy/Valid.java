package easy;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @author shc
 * @date 2020-09-10
 */
public class Valid {

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<String, String> stringMap = new HashMap<>(3);
        stringMap.put("(", ")");
        stringMap.put("{", "}");
        stringMap.put("[", "]");

        LinkedList<String> list = new LinkedList<>();
        String[] str = s.split("");
        for (int i = 0; i < str.length; i++) {
            String si = str[i];
            if (stringMap.containsKey(si)) {
                list.push(si);
            } else {
                if(list.isEmpty()){
                    return  false;
                }
                String left = list.pop();
                String right = stringMap.get(left);
                if (!right.equals(si)) {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("){"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("(]"));
    }
}
