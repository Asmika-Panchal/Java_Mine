import java.util.HashSet;

public class toughq {
    public static int buyAndSellStocks(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0;i< prices.length; i++){
            if(buyPrice <prices [i]){
                //profit
                int profit= prices[i] - buyPrice; //todays profit 
                maxProfit =Math.max(maxProfit, profit); //max global profir
            }
            else{
                buyPrice =prices[i];
            }

        }
        return maxProfit;
    }
    //O(n)
    public static boolean containDuplicates(int nums[]){
        HashSet<Integer> numbers = new HashSet<>();
        for(int i=0;i< nums.length; i++){
            if(numbers.contains(nums[i]))
            return true;
            numbers.add(nums[i]);
        }
        return false;
    }
    //search in a rotated sorted array {Binary search} becoz of sorted
    // [1,2,3,4,5]  = [4,5,1,2,3] rotated at 4
    //identify the sorted half -left or right
        public static int RotatedArray(int arr[], int n, int target){
            int low= 0, high =n-1;
            while(low <= high){
                int mid= (low +high)/2;
                if(arr[mid] == target)
                return mid;

                //left sorted
                if(arr[low] <= arr[mid]){
                    if(arr[low] <= target && target <= arr[mid])
                    high= mid-1;
                    else
                    low= mid+1;

                    //right sorted
                }else{
                    if(arr[mid] <= target && target <=arr[high] )
                    low= mid+1;
                    else
                    high=mid-1;
                }
            }
            return -1;
        }

    public static void main(String args[]){
        // int prices[] ={7,1,5,3,6,4}; 
        // System.out.println(buyAndSellStocks(prices));

        // int nums[]={1,2,3,1};
        // System.out.println(containDuplicates(nums));

        int arr[]= {7, 8,9 ,1, 2, 3 , 4, 5 ,6};
        int target= 1;
        System.out.println(RotatedArray(arr,9,1));
    }
}
