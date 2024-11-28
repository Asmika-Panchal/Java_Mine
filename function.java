import java.util.Scanner;

public class function {
    public static int printHelloWorld(){
        System.out.println("Hello World");
        return 3;
    }
    // public static int sum(int a,int b){
    //      int sum=a+b;
    //     System.out.println(sum);
    //     return sum;
    // }

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

    public static int factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }
        return f;
    }

    public static int binCoeff(int n, int r){
       int n_fact=factorial(n);
        int r_fact=factorial(r);
        int nmr_fact=factorial(n-r);
        int binCoeff= n_fact/ (r_fact * nmr_fact);
        return binCoeff;
    }
    public static int sum(int a, int b){
        return a+b;
    }
    public static float sum(float a, float b, float c){
        return a+b+c;
    }

    public static int avg(int a, int b, int c){
        int avg= (a+b+c)/3;
        return avg;
       
    }
    
    public static boolean isEven(int n){
        if(n % 2==0){
            return true;
        }
        return false;
    }

    //palindrome
    public static int isPalindrome(int n){
        int rev=0;
        
        while(n >0){
            int lastdig= n%10;
            rev = (rev* 10)+ lastdig;
            n= n/10; 
             }
          return rev;  
        }
        
        public static boolean checkPalind(int n){
            int reversed = isPalindrome(n);
            return n == reversed; 
        }
    
        public static int sumofDigits(int n){
            int sum=0;
            int lastDig=0;
            while(n >0){
                lastDig= n %10;
                sum =sum + lastDig;
                n= n/10;
            }
            return sum;
        }

    public static void main(String args[]){
        //printHelloWorld();
         Scanner sc=new Scanner(System.in);
        // int a=sc.nextInt();
        // int b=sc.nextInt();
        // sum(a,b);

        //call by value
       //int a= sc.nextInt();
       //int b=sc.nextInt();
        //swap(a,b);
        // System.out.println("a= " +a);
        // System.out.println("b= " +b);
        //product(a,b);

        //factorial
        //System.out.println(factorial(4));

       // System.out.println(binCoeff(5,2));

    //    System.out.println(sum(3,5));
    //    System.out.println(sum(5.2f,2.4f,1.5f));

        //avg
       // System.out.println(avg(1,2,3));

       //isEven
    //    int n=sc.nextInt();
    //    if(n % 2==0){
    //     System.out.println("Number is even");
    //    }else{
    //     System.out.println("Number is odd");
    //    }
    int n=sc.nextInt();
    // if (checkPalind(n)) {
    //     System.out.println(n + " is a palindrome.");
    // } else {
    //     System.out.println(n + " is not a palindrome.");
    // }
       
        System.out.println("Sum of digits: " +sumofDigits(n));
    }
}
