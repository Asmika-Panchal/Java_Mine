public class dividenconquer {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    //forinteger array
    // public static void mergeSort(int arr[],int si,int ei){
    //     if(si>=ei){
    //         return;
    //     }
    //     int mid=si+(ei-si)/2;
    //     mergeSort(arr, si, mid);
    //     mergeSort(arr, mid+1, ei);
    //     merge(arr,si,mid,ei);
    // }
    // public static void merge(int arr[],int si,int mid, int ei){
    //     int temp[]= new int[ei-si+1];
    //     int i=si; // iterator for left part
    //     int j=mid+1; //iterator for right part
    //     int k=0;
    //     while(i<= mid && j<=ei){
    //         if(arr[i]< arr[j]){
    //             temp[k++]=arr[i++];
    //         }else{
    //             temp[k++]=arr[j++];
    //         }
    //     }

    //     //remaining left part
    //     while(i<=mid){
    //         temp[k++]=arr[i++];
    //     }

    //     while(j<=ei){
    //         temp[k++]=arr[j++];
    //     }
    //     //copy in original array
    //     for(k=0, i = si;k<temp.length;k++,i++){
    //         arr[i]=temp[k];
    //     }

    // }

//    public static void quickSort(int arr[], int low, int high) {
//        if(low<high){
//         int pi= partition(arr,low,high);
//         quickSort(arr,low,pi-1);
//         quickSort(arr,pi+1,high);
//        }
//     }

//   public  static int partition(int arr[], int low, int high) {
//        int pivot=arr[high];
//        int i=low-1;
//        for(int j=low;j<high;j++){
//            if(arr[j]<=pivot){
//                i++;
//                int temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//        }
//        i++;
//        int temp=arr[i];
//        arr[i]=arr[high];
//        arr[high]=temp;
//        return i;
//     }

    //for string array
    //changes made
    // public static void mergeSort(String[] arr, int si, int ei)
    // public static void merge(String[] arr, int si, int mid, int ei)
    // Original: if (arr[i] < arr[j])
    // Modified: if (arr[i].compareTo(arr[j]) < 0)
    // String[] temp = new String[ei - si + 1];

    // public static void mergeSort(String arr[],int si,int ei){
    //         if(si>=ei){
    //             return;
    //         }
    //         int mid=si+(ei-si)/2;
    //         mergeSort(arr, si, mid);
    //         mergeSort(arr, mid+1, ei);
    //         merge(arr,si,mid,ei);
    //     }
    //     public static void merge(String arr[],int si,int mid, int ei){
    //         String temp[]= new String[ei-si+1];
    //         int i=si; // iterator for left part
    //         int j=mid+1; //iterator for right part
    //         int k=0;
    //         while(i<= mid && j<=ei){
    //             if(arr[i].compareTo(arr[j])<0){
    //                 temp[k++]=arr[i++];
    //             }else{
    //                 temp[k++]=arr[j++];
    //             }
    //         }
    
    //         //remaining left part
    //         while(i<=mid){
    //             temp[k++]=arr[i++];
    //         }
    
    //         while(j<=ei){
    //             temp[k++]=arr[j++];
    //         }
    //         //copy in original array
    //         for(k=0, i = si;k<temp.length;k++,i++){
    //             arr[i]=temp[k];
    //         }
    
    //     }

    //for Inversion count of array
    public static int mergeSort(int arr[],int si,int ei){
            if(si>=ei){
                return 0;
            }
            int mid=si+(ei-si)/2;
           int leftCount= mergeSort(arr, si, mid);
            int rightCount= mergeSort(arr, mid+1, ei);
            int mergeCount=merge(arr,si,mid,ei);
        return leftCount +rightCount+ mergeCount;
        }
        public static int merge(int arr[],int si,int mid, int ei){
            int temp[]= new int[ei-si+1];
            int i=si; // iterator for left part
            int j=mid+1; //iterator for right part
            int k=0;
            int inversions=0;
            while(i<= mid && j<=ei){
                if(arr[i]< arr[j]){
                    temp[k++]=arr[i++];
                }else{
                    temp[k++]=arr[j++];
                    inversions+= (mid-i+1);
                }
            }
    
            //remaining left part
            while(i<=mid){
                temp[k++]=arr[i++];
            }
    
            while(j<=ei){
                temp[k++]=arr[j++];
            }
            //copy in original array
            for(k=0, i = si;k<temp.length;k++,i++){
                arr[i]=temp[k];
            }
            return inversions;   
        }
    public static void main(String[] args) {
       // int arr[]={6,3,9,5,2,8};
      // String[] arr = { "sun", "earth", "mars", "mercury" };
       
      //for inversion count
      int  arr[] = {2, 4, 1, 3, 5};
     // mergeSort(arr, 0, arr.length-1);
      int inversionCount = mergeSort(arr, 0, arr.length - 1);
      System.out.print("Sorted array: ");
      printArr(arr);
      System.out.println();
      System.out.println("Inversion Count: " + inversionCount);
        // quickSort(arr,0,arr.length-1);
      
    }
}
