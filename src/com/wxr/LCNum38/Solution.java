package com.wxr.LCNum38;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return bs(countAndSay(n-1));

    }

    public String bs(String s){
        int len = s.length();
        int i = 0;//遍历数组的标示
        StringBuilder tempString = new StringBuilder();
        if(len == 1){
            return "11";
        }
        int count = 1;/*计数*/

        while(i <= len-1){
            if(i+1== len||s.charAt(i)!=s.charAt(i+1)){/*两个相邻字符不想等的时候*/
                tempString.append(String.valueOf(count) + s.charAt(i));
                count = 1;

            }else{//两个相邻字符相等的时候
                count++ ;
            }
            i++;
        }
        return tempString.toString();

    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = solution.countAndSay(4);
        System.out.println(s);

    }


}
