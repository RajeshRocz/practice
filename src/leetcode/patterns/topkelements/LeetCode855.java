package leetcode.patterns.topkelements;

import java.util.ArrayList;
import java.util.List;

public class LeetCode855 {
    private List<Integer> seats;
    private int totalSeats;

    public LeetCode855(int n) {
        this.totalSeats=n;
        this.seats=new ArrayList<>(n);
    }

    public int seat() {

    if(seats.isEmpty()){
        seats.addFirst(1);
        return 0;
    }
        return 0;
    }

    public void leave(int p) {

    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(5);

        System.out.println(integers);
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());

    }
}
