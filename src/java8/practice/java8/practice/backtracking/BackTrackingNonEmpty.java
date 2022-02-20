package java8.practice.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingNonEmpty {

    static List<List<Integer>> subsets(int []nums) {
        List<List<Integer>> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backTrackingNonEmpty(tempList, new ArrayList<>(), nums, 0);
        return tempList;
    }
    static void backTrackingNonEmpty(List<List<Integer>> tempList, List<Integer> list, int[] nums, int start) {
        if(list.size() > 0)
            tempList.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backTrackingNonEmpty(tempList, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> list = subsets(nums);
        list.forEach(System.out::println);
    }
}
