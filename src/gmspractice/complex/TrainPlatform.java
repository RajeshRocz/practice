package gmspractice.complex;

import java.time.LocalTime;
import java.util.Arrays;

/*

"2. Given the arrival and departure times of all trains that reach a railway station,
the task is to find the minimum number of platforms required for the railway station
so that no train waits.
We are given two arrays that represent the arrival and departure times of trains that stop.
Examples:
Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00}
Output: 1
Explanation: Only one platform is needed."

 */
public class TrainPlatform {

    public static void main(String[] args) {

        String[] arrival = {"09:00", "09:40", "09:50", "11:00", "15:00", "18:00"};//{"09:00", "09:40" };//
        String[] departure = {"09:10", "12:00", "11:20", "11:30", "19:00", "20:00"};//{"09:10", "12:00" };//

        int platformsCount=findPlatforms(arrival, departure);
        System.out.println("findPlatforms:"+platformsCount);
        System.out.println("findplatforms1:" + findPlatforms1(arrival, departure));
    }

    private static int findPlatforms(String[] arrival, String[] departure) {
        LocalTime[] arr = new LocalTime[arrival.length];
        LocalTime[] dep = new LocalTime[departure.length];
        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            arr[i] = LocalTime.parse(arrival[i]);
            dep[i] = LocalTime.parse(departure[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 0;
        int maxPlatforms = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < n) {

            if (arr[i].isBefore(dep[j])) {
                platforms++;
                i++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
            } else {
                platforms--;
                j++;
            }

        }

        return maxPlatforms;


    }

    public static int findPlatforms1(String[] arrival, String[] departure) {

        int[] arr = new int[arrival.length];
        int[] dep = new int[departure.length];
        int n = arrival.length;

        for (int i = 0; i < n; i++) {

            arr[i] = convertToMinutes(arrival[i]);
            dep[i] = convertToMinutes(departure[i]);

        }

        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 0;
        int maxPlatforms = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                i++;
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
            } else {
                j++;
                platforms--;
            }

        }
        return maxPlatforms;
    }

    private static int convertToMinutes(String s) {
        String[] time = s.split(":");
        int hours = Integer.parseInt(time[0]);
        int mins = Integer.parseInt(time[1]);
        return hours * 60 + mins;
    }

}
