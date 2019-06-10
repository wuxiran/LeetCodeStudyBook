package com.wxr.LeetCode03LongestSubstringWithoutREpeadingCharacter;

import java.util.HashMap;
import java.util.Map;

public class Solution02 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        Solution02 solution02 = new Solution02();
        solution02.lengthOfLongestSubstring("abba");

    }
}
