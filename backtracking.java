import java.util.ArrayList;
import java.util.List;

public class backtracking {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void changeAr(int arr[],int i, int val){
        if(i==arr.length){
            printArr(arr);
            return;
        }
        //recursion
        arr[i]= val;
        changeAr(arr, i+1, val+1);
        arr[i]= arr[i]-2;
    }

//    78 subsets Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order

public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        generateSubsets(nums,0,new ArrayList<>(),result);
        return result;
    }
    private static void generateSubsets(int []nums,int idx,  List<Integer> current, List<List<Integer>> result){
        if(idx==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[idx]);
        generateSubsets(nums, idx+1, current, result);

        current.remove(current.size()-1);
        generateSubsets(nums, idx+1, current, result);

    }

    public static void findPermutation(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            String NewStr= str.substring(0,i)+ str.substring(i+1);
            findPermutation(NewStr, ans+currChar);
        }
    }

    //grid ways O(2^n+m)
    public static int gridWays(int i, int j,int n, int m){
        //base case
        if(i== n-1 || j==m-1){
            return 1;
        }else if( i==n || j==m){
            return 0;
        }
        return gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m);
    }

    //using linear time complexity O(n+m)
    public int uniquePaths(int m, int n) {
        return factorial(n-1+m-1)/(factorial(n-1)* factorial(m-1));
    }
    private static int factorial(int n){
        if (n == 0 || n == 1) return 1; 
        return n * factorial(n-1);
    }

    //code which gets accepted grid ways  O(min(n,m))
    // public static int uniquePaths(int m, int n) {
    // Use the combinatorial formula C(m + n - 2, n - 1)
//     long result = 1; // Use long to handle large values
//     int totalSteps = m + n - 2;
//     int stepsDown = Math.min(m - 1, n - 1); // Choose the smaller of the two for efficiency

//     // Compute the result iteratively to avoid overflow
//     for (int i = 1; i <= stepsDown; i++) {
//         result *= totalSteps--;
//         result /= i;
//     }

//     return (int) result; // Convert back to int since the result fits within int
// }

    //sudoku
    public static boolean isSafesudoku(int sudoku[][], int row, int col, int digit){
        //col
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //row
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        //grid
        int sr=(row/3) *3;
        int sc=(col/3)*3;
        //3*3 grid
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        // base case
        if(row==9){
            return true;
        }
        int nextRow=row, nextCol=col+1;
        if(col+1==9){
            nextRow= row+1;
            nextCol=0;
        }
        if(sudoku[row][col] !=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++ ){
            if(isSafesudoku(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
               if( sudokuSolver(sudoku, nextRow, nextCol)){
                return true;
               }
               sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int arr[]=new int[5];
        // changeAr(arr, 0, 1);
        // printArr(arr);
        // String str="abc";
        // findPermutation(str,"");
        // int n=3,m=3;
        // System.out.println(gridWays(0,0, n, m));
     int sudoku [] []= {{ 0, 0, 8, 0, 0, 0, 0, 0, 0},
                        {4, 9, 0, 1, 5, 7, 0, 0, 2},
                        {0, 0, 3, 0, 0, 4, 1, 9, 0},
                        {1, 8, 5, 0, 6, 0, 0, 2, 0},
                        {0, 0, 0, 0, 2, 0, 0, 6, 0},
                        {9, 6, 0, 4, 0, 5, 3, 0, 0},
                        {0, 3, 0, 0, 7, 2, 0, 0, 4},
                        {0, 4, 9, 0, 3, 0, 0, 5, 7},
                        {8, 2, 7, 0, 0, 9, 0, 1, 3} }; 
   
   if(sudokuSolver(sudoku, 0, 0))  {
    System.out.println("Solution exists");
    printSudoku(sudoku);
   }  else{
    System.out.println("Solution does not exist");
   }            
 }
    }

