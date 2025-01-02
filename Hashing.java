import java.util.HashMap;
import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //number hashing
        // Read the size of the array
        // int n = sc.nextInt();
        // int[] arr = new int[n];

        // // Read the array elements
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }

        // // Precompute hash values
        // int[] hash = new int[13]; // Assuming max value in array is 12
        // for (int i = 0; i < n; i++) {
        //     hash[arr[i]]++;
        // }

        // // Process queries
        // int q = sc.nextInt();
        // while (q-- > 0) {
        //     int number = sc.nextInt();
        //     // Fetch and print the frequency of the number
        //     System.out.println(hash[number]);
        // }

        // sc.close();

        //character hashing
         // Input string
        //  String s = sc.next();

        //  // Precompute hash for character frequencies
        //  int[] hash = new int[256]; // For all ASCII characters
        //  for (int i = 0; i < s.length(); i++) {
        //      hash[s.charAt(i)]++;
        //  }
 
        //  // Process queries
        //  int q = sc.nextInt();
        //  while (q-- > 0) {
        //      char c = sc.next().charAt(0); // Read character
        //      // Fetch and print the frequency of the character
        //      System.out.println(hash[c]);
        //  }
 
        //  sc.close();

        // using hashMap
         // Input size of the array
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Initialize HashMap for frequency counting
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // Input array elements and update frequencies
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }

        // Process queries
        int q = sc.nextInt();
        while (q-- > 0) {
            int number = sc.nextInt();
            // Fetch frequency from map
            System.out.println(mpp.getOrDefault(number, 0));
        }

        sc.close();
    }
}
