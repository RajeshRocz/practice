package leetcode;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        System.out.println("Result:"+getFirstUniqueCharacterInString("leetcode"));
    }

    private static Character getFirstUniqueCharacterInString(String s){
        int[] alphabetic = new int[26];

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            alphabetic[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(alphabetic[c-'a']==1){
                return c;
            }
        }
        return null;
    }


}
