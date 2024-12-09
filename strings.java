import java.util.Scanner;

public class strings {
    public static void printLetter(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+ " ");
        }
    }
    // A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
    // Alphanumeric characters include letters and numbers.
    // Given a string s, return true if it is a palindrome, or false otherwise.
    

    public boolean isPalindrome(String s) {
       String a=s.toLowerCase();
       int left=0; int right= a.length()-1;
        while(left<=right){
            char cleft=a.charAt(left);
            char cright=a.charAt(right);
            if(!Character.isLetterOrDigit(cleft)){
                left++;
            }
            else if(!Character.isLetterOrDigit(cright)){
                right--;
            }else{
                if(cleft != cright)
                return false;
                left++;
                right--;
            } 
        }
       return true;
    }

    public static float getShortestPath(String path){
      int x=0, y=0;
        for(int i=0;i<path.length();i++){
        char dir= path.charAt(i);
        //south
        if(dir =='S'){
            y--;
        }
       
       //north
       else if(dir == 'N'){
        y++;
       }
      
       //west
       else if(dir == 'W'){
        x--;
       }
       //east
      else{
        x++;
      }
    }
       int X2= x*x;
       int Y2 =y*y;
      return (float)Math.sqrt(X2+Y2);
        }
    
        public static String subString(String str,int si, int ei){
            String substr="";
            for(int i=si;i<ei;i++){
                substr+=str.charAt(i);
            }
            return substr;
        }

// 2129. Capitalize the Title
// You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:

// If the length of the word is 1 or 2 letters, change all letters to lowercase.
// Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
public static String capitalizeTitle(String s) {
    // Initialize the result string
    String ans = "";

    // Split the input string into an array of words
    String[] words = s.split(" ");

    // Iterate over each word in the array
    for (int i = 0; i < words.length; i++) {
        if (words[i].length() <= 2) {
            // Convert words of length 1 or 2 to lowercase
            ans += words[i].toLowerCase();
        } else {
            // Capitalize the first letter and lowercase the rest
            ans += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        // Add a space after each word except the last one
        if (i < words.length - 1) {
            ans += " ";
        }
    }

    
    // Return the result
    return ans;
}

//also this approach
class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() <= 2) {
                result.append(word.toLowerCase());
            } else {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase());
            }
            result.append(" "); // Add a space after each word
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}
    public static void main(String[] args) {
    //    char arr[]={'a','b','c','d'};
    //     String str="abcd";
    //     String str2=new String("axyz");
    //     System.out.println(arr);
    //     System.out.println(str);
    //     System.out.println(str2);
        Scanner sc=new Scanner(System.in);
        // String fname=sc.nextLine();
        // String lname=sc.nextLine();
        // String fullname= fname +" " +lname;
        // printLetter(fullname);
        //System.out.println(fullname.charAt(0));
        // System.out.println(fullname.length());
       // String path="WNEENESENNN";
        // System.out.println(getShortestPath(path));
        // String str1="Asmia";
        // String str2="Asmia";
        // String str= new String("Asmia");
        // if(str1== str2){
        //     System.out.println("strings are equal");
        // }else{
        //     System.out.println("strings are not equal");
        // }
        // if(str1.equals(str)){
        //     System.out.println("strings are equal");
        // }else{
        //     System.out.println("strings are not equal");
        // }
        //   String str="HelloWorld"; 
        //   System.out.println(subString(str, 5, 10));
        // String fruits[]={"apple","mango","banana"};
        // String largest= fruits[0];
        // for(int i=1;i<fruits.length;i++){
        //     if(largest.compareTo(fruits[i])<0){
        //         largest=fruits[i];
        //     }
        // }
        // System.out.println(largest);


        StringBuilder sb= new StringBuilder("");
        // sb.toString();
        for(char ch='a';  ch<='z';ch++){
            sb.append(ch);
        }
        System.out.println(sb.length());
    }

}