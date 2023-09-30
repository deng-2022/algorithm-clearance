package com.yugutou.charpter12_string.level2;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "abcadfhg", s2 = "bcafdagh";
        System.out.println(checkPermutation(s1, s2));
    }

    public static boolean checkPermutation(String s1, String s2) {
        // 将字符串转换成字符数组
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        // 再将字符数组转换成字符串，比较是否相等
        return new String(s1Chars).equals(new String(s2Chars));
    }

    public static boolean checkPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1chars = s1.toCharArray();
        HashMap<Character, Integer> s1Map = getMap(s1);
        HashMap<Character, Integer> s2Map = getMap(s2);
        for (char s1char : s1chars) {
            if (!s2Map.containsKey(s1char) || (int) s1Map.get(s1char) != (int) s2Map.get(s1char)) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> getMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        return map;
    }
}

