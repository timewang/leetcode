package org.snailgary;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *  两数之和
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for(int f = 0 ; f< nums.length ; f++){
            for(int i = f+1 ; i < nums.length ; i++){
                if((nums[f] + nums[i]) == target){
                    return new int[]{f,i};
                }
            }
        }
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
