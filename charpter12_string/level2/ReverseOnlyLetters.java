package com.yugutou.charpter12_string.level2;

import java.util.Stack;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s));
    }

    public static String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack();
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    public static String reverseOnlyLetters2(String S) {
        if (S == null || S.length() == 0){
            return  S;
        }

        StringBuffer ans = new StringBuffer();
        int j =  S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if(Character.isLetter(S.charAt(i))){
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            }else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();
    }
}
