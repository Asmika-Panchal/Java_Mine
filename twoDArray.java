import java.util.*;
public class twoDArray {
    public static boolean search(int matrix[][], int key){
        for(int i= 0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length; j++){
                if(matrix[i] [j] == key){
                    System.out.println("found at cell (" +i+ "," +j+ ")");
                    return true;
                }   
            }
        }
        System.out.println("key not found");
        return false;
    }

        public static void printSpiral( int matrix[][]){
            int startRow=0;
            int startCol=0;
            int endRow = matrix.length-1;
            int endCol = matrix[0].length-1;
            while(startRow <= endRow && startCol <=endCol){
                //top //j col //i row
                for(int j=startCol; j<=endCol; j++){
                    System.out.print(matrix[startRow][j] +" ");
                }
                //right
                for(int i=startRow +1; i<= endRow; i++){
                    System.out.print(matrix[i][endCol] +" ");
                }
                //bottom
                for(int j= endCol-1; j>=startCol; j--){
                    if(startRow== endRow)
                     return;
                    System.out.print(matrix[endRow][j] +" ");
                }
                //left
                for(int i=endRow-1; i>=startRow +1;i--){
                    if(startCol== endCol)
                     return;
                    System.out.print(matrix[i][startCol] +" "); 
                }
                startCol++;
                startRow++;
                endCol--;
                endRow--;
            }
            System.out.println();
        }

       public static int diagonalSum(int matrix[][]){

        // int sum=0;
        // for(int i=0; i< matrix.length;i++){
        //     for(int j=0; j<matrix[0].length;j++){
        //         if(i==j){
        //             sum+= matrix[i][j];
        //         }
        //         else if (i+j ==matrix.length-1 ){
        //             sum+= matrix[i][j];
        //         }
        //     }
        // }
        int sum=0;  //O(n)
        for(int i=0;i<matrix.length;i++){
            //pd
            sum+=matrix[i][i];
            //sd
            if(i !=matrix.length-1-i) //when i !=j
                sum+= matrix[i][matrix.length-1-i];
        }
        return sum;
       }

      public static boolean staircasesearchSorted(int matrix[][],int key){
        //int row= matrix.length-1 , col=0; (if 32 is used)
        // while(row >= 0 && col < matrix[0].length)

        int row=0, col=matrix[0].length-1;
        while(row< matrix.length && col >=0){
            if(matrix[row][col]==key){
                System.out.println("found key at (" +row+ "," +col+ ")");
                return true;
            }
            else if(key <= matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
           
        }
        System.out.println("key not found");
        return false;
      }
      //Print the number of 7’s that are inthe 2d array
      public static int sevenes(int array[][]){
        int count=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j< array[0].length;j++){
                if(array[i][j]==7){
                    count++;
                }
            }
        }
        return count;
      }

      //Print out the sum of the numbers inthe second row of the “nums” array
      public static int sum2rows(int nums[][]){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(i==1){
                for(int j=0;j< nums[0].length;j++){
                    sum = sum+ nums[i][j];
            }
            }
            
        }
        return sum;
      }

      //transpose of matrix
      public int[][] transpose(int[][] matrix) {
        int rows= matrix.length;
        int columns= matrix[0].length;
        int new_Matrix[][]= new int [columns][rows];
        for(int i=0;i< rows;i++){
            for(int j=0;j< columns;j++){
                new_Matrix[j][i]=matrix[i][j];
            }
        }
        return new_Matrix;
    }
    public static void main(String args[]){
    //    int matrix[][] =new int[3][3];
    //     Scanner sc=new Scanner(System.in);
    //     int n=matrix.length ,m=matrix[0].length;
    //     for(int i= 0;i<n;i++){
    //         for(int j=0;j<m; j++){
    //             matrix[i] [j]=sc.nextInt();
    //         }
    //     }
    //     for(int i= 0;i<n;i++){
    //         for(int j=0;j<m; j++){
    //             System.out.print(matrix[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    //     search(matrix,5);

    //spiral matrix (google, amazon, microsoft)
    // int matrix[][]= {{1,2,3,4},
    //                 {5,6,7,8},
    //                 {9,10,11,12},
    //                 {13,14,15,16}};
                   // printSpiral(matrix);
                   //System.out.println(diagonalSum(matrix));
                   int matrix[][]=   {{10,20,30,40},
                                {15,25,35,45},
                                {27,29,37,48},
                                {32,33,39,50}};
                                int key=33;
                              //  staircasesearchSorted(matrix,key);
                                
        int[][] array = {
            {4, 7, 8},
            {8, 8, 7}
        };
       // System.out.println(sevenes(array));

       int[][] nums = { {1,4,9},
                        {11,4,3},
                        {2,2,3} };
                        System.out.println("Sum: "+sum2rows(nums));
    }
}
