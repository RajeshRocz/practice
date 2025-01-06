package gmspractice.complex;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test {

    public static void main(String args[]) {

        var listStrings= List.of("abc","def","ghi","jkl","mno","pqr","stu","vwx","yz");
        String collect = listStrings.stream().collect(Collectors.joining(",","{","}"));
System.out.println(collect);

var ramdom=new Random(314L);
System.out.println(ramdom.nextInt());
System.out.println(ramdom.nextDouble());
System.out.println(ramdom.nextFloat());
System.out.println(ramdom.nextLong());
    }
}


