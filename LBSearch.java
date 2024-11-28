import java.util.*;
public class LBSearch {
    public static int LinearSearch(int numbers[],int key){
        for(int i=0;i<=numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static int largest(int numbers[]){
        int large= Integer.MIN_VALUE;
        int small=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            if(large < numbers[i]){
                large= numbers[i];
            }
            if(small > numbers[i]){
                small = numbers[i];
            }
        }
        System.out.println("Smallest value is :" + small);
        return large;
   
    }

    public static int binarysearch(int numbers[], int key){
        int start=0, end= numbers.length-1;
        while(start <= end){
            int mid= (start+end)/2;

            if(numbers[mid] ==key){
                return mid;
            }
            if( numbers[mid] <key){ //right
                start=mid +1;
            }else{  //left
                end=mid-1;
            }

        }
        return -1;
    }

    public static void main(String args[]){
        int numbers[]={2,4,6,8,10,12,14,16};
        int key=14;
        // int index= LinearSearch(numbers, key);
        // if(index==-1){
        //     System.out.println("Key not found");
        // }
        // else{
        //     System.out.println("Key found at position: "+ index); 
        // }
       //  System.out.println("Largest no= "+largest(numbers));
    System.out.println("Index for key is: " +binarysearch(numbers,key));
    }
}
