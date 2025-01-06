package gmspractice.simple;

/*
"2. Check the given String is Panagram or Not.
A. Check the string is Panagram or not
B. If not panagram , then print the missing letters
ex: The quick brown fox jumps over the lazy dog.
Write a program for Panagram Detector.

* The sentence ""The quick brown fox jumps over the lazy dog"" contains every single letter in the alphabet. Such sentences are called pangrams.
* Write a function called ""findMissingLetters""  which takes a String `sentence`,  and returns all the letters it is missing. Which prevent it from being a pangram.
* You should ignore the case of the letters in sentence, and your return should be all lower case letters, in alphabetical order.
* You should also ignore all non US-ASCII characters."
 */

public class PanagramString {

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the"; //lazy dog";
        boolean[] letterPresence = getLetterPresence(sentence);
        System.out.println("Is the sentence a panagram? " + isPanagram(letterPresence));
        System.out.println("Missing letters: " + findMissingLetters(letterPresence));
    }

    public static boolean isPanagram(boolean[] letterPresence) {

        for (boolean b : letterPresence) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static String findMissingLetters(boolean[] letterPresence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letterPresence.length; i++) {
            if (!letterPresence[i]) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }

    private static boolean[] getLetterPresence(String sentence) {

        boolean[] presence = new boolean[26];
        int index = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                index = c - 'A';
            } else if (c >= 'a' && c <= 'z') {
                index = c - 'a';
            } else {
                continue;
            }

            presence[index] = true;
        }
        return presence;

    }
}
