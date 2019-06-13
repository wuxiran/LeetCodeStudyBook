package com.wxr.LCNum8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/*字符串转整数，过多的if else 会把人拖入细节中，最终容易出错,浪费了时间，首先对于小数转整数，要抛弃。
* 但是也有好处，可以让多考虑边界条件
* */
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
        map.put('+', -3);
        map.put('-', -2);
        map.put(' ', -1);

        int n = str.length();//取长度

        List<Integer> resultList = new ArrayList<>();
        int i = 0;

        while(i < n){
            /*进行边界的判断*/
            /*假设有，不管在哪个部分直接返回 字母，就直接返回*/
            char b = str.charAt(i);
            if(!map.containsKey(b)){
                break;
            }
            if(map.containsKey(b)){
                /*假设开头是数字,且数据大于等于0，直接放进去*/
                if(map.get(b)>=0){
                    resultList.add(map.get(b));
                    i++;
                }
                /*出现字符,如果数组里面有东西了出现直接break*/
                if(map.get(b)<0&&resultList.size()>0){
                    break;
                }
                /*如果是符号位，直接丢进去*/
                if(map.get(b)<-1&&resultList.size()==0){
                    resultList.add(map.get(b));
                    i++;
                }
                /*如果是空格，则直接进1，进行下一次循环*/
                if(map.get(b) == -1 &&resultList.size() == 0){
                    i++;
                }
            }
        }

        Long result = 0L;
        int flag = 1;

        if(resultList.size() == 0){
            return  0;
        }
        int carry = resultList.size()-1;
        int item = 0;
        /*当第一位是空格的时候*/
        if(resultList.get(0)<0){
            item = 1;

            carry = carry -1;
            if(resultList.get(0) == -2){
                flag = -1;
            }

        }


        for(; item < resultList.size();item++){
            Double x = Math.pow(10,carry);
            if (  MAX_VALUE <resultList.get(item)* x){
                if(flag ==-1){
                    return MIN_VALUE;
                }else {
                    return MAX_VALUE;
                }
            }

            result =result + resultList.get(item)* x.intValue();
            carry=carry -1;
        }

        result = result*flag;
        result = result > MAX_VALUE?MAX_VALUE:result;
        result = result < MIN_VALUE?MIN_VALUE:result;

        return result.intValue();
    }

    public static void main(String[] args) {

        Solution01 solution01 = new Solution01();
        System.out.println("  +0123");
        System.out.println(solution01.myAtoi("  +0123"));
        System.out.println(0);
        System.out.println(solution01.myAtoi("  +-0123"));
        System.out.println(123);
        System.out.println(solution01.myAtoi("  +0000123"));

        System.out.println("   +0 123");
        System.out.println(solution01.myAtoi("   +0 123"));


        System.out.println("        +1003508d0457");
        System.out.println(solution01.myAtoi("        +1003508d0457"));
        System.out.println("       -1007013l2230");
        System.out.println(solution01.myAtoi("       -1007013l2230"));
        System.out.println("42");
        System.out.println(solution01.myAtoi("42"));
        System.out.println("-6147483648");
        System.out.println(solution01.myAtoi("-6147483648"));
    }

}
