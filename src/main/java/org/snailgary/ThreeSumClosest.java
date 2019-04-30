package org.snailgary;

import org.junit.Test;

import java.util.*;

public class ThreeSumClosest {

    /**
     * 思路，计算出数组中每个字母与其他两个字母的排列组合方式
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Map<Integer, Integer> targetMinus = new HashMap<>();
        //List<Integer> results = new ArrayList<>();
        Arrays.sort(nums);
        Integer temp = null;
        for (int i = 0; i < nums.length - 2; i++) {



            int right = nums.length - 1,left = right - 1;
            while (right > i && i < left - 1) {
                left = right - 1;
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println("sum: " + sum);
                int targetMinusSum = target - sum;
                if (targetMinusSum < 0) {
                    targetMinusSum = Math.abs(targetMinusSum);
                }
                if (temp == null) {
                    temp = targetMinusSum;
                    targetMinus.put(targetMinusSum, sum);
                    //lo++;
                } else if (targetMinusSum < temp) {
                    temp = targetMinusSum;
                    targetMinus.put(targetMinusSum, sum);
                    //hi--;
                }
                right--;

            }
            int lo = i + 1, hi = nums.length - 1;//int right = nums.length - 1,left = right - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                //int sum1 = nums[i] + nums[left] + nums[right];
                System.out.println("sum: " + sum);
                int targetMinusSum = target - sum;
                if (targetMinusSum < 0) {
                    targetMinusSum = Math.abs(targetMinusSum);
                }
                if (temp == null) {
                    temp = targetMinusSum;
                    targetMinus.put(targetMinusSum, sum);
                    //lo++;
                } else if (targetMinusSum < temp) {
                    temp = targetMinusSum;
                    targetMinus.put(targetMinusSum, sum);
                    //hi--;
                }
                lo++;

            }


        }
        System.out.println(targetMinus);
        System.out.println(temp);
        if (targetMinus.size() > 0) {
            return targetMinus.get(temp);
        }
        return 0;
    }

    @Test
    public void test() {
        int[] a = {1,2,4,8,16,32,64,128};
        int target = 82;
        threeSumClosest(a, target);

    }

}
