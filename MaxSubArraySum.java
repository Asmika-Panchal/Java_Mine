public class MaxSubArraySum {
 
//bruteforce
// public static void maxsubArray(int numbers[]){
//     int tp=0;
//     int currSum=0;
//     int maxSum=Integer.MIN_VALUE;
//     int prefix[]= new int[numbers.length];
//     prefix[0]= numbers[0];
//     //calculate prefix
//     for(int i=1;i< prefix.length;i++){
//         prefix[i] =prefix[i-1] + numbers[i];

//     }

//     for(int i=0;i< numbers.length;i++){
//         int start=i;
//        for(int j=i; j<numbers.length; j++){
//         int end=j;
//         // currSum=0;
//         // for(int k= start; k<=end;k++){
//         //     System.out.print(numbers[k] + " ");
//         //     currSum += numbers[k];
//         // }
//         // tp++;
//         // System.out.println();
//         currSum=start==0 ? prefix[end] : prefix[end]- prefix[start-1];
//         //System.out.println("Current Sum :" +currSum);
//             if (maxSum < currSum){
//                 maxSum= currSum;
//             }
//        } 
//        System.out.println();
//     }
//    // System.out.println("total sub arrays: "+tp);
//    System.out.println("Max Sum: " +maxSum);
// }

public static void kadanes(int numbers[]){
    int ms=Integer.MIN_VALUE;
    int cs=0;
    for(int i=0; i< numbers.length;i++){
        cs=cs +numbers[i];
        if(cs<0){
            cs=0;
        }
        ms=Math.max(cs,ms);
    }
    System.out.println("our max array sum: "+ms);
}

    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            currSum = currSum+nums[i];
            if(currSum<0){
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        //All negative or 0 case
        if(maxSum == 0){
            maxSum = Integer.MIN_VALUE;
            
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    return 0;
                }
                maxSum = Math.max(maxSum, nums[i]);
            }
            return maxSum;
        }
        return maxSum;
    }

   public static void main(String args[]){
   // int numbers[]={2,4,6,8,10};
   int numbers[]={-2,-3,4,-1,-2,1,5,-3};
    kadanes(numbers);
   }
}
