package com.wxr.LeetCode01TwoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution01 {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        if(nums.length <= 0){
            return  result;
        }
        Map<Integer,Integer> numsMap = new HashMap<>();

        for(int i = 0 ;i < nums.length;i++){
            numsMap.put(nums[i],i);
        }

        for(int i = 0 ;i < nums.length;i++){

            int complement = target - nums[i];

            //numsMap.get 的目的是为了避免重复的值
            if(numsMap.containsKey(complement)&&numsMap.get(complement) != i){
                result[0] = i;
                result[1] = numsMap.get(target - nums[i]);
            }

        }
        return result;
    }

}
