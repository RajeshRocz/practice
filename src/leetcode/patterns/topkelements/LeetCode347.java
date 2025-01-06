package leetcode.patterns.topkelements;

import java.util.*;

public class LeetCode347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> m : frequencyMap.entrySet()) {
            heap.add(m);
            if (heap.size() > k) heap.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            result[i++] = heap.poll().getKey();
        }

        return result;
    }
}
