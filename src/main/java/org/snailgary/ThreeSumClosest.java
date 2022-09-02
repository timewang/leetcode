package org.snailgary;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 */
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

    public int threeSumClosestOfficial(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    @Test
    public void test() {
        int[] a = {1,2,4,8,16,32,64,128};
        int target = 82;
        System.out.println(threeSumClosest(a, target));

    }

}
