package com.wxr.LCNum8;

import java.util.HashMap;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/*字符床转整数*/
public class Solution01 {
    HashMap<Character, Integer> map = new HashMap<>();

    public int myAtoi(String str) {

        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('0', 0);
        map.put('+', -1);
        map.put('-', -2);
        map.put(' ', -3);

        if (str.length() == 0) return 0;
        double result = 0; //最终结果

        int zheng = 0;

        int len = str.length();
        int i = 0;
        int count = 0;
        double carry = 0.1;
        while (i < len) {
            char a = str.charAt(i);
            if (map.containsKey(a)) {
                int b = map.get(a);
                if (b < 0 && result == 0) {
                    if (b == -2&&zheng == 0) {
                        zheng = -1;
                    }if(b ==-1 && zheng == 0){
                        zheng = +1;
                    }else if(b ==-1 && zheng == 1||b ==1 && zheng == -1){
                        break;
                    }
                    i++;
                }
                if (b < 0 && result > 0) {
                    break;
                }

                if (b > 0) {
                    result =result +  b * carry;
                    carry = carry * 0.1;
                    count ++;
                    i++;
                }
            } else {
                break;
            }
        }
        if(zheng != 0){
            result =  result*zheng;
        }

        Double d = new Double( result * Math.pow(10,count));

        d = d>MAX_VALUE?  MAX_VALUE:d;
        d = d<MIN_VALUE?  MIN_VALUE:d;

        return d.intValue();
    }

    public static void main(String[] args) {

        Solution01 solution01 = new Solution01();
        int a = solution01.myAtoi("  0000000000012345678");

        System.out.println(a);
    }

}
