package com.wxr.LCNum28;

/*实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
*/
public class Solution01 {

    public int strStr(String haystack, String needle) {


        if (haystack.equals(needle)||(needle.equals("")&&haystack!=null)){
            return 0;
        }

        if(haystack == null|| haystack.length() == 0|| needle == null ||needle.length() == 0) {
            return -1;
        }

        int hayStackLen = haystack.length();
        int needleLen = needle.length();

        int result = -1;

        for(int i = 0 ;i < needleLen;i++){
            int left = i, right = i;
            while(right+needleLen <= hayStackLen){
                String s = haystack.substring(right,right+needleLen);
                if(s.equals(needle)){
                    if(result>=0){
                        result =  Math.min(result,right);
                    }else{
                        result = right;
                    }
                }
                right += needleLen;

            }


        }


        return result;
    }

    public static void main(String[] args) {

        Solution01 solution01 = new Solution01();
        int a = solution01.strStr("aaapi","pi");
        System.out.println(a);
    }

}
