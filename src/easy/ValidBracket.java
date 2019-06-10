package easy;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true

 "{()()}"
 * @author shc
 * @date 2019-04-16
 **/
public class ValidBracket {
    /**
     * 分析感觉用栈很好处理
     * 和标准题解基本相同，但是执行用时好像有点高
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        if(s.length() == 0 ){
            return true;
        }
        if(s.length()%2 == 1){
            return false;
        }

        String[] split = s.split("");
        Map<String, String> stringMap = new HashMap<>(3);
        stringMap.put("}","{");
        stringMap.put(")","(");
        stringMap.put("]","[");
        if(stringMap.containsKey(split[0])){
            return false;
        }

        Stack<String> stringStack = new Stack<>();
        stringStack.push(split[0]);
        for(int i=1; i<split.length;i++){
            String temp = split[i];
            // 判断字符串是左半区还是右半区
            if(stringMap.containsKey(temp)){
                // 得到相应字符串的左半区
                String s1 = stringMap.get(temp);
                if(stringStack.empty()){
                    return false;
                }
                if(s1.equals(stringStack.peek())){
                    stringStack.pop();
                }else{
                    return false;
                }

            }else{
                stringStack.push(split[i]);
            }
        }
        return stringStack.empty();
    }
    public static  void main(String[] args){
        System.out.println(isValid("()[]{}"));
    }
}
