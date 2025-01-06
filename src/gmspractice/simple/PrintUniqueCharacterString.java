package gmspractice.simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
"5. Write a program to print .
A. all String which starts as ""S"" from the given String array
B. Find out if String has all Unique Characters
Ex:
Input: {""apple"",""sample"", ""search"",""cat""}
output: { ""sample"", ""search""}"
 */

public class PrintUniqueCharacterString {

    public static void main(String[] args) {

        String[] inputStrings= new String[]{"apple","sample", "search","cat"};
        List<String> outputStrings= new ArrayList<>();
        List<String> stringStartsWithS=new ArrayList<>();
        for(String s:inputStrings){
            if(isUniqueCharacterString(s)){
                outputStrings.add(s);
            }
            if(isStartWithS(s)){
                stringStartsWithS.add(s);
            }
        }
        System.out.println(outputStrings.stream().collect(Collectors.joining(",","{","}")));
        System.out.println(stringStartsWithS.stream().collect(Collectors.joining(",","{","}")));


    }

    private static boolean isUniqueCharacterString(String word){
        Set<Character> uniqueSet=new HashSet<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(uniqueSet.contains(ch)){
                return false;
            }
            uniqueSet.add(ch);
        }
        return true;
    }

    private static boolean isStartWithS(String word){
        return 'S' == word.charAt(0) || 's' == word.charAt(0);
    }
}
