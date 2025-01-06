package leetcode.patterns.topkelements;

import java.util.*;

/*
You are given two string arrays positive_feedback and negative_feedback, containing the words denoting positive and negative feedback, respectively. Note that no word is both positive and negative.

Initially every student has 0 points. Each positive word in a feedback report increases the points of a student by 3, whereas each negative word decreases the points by 1.

You are given n feedback reports, represented by a 0-indexed string array report and a 0-indexed integer array student_id, where student_id[i] represents the ID of the student who has received the feedback report report[i]. The ID of each student is unique.

Given an integer k, return the top k students after ranking them in non-increasing order by their points. In case more than one student has the same points, the one with the lower ID ranks higher.
 */

public class LeetCode2512 {

    public static void main(String[] args) {
        LeetCode2512 leetCode2512 = new LeetCode2512();
        String[] positive_feedback = new String[]{"fkeofjpc", "qq", "iio"};
        String[] negative_feedback = new String[]{"jdh", "khj", "eget", "rjstbhe", "yzyoatfyx", "wlinrrgcm"};
        String[] report = new String[]{"rjstbhe eget kctxcoub urrmkhlmi yniqafy fkeofjpc iio yzyoatfyx khj iio", "gpnhgabl qq qq fkeofjpc dflidshdb qq iio khj qq yzyoatfyx", "tizpzhlbyb eget z rjstbhe iio jdh jdh iptxh qq rjstbhe", "jtlghe wlinrrgcm jnkdbd k iio et rjstbhe iio qq jdh", "yp fkeofjpc lkhypcebox rjstbhe ewwykishv egzhne jdh y qq qq", "fu ql iio fkeofjpc jdh luspuy yzyoatfyx li qq v", "wlinrrgcm iio qq omnc sgkt tzgev iio iio qq qq", "d vhg qlj khj wlinrrgcm qq f jp zsmhkjokmb rjstbhe"};
        int[] studentId = new int[]{96537918, 589204657, 765963609, 613766496, 43871615, 189209587, 239084671, 908938263};
        List<Integer> result = leetCode2512.topStudents(positive_feedback, negative_feedback, report, studentId, 3);
        System.out.println(result);


    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> nos = new HashSet<>(Arrays.asList(negative_feedback));

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue()
                        : b.getKey() - a.getKey()
        );
        for (int i = 0; i < student_id.length; i++) {
            int point = 0;
            String[] words = report[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                if (pos.contains(words[j])) {
                    point += 3;
                } else if (nos.contains(words[j])) {
                    point -= 1;
                }
            }

            Map.Entry<Integer, Integer> entry = new HashMap.SimpleEntry<>(student_id[i], point);
            minHeap.offer(entry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

}

