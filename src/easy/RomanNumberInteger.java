package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * @author shc
 * @date 2019-04-13
 */
public class RomanNumberInteger {

    /**
     * 1.将罗马数字对应的值放入map集合中，
     * 2.对罗马数字字符串进行遍历：先取两位字符看是否包含在map中，若不在就取其中一位字符，将取得的字符转换成对应的数字
     *
     * @param s 罗马数字
     * @return int
     */
    public static int romanToInt(String s) {
        int ans = 0;
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], ints[i]);
        }
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans = ans + map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(String.valueOf(s.charAt(i)));
                i += 1;
            }
        }
        return ans;
    }

    /**
     * 这道题其实关键在于理解题目，你只要发现无论多复杂的罗马数字都是由
     * {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
     * 这几个组成就不难解题。不要被它所谓的复杂规则吓懵了！
     * @param args
     */
    public static void main(String[] args) {

    }
}
