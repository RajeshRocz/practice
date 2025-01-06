package gmspractice.simple;

/*
"4. Find the weight of given String.
(A-Z/a-z) we have 26 alphabetic, consider the position of a-z alphabets as 1-26. Based on that find the weight of the given String.
Ex:
Given String: Apple
Output: 1+16+16+12+5 = 50"
 */
public class WeightOfString {
    public static void main(String[] args) {
        String input = "Apple".toLowerCase();
        int weight = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            weight += (c - 'a') + 1;
        }

        System.out.println("Weight=" + weight);
    }
}
