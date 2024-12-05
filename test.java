public class test {
    public static void printPairs(int arr[]){
        int totalPairs=0; 
        for(int i=0;i< arr.length;i++){
            int curr= arr[i];
            for(int j=i+1;j<arr.length;j++){
                System.out.print(" (" +curr+ "," + arr[j]+ ")");
                totalPairs++;
            }
            System.out.println();
        }
       System.out.println("total pairs: "+totalPairs);
    }
    
    public static void Printsubarray(int arr[]){
        int totalSubArrays=0;
        for(int i=0;i<arr.length;i++){
           
            for(int j=i;j<arr.length;j++){
            
                for(int k=i; k<= j;k++){
                    System.out.print(arr[k]+ " ");
                }
                totalSubArrays++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total sub array pairs: "+totalSubArrays);
    }
    public static void main(String args[]){
        int arr[]={2,4,6,8,10};
        //printPairs(arr);
        Printsubarray(arr);
       
    }

}