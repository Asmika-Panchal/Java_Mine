import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class recursion_main { 
    //n to 1 in decreasing order
    public static void printDec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
//1 to n in increasing order
public static void printInc(int n){
    if(n==1){
        System.out.print(n+" ");
        return;
    }
    printInc(n-1);
    System.out.print(n+" ");
    
}
//factorial
public static int factorial(int n){
    if(n==0){
        return 1;
    }
    int fnm1=factorial(n-1);
    int fn= n* factorial(n-1);
    return fn;
}

//sum of first n natural numbers
public static int sum(int n){
    if(n==1){
        return 1;
    }
    int snm1= sum(n-1);
    int sn=n+snm1;
    return sn;
}
//fibonaccii number //O(2^n)
public static int fibonacci(int n){
    if(n ==0 || n==1){
        return n;
    }
    int ans1=fibonacci(n-1);
    int ans2=fibonacci(n-2);
    int fn=ans1+ans2;
    return fn;
}

//check if array is sorted or not
public static boolean isSorted(int arr[], int i){
    if(i== arr.length-1){
        return true;
    }
    if(arr[i] > arr[i+1]){
        return false;
    }
    return isSorted(arr, i+1);
}
public static int firstOccurence(int arr[],int key, int i){
    if(i==arr.length){
        return -1;
    }
    if(arr[i]==key){
        return i;
    }
    return firstOccurence(arr,key, i+1);
}

public static int lastOccurence(int arr[], int key,int i){
    if (i==arr.length) {
        return -1;
    }

    int isFound=lastOccurence(arr, key, i+1);
    if(isFound ==-1 && arr[i]==key){
        return i;
    }
   return isFound;
}
public static int power(int x,int n){
    if(n==0)
    return 1;
    // int xm1=power(x,n-1);
    // int xn= x* xm1;
    // return xn;
    return x * power(x, n-1);
}

// 50. Pow(x, n)
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
// also for negavtive n case
public double myPow(double x, int n) {
    if(n==0){
       return 1;
    }
      if (n < 0) {
        x = 1 / x;  // Invert the base
        n = -(n + 1); // Safely negate n by adding 1 first (to avoid overflow for Integer.MIN_VALUE)
        return x * myPow(x, n); // Multiply by one extra x to adjust for the earlier offset
    }
    double halfPower= myPow(x,n/2);
    double halfPowersq= halfPower* halfPower;
    if(n% 2!=0){
        return x * halfPowersq;
    }
    return halfPowersq;
    
}
// Tiling Problem-- also for tiles -4 x 1
// Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile. 
public static int numberOfWays(int n) {
    if(n==0 || n==1)
    return 1;
    return numberOfWays(n-1) + numberOfWays(n-2);
}
//time limit exceeded so using this
public int climbStairs(int n) {
    int a=0,b=1,c=0;
    for(int i=0;i<n;i++){
        c=a+b;
        a=b;
        b=c;
    }
    return c;
}

//remove duplicates in a string
public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
   if(idx==str.length()){
    System.out.println(newStr);
    return;
   }
   char currChar= str.charAt(idx);
   if(map[currChar-'a']==true ){
    removeDuplicates(str, idx+1, newStr, map);
   }else{
    map[currChar -'a']= true;
    removeDuplicates(str, idx+1, newStr.append(currChar), map);
   }
}
public static int friendsPairing(int n){
    if(n==1 || n==2)
    return n;
    return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
}

public static void binaryStrings(int n, int lastPlace,String str){
    if(n==0){
        System.out.println(str);
        return;
    }
    binaryStrings(n-1, 0, str +"0");
    if(lastPlace==0){
        binaryStrings(n-1, 1, str +"1");
    }
} 

public static void linearOccurences(int arr[], int key,int i){
    if(i==arr.length){
        return;
    }
    if(arr[i]==key){
        System.out.print(i+" ");
    }
    linearOccurences(arr, key, i+1);
}

public static int subtringsstartend(String str, int i, int j,int n){
   if(n==1) 
    return 1;
   if(n<=0) 
    return 0;
   int res= subtringsstartend(str, i+1, j, n-1)+
   subtringsstartend(str, i, j-1, n-1)-
   subtringsstartend(str, i+1, j-1, n-2);
   if(str.charAt(i)== str.charAt(j)){
    res++;
   }
   return res;
}

public static void printdigits(int num){
    String digits[]={"Zero","One","Two","Three","Four","Five","Six","Seven",
"Eight","Nine"};
if(num==0)return;
int lastdigit= num%10;
printdigits(num/10);
System.out.print(digits[lastdigit]+" ");
}

public static int lengthofString(String str){
    if(str.length()==0 ||str.isEmpty() || str==null){
        return 0;
    }
    return lengthofString(str.substring(1)) +1;
}

//Tower Of Hanoi
public int towerOfHanoi(int n, int from, int to, int aux) {
    if(n==1){
     System.out.println("transfer disk "+ n+ "source " +from+ "to destination " +to);
        return 1;
    }
    //transfering n-1 from source to helper using destination as helper
    int moves1= towerOfHanoi(n-1,from,aux,to);
    
    //transfering 1
  System.out.println("transfer disk "+ n+ "source " +from+ "to destination " +to);
    
    //transfring n-1 from helper to destination using helper as source
    int moves2= towerOfHanoi(n-1,aux,to,from);
 
      return moves1+1+ moves2;
 }

 public static void reverseString(String str,int idx) {
    if(idx==0){
        System.out.print(str.charAt(idx));
        return;
    }
     System.out.print(str.charAt(idx));
     reverseString(str,idx-1);
}

public static int first=-1;
public static int last=-1;
public static void findOccurance(String str, int idx, char element){

   
    if(idx==str.length())
    {
        System.out.println("first: "+first);
        System.out.println("last: "+last);
        return;
    }
    char currCharr=str.charAt(idx);
    if(currCharr==element){
        if(first==-1){
            first=idx;
        }
        else{
           last=idx;
        }
        
    }
    findOccurance(str, idx+1, element);
}
//move all x to the end of string
public static void moveAllX(String str, int idx, int count, String newString){
    if(idx==str.length()){
        for(int i=0;i<count;i++){
            newString+= 'x';
        }
        System.out.println(newString);
        return;
    }

    char currChar= str.charAt(idx);
    if(currChar=='x'){
        count++;
        moveAllX(str, idx+1, count, newString);
    }else{
        newString+= currChar;
        moveAllX(str, idx+1, count, newString);
    }
}

// 283. Move Zeroes
// Given an integer array nums, move all 0s to the end of it while maintaining the relative order of the non-zero elements.
public void moveZeroes(int[] nums) {
    int left=0;
    for(int right=0; right<nums.length;right++){
        if(nums[right] !=0){
            int temp=nums[right];
            nums[right]= nums[left];
            nums[left]=temp;
            left++;
        }
    }
}

//print all subsequences of a string -abc  //O(2^n)
      public static void subsequences(String str, int idx, String newString){
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar=str.charAt(idx);
        //to be added
        subsequences(str, idx+1, newString+currChar);
        //not to be added
        subsequences(str, idx+1, newString);
      }

      //print unique subsequences
      public static void uniquesubsequences(String str, int idx, String newString, HashSet<String> set){
        if(idx==str.length()){
            if(set.contains(newString)){
                return;
            }else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar=str.charAt(idx);
        uniquesubsequences(str, idx+1, newString+currChar, set);
        uniquesubsequences(str, idx+1, newString, set);
      }
      //keypad combinations
      public static String keypad[]={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
      public static void printkeypad(String str, int idx, String combination){
            if(idx==str.length()){
              System.out.println(combination);
            return;
        }
        char currChar=str.charAt(idx);
        String mapping= keypad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            printkeypad(str, idx+1, combination+ mapping.charAt(i));
        }
      }
      //using arraylist
      public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if(digits== null || digits.length()==0){
        return result;
      } 
      String keypad[]={
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
      } ;
      backtrack(result,digits,0,"",keypad);
      return result;
    }
    private void backtrack(List<String> result, String digits, int idx, String combination,String keypad[]){
        if(idx== digits.length()){
            result.add(combination);
            return;
        }
        char currChar= digits.charAt(idx);
        String mapping=keypad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            backtrack(result,digits,idx+1,combination+mapping.charAt(i),keypad);
        }

    }

    public static void main(String[] args) {
      //  int n=6;
       // printDec(n);
       //printInc(n);
       //System.out.println(factorial(n));;
      //System.out.println( sum(n));;
      //System.out.print(fibonacci(n));
    //   int arr[]={1,2,3,7,6};
    //   System.out.println(isSorted(arr, 0));
// int arr[]={8,3,6,9,5,10,2,5,3};
// System.out.println(firstOccurence(arr,5,0));
// System.out.println(lastOccurence(arr, 5, 0));   
// System.out.println(power(2, 10));

// System.out.println(numberOfWays(5));
// String str="apnacollege";
// removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

// System.out.println(friendsPairing(3));

// binaryStrings(3, 0, "");
// int arr[]={3,2,4,5,6,2,7,2,2};
// linearOccurences(arr, 2, 0);
// printdigits(2024);
// System.out.println();

// String str="Asmika";
// System.out.print(lengthofString(str));

// String str="abcab";
// int n=str.length();
// System.out.println(subtringsstartend(str, 0, n-1, n));

// int n=3;
// recursion_main obj= new recursion_main(); 
// int totalMoves=obj.towerOfHanoi(n,1,3,2);
// System.out.println(totalMoves);
// String str = "hello";
// reverseString(str,str.length() - 1);

// String str="abaacdaefaah";
// findOccurance(str,0,'a');

// String str="axbcxxd";
// moveAllX(str, 0, 0, "");
// String str="abc";
// subsequences(str, 0, "");

// HashSet<String> set= new HashSet<>();
// uniquesubsequences("aaa", 0, "", set);
String str="23";
printkeypad(str, 0, "");
}
}
