public class sorting {
    
    //pick the largest element from array and place at Last
    public static void bubbleSort(int arr[]){
          for(int turn=0;turn <arr.length -1;turn++ ){

            for(int j=0; j<arr.length -1- turn; j++){
                if(arr[j ] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] =temp;
                }
            }
          }
    }
    //pick the smallest element from array and place at start
    public static void selectionSort(int arr[]){
        for(int i =0; i< arr.length- 1;i++){
            int small= i;
       for( int j= i+1; j<arr.length; j++){
        if(arr[small] > arr[j]){
            small=j;
        }
       }
       int temp=arr[small];
                    arr[small]= arr[i];
                    arr[i] =temp;
        }
    }

    //pick an element from unsorted part and place in right position in sorted part
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr= arr[i];
            int prev= i-1;
            //finding out the correct position to start
            while(prev >=0 && arr[prev] > curr ){
                arr[prev +1] = arr[prev];
                prev --;
            }
            //insertion
            arr[prev +1] =curr;
        }

    }

    public static void countingSort(int arr[]){
        int largest= Integer.MIN_VALUE;
        //find largest no= length of array
        for(int i=0; i< arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }
        //frequency count
        int count[]= new int[largest+1];
        for(int i=0;i<arr.length; i++){
            count[arr[i]]++;
        }
        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i] >0){
                arr[j] =i;
                j++;
                count[i]--;
            }
        }
    }
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[] ={ 1,4,1,3,2,4,3,7};
        //bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        countingSort(arr);
        printArr(arr);
    }
}
