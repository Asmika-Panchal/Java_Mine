import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    // [1,2,3,4,5]  = [4,5,1,2,3]  rotated at 4
    //identify the sorted half -left or right
        public static int RotatedArray(int arr[], int target){
            int n= arr.length;
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

        //rotate array leetcode 189
        public void rotate(int[] nums, int k) {
            int n=nums.length;
            k= k%n;
            reverse(nums,0, n-1);
            reverse(nums,0,k-1);
            reverse(nums,k,n-1);
    
        }
        public static void reverse(int nums[] , int start, int end){
            while(start< end){
                int temp= nums[start];
            nums[start]= nums[end];
            nums[end]= temp;
            start++;
            end--;
            }
        }

        //triplet sum 
         public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result= new HashSet<>();
        for( int i=0; i< nums.length-2; i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i] + nums[left] +nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[left],nums[right]));
                     left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
           
        }
         return new ArrayList<>(result);
    }

        //three sum closest
    // Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    // Return the sum of the three integers
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int resultSum= nums[0]+ nums[1] +nums[2];
            int minDifferenece= Integer.MAX_VALUE;
    
            for(int i=0;i< nums.length-2; i++){
                int left=i+1;
                int right= nums.length-1;
                while(left < right){
                 int sum= nums[i]+ nums[left] + nums[right];
                 if(sum==target){
                    return target;
                 }   
                 else if( sum< target){
                    left++;
                 }
                 else{
                    right--;
                 }
                 int differenceToTarget= Math.abs(sum- target);
                 if(differenceToTarget< minDifferenece){
                    resultSum=sum;
                    minDifferenece= differenceToTarget;
                 }
                }
            }
            return resultSum;
        }
    }


//two sum
public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        //<nums, index>
        for(int i=0;i< nums.length;i++){
            Integer value= map.get(target- nums[i]);
            if(value== null){
                map.put(nums[i],i);
            }
            else{
                arr[0]= i;
                arr[1]=value;
            }
        }
        return arr;
    }
    //majority element 
//     Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
    public int majorityElement(int[] nums) {
        int majority=nums[0], votes=1;
        for(int i=1;i< nums.length;i++){
         if(votes==0){
             votes++;
             majority=nums[i];
          }else if(majority == nums[i]){
             votes++;
          }else{
             votes--;
          }
        }
        return majority;
         }

//          single number
//          Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.
public int singleNumber(int[] nums) {
    int sing=nums[0];
    for(int i=1;i<nums.length;i++){
        sing= sing ^ nums[i];
    }
    return sing;
}

//summary ranges
// You are given a sorted unique integer array nums.

// A range [a,b] is the set of all integers from a to b (inclusive).

// Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
public List<String> summaryRanges(int[] nums) {
    List<String> list= new ArrayList<>();
    int n= nums.length;
     if (n == 0) return list; 
    for(int i=0;i< n;i++){
        int j=i;
        while(j+1< n && nums[j]+1 == nums[j+1]){
            j++;
        }
        if(j>i){
            list.add(nums[i]+ "->" + nums[j]);
        }else{
            list.add(nums[i]+ "");
        }
        i=j;
    }
    return list;
}
    public static void main(String args[]){
        // int prices[] ={7,1,5,3,6,4}; 
        // System.out.println(buyAndSellStocks(prices));

        // int nums[]={1,2,3,1};
        // System.out.println(containDuplicates(nums));

        int arr[]= {7, 8,9 ,1, 2, 3 , 4, 5 ,6};
        int target= 1;
        System.out.println(RotatedArray(arr,1));

    }
}
