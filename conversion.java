import java.util.*;
public class conversion {
    public static void binToDec(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;

        while (binNum > 0) {
            int lastDig = binNum % 10;
            decNum = decNum + (lastDig * (int) Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }

        System.out.println("Binary to Decimal " + myNum + " = " + decNum);
    }

    public static void decToBin(int n){
        int pow=0;
        int binNum=0;
        int myNum=n;
        while(n >0){
            int rem= n % 2;
            binNum= binNum + (rem * (int) Math.pow(10, pow));
            pow++;
            n=n/2;
        }
        System.out.println("Binary form of " +myNum+ " = " +binNum );
    }


    public static void main(String args[]) {
        //binToDec(101);
        decToBin(11);
    }
}
