package codesignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinaMaxAverageGrade {

    public static void main(String[] args) {
        String[][] input=new String[][]  {
                {"Alex", "85"}, {"Rahul", "80"}, {"Tomas","85"}, {"Alex", "90"}, {"Rahul", "60"}
     };
        System.out.println("Result:"+getMaxAverage(input));
    }
    /** * For a given input 2D array of strings, find the maximum average grade, round off to the nearest floor integer.
     Input :
     {
     {“Alex”, “85”}, {“Rahul”, “80”}, {“Tomas”,”85”}, {“Alex”, “90”}, {“Rahul”, “60”}
     }
     Output : 87 * **/
    private static int getMaxAverage(String[][] grades){
        Map<String, List<Integer>> gradeMap=new HashMap<>();

        for(String[] s:grades){
            String name=s[0];
            int score=Integer.parseInt(s[1]);
            List<Integer> scoreList=new ArrayList<>();
            if(gradeMap.containsKey(name)){
                scoreList=gradeMap.get(name);
            }
            scoreList.add(score);
            gradeMap.put(name, scoreList);
        }

        int maxAverage=0;
        for(Map.Entry<String,List<Integer>> grade: gradeMap.entrySet()){

            List<Integer> scoreList=grade.getValue();
            int sum=0;
            for(Integer score:scoreList){
                sum+=score;
            }
            int average= (int) Math.floor(sum/scoreList.size());
            maxAverage=Math.max(maxAverage,average);

        }
  return maxAverage;
    }
}
