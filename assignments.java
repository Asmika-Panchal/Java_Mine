import java.util.*;
public class assignments {
    public static void main(String args[]){
        // Avg of 3 numbers
        Scanner sc=new Scanner(System.in);
        // float a =sc.nextFloat();
        // float b =sc.nextFloat();
        // float c =sc.nextFloat();
        // float avg=(a+b+c)/2;
        // System.out.println("Average of two numbers: "+avg);

        //square area
        // int side=sc.nextInt();
        // System.out.println("Area: "+ (side*side));

        //Bill with gst
        // System.out.println("Stationary Bill");
        // float pencil=sc.nextFloat();
        // float pen=sc.nextFloat();
        // float eraser=sc.nextFloat();
        // float total= pencil+pen+eraser;
        // float gst= 0.18f*total;
        // System.out.println("Total Bill: " +(total+gst));
    
        //no positive or negative
    //     int n=sc.nextInt();
    //     if (n>0){
    //         System.out.println("Number is greater than 0 : Positive");
    //     }else if (n<0){
    //         System.out.println("Number is less than 0 :Negative");
    //     }else{
    //         System.out.println("Number is 0 : Zero");
    //     }
    // }

    // double temp=103.5;
    // if(temp>100){
    //     System.out.println("You have a fever");
    // }
    // else{
    //     System.out.println("You are healthy");
    // }

    //print week day 
    // System.out.println("Enter a day: ");
    // int day=sc.nextInt();
    // switch (day) {
    //         case 1:
    //         System.out.println("Monday");
    //         break;
    //         case 2:
    //         System.out.println("Tuesday");
    //         break;
    //         case 3:
    //         System.out.println("Wednesday");
    //         break;
    //         case 4:
    //         System.out.println("Thursday");
    //         break;
    //         case 5:
    //         System.out.println("Friday");
    //         break;
    //         case 6:
    //         System.out.println("Saturday");
    //         break;
    //         case 7:
    //         System.out.println("Sunday");
    //         break;
    //         default:
    //         System.out.println("Invalid day");
    //         break;
    // }

    //leap year
    //  System.out.println("Enter a year: ");
    //  int year=sc.nextInt();
    //  if (year % 4==0 && (year % 100 !=0 || year % 400 ==0 )){
    //     System.out.println(year+" is a leap year");
    //  }
    //  else{
    //     System.out.println(year+" is not a leap year");
    //  }

    //sum of first n natural no
    // int n=sc.nextInt();
    // int sum=0;
    // int i=1;
    // do{
    //     sum=sum+i;
    //     i++;
    // }while(i<=n);
    // System.out.println("Sum of first "+n+" natural no is: "+sum);
    // int i=1;
    // while(i<=10){
    //     System.out.println(i);
    //     i++;
    // }

    // for(int i=1;i<=4;i++){
    //     System.out.println("****");
    // }
    
    //REVERSE of no
//     int n=10899;
//     while(n>0){
//         int lastdig= n%10;
//         System.out.print(lastdig);
//         n=n/10;
//     }
//     System.out.println();

//reverse the given number
//         int n=10899;
//         int rev=0;
//         while(n>0){
//             int lastdig=n%10;
//             rev= rev*10 + lastdig;
//             n=n/10;
           
// }
// System.out.println(rev);

// reads string of integers and prints sum of even and odd no
// int i=sc.nextInt();
// int evenSum=0;
// int oddSum=0;
// int choice=0;
// do{
//     if (i%2 ==0){
//         evenSum+=i;
//     }else{
//         oddSum+=i;
//     }
//     System.out.println("Do you want to continue? Press 1 for yes 0 for no");
//     choice=sc.nextInt();
// }while(choice==1);
// System.out.println("Sum of even numbers: "+evenSum);
// System.out.println("Sum of odd numbers: "+oddSum);


        //factorial
        // int num;
        // int fact=1;
        // System.out.println("Enter any positive number: ");
        // num=sc.nextInt();
        // for(int i=1;i<=num;i++){
        //     fact=fact*i;
        //    //System.out.println(fact);
        // }
        // System.out.println(fact);

        //multiplication no
        // int num=sc.nextInt();
        // for(int i=1; i<=10;i++){
        //     int table=0;
        //     table=num *i;
        //     System.out.println(num +"*"+ i  +"=" +(table));
        // }

        //prime no
            int n=sc.nextInt();
            if (n==2){
                System.out.println("n is prime"); 
            }
            else{
                boolean isPrime=true;
                // for(int i=2;i<=n-1;i++){

                for(int i=2;i<=Math.sqrt(n); i++){
                    if(n % i==0){    //n is a multiple of i
                        isPrime=false;
                    }
                }
                if(isPrime==true){
                    System.out.println(n +" is prime");
                }else{
                    System.out.println(n+ " is not prime");
                }
            }
           
}
}
