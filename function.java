import java.util.Scanner;

public class function {
    public static int printHelloWorld(){
        System.out.println("Hello World");
        return 3;
    }
    public static int sum(int a,int b){
         int sum=a+b;
        System.out.println(sum);
        return sum;
    }

    public static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
       
    }
    public static int product(int a, int b){
        int mul= a* b;
        System.out.println("multiply: " +mul);
        return mul;
    }

    

    public static void main(String args[]){
        //printHelloWorld();
         Scanner sc=new Scanner(System.in);
        // int a=sc.nextInt();
        // int b=sc.nextInt();
        // sum(a,b);

        //call by value
       int a= sc.nextInt();
       int b=sc.nextInt();
        //swap(a,b);
        // System.out.println("a= " +a);
        // System.out.println("b= " +b);
        //product(a,b);

        //factorial


    }
}
