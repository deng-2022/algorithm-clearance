package com.yugutou.charpter4_stack.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {

    /**
     * 括号匹配问题
     *
     * @param s
     * @return
     */
    static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        // 1.构造HashMap
        Map<Character, Character> smap = new HashMap<>();
        smap.put('(', ')');
        smap.put('{', '}');
        smap.put('[', ']');
        // 2.构造栈
        Stack<Character> stack = new Stack<>();
        // 3.遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            // 入栈左括号
            if (smap.containsKey(item)) {
                stack.push(item);
                //入栈右括号
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character left = stack.pop();
                char rightChar = smap.get(left);
                if (rightChar != item) {
                    return false;
                }
            }
        }
        //
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
