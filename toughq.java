import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

// 172. Factorial Trailing Zeroes
// Given an integer n, return the number of trailing zeroes in n!.
// Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
public int trailingZeroes(int n) {
    int count =0;
    while(n>=5){
        n/=5;
        count+=n;
    }
    return count;
}
//326power of three
// Given an integer n, return true if it is a power of three. Otherwise, return false.
// An integer n is a power of three, if there exists an integer x such that n == 3x.
public boolean isPowerOfThree(int n) {
    if(n<=0)
    return false;
    if(n==1)
    return true;
    while(n %3==0){
        n/=3;
    }
    return n==1;
}


//342power of four
// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.
public boolean isPowerOfFour(int n) {
    if(n<=0)
    return false;
    if(n==1)
    return true;
    while(n %4==0){
        n/=4;
    }
    return n==1;
}
 
// 191. Number of 1 Bits
// Given a positive integer n, write a function that returns the number of 
// set bits in its binary representation (also known as the Hamming weight). -count no of 1's
public int hammingWeight(int n) {
    String bin=Integer.toBinaryString(n);
    int ones=0;
    for(int i=0;i<bin.length();i++){
        if(bin.charAt(i)=='1'){
            ones++;
        }
    }
    return ones;
}
// int num = 5; // Binary: 101
// System.out.println("Hamming Weight: " + Integer.bitCount(num)); // Output: 2


//fibonacci
public int fib(int n) {
    if(n<=1)
    return n;
    int a=0,b=1,c=0;
    for(int i=2;i<=n;i++){
        c=a+b;
        a=b;
        b=c;
    }
    return c;
}

//1137. N-th Tribonacci Number
// The Tribonacci sequence Tn is defined as follows: 
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
public int tribonacci(int n) {
    if(n==0) return 0;
     if (n ==1 || n==2) {
     return 1; 
 }
 int a = 0, b = 1,c=1, d = 0;
 for (int i = 3; i <= n; i++) {
     d = a + b+c; 
     a = b;     
     b = c;
     c=d;    
 }
 return d; 
 }

// 215. Kth Largest Element in an Array
// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.
public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    int n=nums.length;
    return nums[n-k];
}

// 3264. Final Array State After K Multiplication Operations I
// You are given an integer array nums, an integer k, and an integer multiplier.
// You need to perform k operations on nums. In each operation:
// Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
// Replace the selected minimum value x with x * multiplier.
// Return an integer array denoting the final state of nums after performing all k operations.
public int[] getFinalState(int[] nums, int k, int multiplier) {
    for(int j=0;j<k;j++){
        int min=Integer.MAX_VALUE;
        int idx=0;
    for(int i=0;i< nums.length;i++){
       if(nums[i]< min){
        min=nums[i];
        idx=i;
       }
    }
    nums[idx]= nums[idx]* multiplier;
    }
    return nums;
}
// 896. Monotonic Array
// An array is monotonic if it is either monotone increasing or monotone decreasing.
// An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
// Given an integer array nums, return true if the given array is monotonic, or false otherwise.
public boolean isMonotonic(int[] nums) {
    boolean increasing =false;
    boolean decreasing=false;
    int n= nums.length;
    for(int i=0;i<n-1;i++){
        if(nums[i]< nums[i+1]){
            increasing=true;
        }
         if(nums[i] > nums[i+1]){
            decreasing=true;
        }
        
    }
    return !(increasing && decreasing);
}
//2190. Most Frequent Number Following Key In an Array
public int mostFrequent(int[] nums, int key) {
    Map<Integer,Integer> map= new HashMap<>();
    int result=0,maxFreq=0;
    for(int i=0;i< nums.length-1;i++){
        if(nums[i]==key){
            int target= nums[i+1];
        map.put(target,map.getOrDefault(target,0)+1);
        
        if(map.get(target) > maxFreq){
            result=target;
            maxFreq= map.get(target);
        }
    }
    }
    return result;
}
// 932. Beautiful Array
// An array nums of length n is beautiful if:
// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
// Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.
// For odd indices: The values are generated as  2 * element -1
// For even indices: The values are generated as 2 * element
public int[] beautifulArray(int n) { //O(2^n)
    ArrayList<Integer> ans= new ArrayList<>();
    ans.add(1);
    for(int i=2;i<=n;i++){
        ArrayList<Integer> temp= new ArrayList<>();
        for(Integer e: ans){
            if(2*e<=n){
                temp.add(2*e);
            }
        }
        for(Integer e: ans){
            if(2*e-1<=n){
                temp.add(e*2-1);
            }
        }
        ans=temp;
    }
  int[]result= new int[ans.size()];
  for(int i=0;i<ans.size();i++){
    result[i]=ans.get(i);
  }
return result;
}

//287. Find the Duplicate Number
public int findDuplicate(int[] nums) {
    // Initialize slow and fast pointers
int slow = nums[0];
int fast = nums[0];

// Step 1: Detect cycle using Floyd's Tortoise and Hare algorithm
do {
   slow = nums[slow]; // Move slow one step
   fast = nums[nums[fast]]; // Move fast two steps
} while (slow != fast); // Continue until they meet

// Step 2: Find the entry point (the duplicate number)
int ptr1 = nums[0]; // Start from the head of the array
int ptr2 = slow; // Start from the meeting point of the cycle

while (ptr1 != ptr2) {
   ptr1 = nums[ptr1]; // Move ptr1 one step
   ptr2 = nums[ptr2]; // Move ptr2 one step
}

return ptr1; //
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
