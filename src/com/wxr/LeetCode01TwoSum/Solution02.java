package com.wxr.LeetCode01TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution02 {

    //两数之和，一遍哈希表

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        if(nums.length <= 0){
            return  result;
        }
        Map<Integer,Integer> numsMap = new HashMap<>();

        for(int i = 0 ;i < nums.length;i++){
            int complement = target - nums[i];
            if(numsMap.containsKey(complement)){
                result[0] = numsMap.get(complement);
                result[1] = i;
            }
            numsMap.put(nums[i],i);

        }

        return result;
    }




}
