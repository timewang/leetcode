package org.snailgary;

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

}
