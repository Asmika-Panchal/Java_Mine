import java.util.Scanner;

public class recursion{
    public static void display(int count){
       
        if(count == 3 ){
            return;
        }else{
            System.out.println(count);
            count++;
            display(count);
        }  
    }

    public static void name(int i,int n){
        //O(n) //O(n)
        if(i>n)
        return;
        System.out.println("Asmika");
        name(i+1, n);
    }
//print 1 to n
    public static void nn(int i,int n){
        if(i< n)
        return;
        System.out.println(i);
        nn(i+1, n);
    }
    //print 1 to n backtrack 
    public static void nnback(int i,int n){
        if(i< 1)
        return;
        nnback(i-1, n);
        System.out.println(i);
    }
    //print n to 1
    public static void nto1(int i,int n){
        if(i< 1)
        return;
        System.out.println(i);
        nto1(i-1, n);
    }
//print n to 1 backtrack
    public static void nto1back(int i,int n){
        if(i>n)
        return;
        nto1back(i+1, n);
        System.out.println(i);
    }

    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //nto1(n,n);
       // name(1,6);
       //nnback(n,n);
       nto1back(1,n);
        //display(0);
    }
}