package com.wxr.LeetCode03LongestSubstringWithoutREpeadingCharacter;

import java.util.HashSet;
import java.util.Set;

public class Solution01 {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> longerSet = new HashSet<>();
        int n = s.length();
        int MaxLong = 0;
        if(s.length()<=0){
            return MaxLong;
        }
        int i = 0 ,j = 0;

        while(i<n&&j< n){

            //解法一  滑动窗口法
            if (!longerSet.contains(s.charAt(j))){
                longerSet.add(s.charAt(j++));
                MaxLong = Math.max(MaxLong, j - i);
            }
            else {
                longerSet.remove(s.charAt(i++));
            }
        }
        return MaxLong;
    }

}
