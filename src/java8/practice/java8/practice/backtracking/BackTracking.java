package java8.practice.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        Arrays.sort(nums);
        backTracking(list, new ArrayList(), nums, start);
        return list;
    }

    private static void backTracking(List<List<Integer>> list
            , List<Integer> tempList
            , int[] nums, int start) {

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> list = subsets(nums);
        list.forEach(System.out::println);

    }
}
