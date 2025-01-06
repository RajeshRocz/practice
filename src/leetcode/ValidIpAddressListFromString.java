package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddressListFromString {

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> result=new ArrayList<>();

        for(int i=1;i<Math.min(string.length(), 4);i++){
            String[] tempList=new String[]{"","","",""};
            tempList[0]=string.substring(0,i);
            if(!isValid(tempList[0])){
                continue;
            }
            for(int j=i+1;j<i+Math.min(string.length()-i, 4);j++){
                tempList[1]=string.substring(i,j);
                if(!isValid(tempList[1])){
                    continue;
                }
                for(int k=j+1;k<j+Math.min(string.length()-j, 4);k++) {
                    tempList[2] = string.substring(j, k);
                    tempList[3] = string.substring(k);
                    if (isValid(tempList[2]) && isValid(tempList[3])) {
                        String t = String.join(".",tempList);
                        result.add(t);
                    }
                }

            }
        }


        return result;
    }

    private boolean isValid(String s){

        int value=Integer.parseInt(s);
        if(value>255){return false;}
        return s.length()==String.valueOf(value).length();

    }

    public static void main(String[] args) {
        ValidIpAddressListFromString obj=new ValidIpAddressListFromString();
        ArrayList<String> strings = obj.validIPAddresses("1921680");
        System.out.println(strings);
    }
}

