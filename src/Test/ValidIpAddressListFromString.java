package Test;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddressListFromString {
    public static void main(String[] args) {
        System.out.println("Result:"+getIpList("1921680"));
    }

    private static List<String> getIpList(String s){
        List<String> result=new ArrayList<>();
        int i,j,k;
        for( i=1;i<Math.min(s.length(),4);i++) {
            String[] ipAddressList = new String[]{"", "", "", ""};
            ipAddressList[0] = s.substring(0, i);
            if (!isValidIp(ipAddressList[0])) {
                continue;
            }

            for (j = i + 1; j < i + Math.min(s.length() - i, 4); j++) {
                ipAddressList[1] = s.substring(i, j);
                if (!isValidIp(ipAddressList[1])) {
                    continue;
                }


            for (k = j + 1; k < j + Math.min(s.length() - j, 4); k++) {
                ipAddressList[2] = s.substring(j, k);
                ipAddressList[3] = s.substring(k);
                if (isValidIp(ipAddressList[2]) && isValidIp(ipAddressList[3])) {
                    result.add(String.join(".", ipAddressList));
                }
            }
        }
        }

        return result;

    }

    private static boolean isValidIp(String s){
        int i=Integer.parseInt(s);
        if(i>255){
            return false;
        }
        return s.length()==String.valueOf(i).length();
    }
}
