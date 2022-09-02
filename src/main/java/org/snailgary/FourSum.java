package org.snailgary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 四数之和
 * https://leetcode.cn/problems/4sum/
 * Created by wangzhongfu on 2022/9/2
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int i1 = i + 1; i1 < length - 2; i1++) {

                if (i1 > i + 1 && nums[i1] == nums[i1 - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[i1] + nums[i1 + 1] + nums[i1 + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[i1] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                int j = i1 + 1, k = length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[i1] + nums[j] + nums[k];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[i1], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]){
                            j++;
                        }
                        j++;
                        while (j < k && nums[k] == nums[k - 1]){
                            k--;
                        }
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }

                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, -2, 1, 2], [-1, -1, 0, 2], [-1, 0, 0, 1]]
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new FourSum().fourSum(nums, target));
    }

}
