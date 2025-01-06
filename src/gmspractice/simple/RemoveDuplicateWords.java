package gmspractice.simple;

/*
"3. Remove the duplicate words from the given Sentence.
Ex:
a) Input: Good day day bye bye
output: Good day bye
b) input: greet the day user greet good day
output:greet the day user good"
 */

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateWords {
    public static void main(String[] args) {

        String input = "Good day day bye bye";

        System.out.println(removeDuplicateWord(input));
        System.out.println(removeDuplicateWord1(input));
        System.out.println(removeDuplicateWord2(input));

    }

    private static String removeDuplicateWord(String input) {
        Set<String> result = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                result.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        return String.join(" ", result);
    }

    private static String removeDuplicateWord1(String input) {
        var splits = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : splits) {
            if (!sb.toString().contains(s)) {
                sb.append(s).append(" ");
            }
        }

        return sb.toString();
    }

    private static String removeDuplicateWord2(String input) {
        var splits = input.split(" ");
        Set<String> resultSet=new LinkedHashSet<>(List.of(splits));


        return String.join(" ", resultSet);
    }
}
