import java.util.Scanner;

public class array {

    public static void update(int marks[]){
        for(int i=0;i<marks.length;i++){
            marks[i] +=1;
        }
    }

    public static void reversearray(int numbers[]){
        int first =0, last =numbers.length-1;
        while(first < last){
            //swap
            int temp= numbers[last];
            numbers[last]= numbers[first];
            numbers[first]= temp;
            first++;
            last--;
        }
    }
    public static void pairsArray(int numbers[]){
        int tp=0;
        for(int i=0; i< numbers.length;i++){
            int curr=numbers[i];
            for(int j=i+1; j< numbers.length; j++){
                System.out.print(" (" + curr + ","  +numbers[j]+ ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs: " +tp);
    }

    public static void subArray(int numbers[]){
        int tp=0;
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i< numbers.length;i++){
            int start=i;
           for(int j=i; j<numbers.length; j++){
            int end=j;
            for(int k= start; k<=end;k++){
                System.out.print(numbers[k] + " ");
                currSum += numbers[k];
            }
            // tp++;
            // System.out.println();
            System.out.println("Current Sum :" +currSum)
                if (maxSum < currSum){
                    maxSum= currSum;
                }
           } 
           System.out.println();
        }
       // System.out.println("total sub arrays: "+tp);
       
    }


    public static void main(String args[]){
        //list of elements of similar data type
        //datatype arrayname[]= new datatype[size];
        // int marks[]= new int[10];

        // System.out.println(marks.length);
    //    int   number[]={1,2,3,4,5,6,7,8,9,10};
    //   Scanner sc=new Scanner(System.in);
    //   marks[0]=sc.nextInt();
    //   marks[1]=sc.nextInt();
    //   marks[2]=sc.nextInt();

    //   System.out.println("phy: " +marks[0]);
    //   System.out.println("chem: " +marks[1]);
    //   System.out.println("maths: " +marks[2]);
    //  // marks[2]= 100;
    // //   
    // int percentage= (marks[0] + marks[1] + marks[2])/3;
    // System.out.println("percentage= " +percentage + "%");

    // int marks[]={97,98,99};
    // update(marks);
    // for(int i=0;i<marks.length;i++){
    //     System.out.print(marks[i] +" ");
    // }
    // System.out.println();
        int numbers[]={2,4,6,8,10};
        // reversearray(numbers);
        // for(int i=0;i<numbers.length;i++){
        //     System.out.print(numbers[i]+ " ");
        // }
        //pairsArray(numbers);
        subArray(numbers);

     }

}
