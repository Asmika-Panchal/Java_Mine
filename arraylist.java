import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class arraylist {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp= list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static int containsWater(ArrayList <Integer> list){ //O(n^2)
        int maxWater= 0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                    int ht= Math.min(list.get(i), list.get(j));
                    int width= j-i;
                    int currWater= ht* width;
                    maxWater= Math.max(maxWater, currWater);
                
            }
        }
        return maxWater;
    }

    public static int twopointerMostWater(ArrayList <Integer> list){
        int max=0;
        int lp=0,rp=list.size()-1;
        while(lp<rp){
            int ht=Math.min(list.get(lp), list.get(rp));
            int width= rp-lp;

            int currWater= width*ht;
            max=Math.max(max, currWater);
            if(list.get(lp)< list.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return max;
    }

    public static boolean PairSum1(ArrayList<Integer> list, int target){
        int lp=0, rp=list.size()-1;
        while(lp< rp){
            if( list.get(lp) + list.get(rp)== target){
                return true;
            }else if(list.get(lp) + list.get(rp) < target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    //pair sum 2
    public static boolean Pairsum2(ArrayList<Integer> list, int target){
        int bp=-1;
        int n=list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i) > list.get(i+1)){
                bp=i;
                break;
            }
        }

        int lp=bp +1, rp=bp;
        while(lp !=rp){
            if(list.get(lp)+ list.get(rp)==target){
                return true;
            }else if(list.get(lp)+ list.get(rp)< target){
                lp=(lp+1) %n;
            }else{
                rp=(n+rp-1)%n;
            }

        }
        return false;
    }
// 2150. Find All Lonely Numbers in the Array
// You are given an integer array nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.
// Return all lonely numbers in nums. You may return the answer in any order
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer > map=new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> ans= new ArrayList<>();
        for(int num: nums){
            if(map.get(num)==1 && !map.containsKey(num+1)  && !map.containsKey(num-1) ){
                ans.add(num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //String | FLoat| Boolean
        // ArrayList<Integer> list= new ArrayList<>();
        // list.add(4);
        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);
       // System.out.println(list);
        //get op
        // int el=list.get(2);
        // System.out.println(el);
        //remove
        // list.remove(2);
        // System.out.println(list);
        //set op
        // list.set(2, 10);
        // System.out.println(list);
       //System.out.println( list.contains(4));;
        // list.add(1,9);
        // System.out.println(list);
        // System.out.println(list.size());
        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+" ");
        // }

        //print reverse -O(n)
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }

        //max of nos
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<list.size();i++){
        //     // if(max< list.get(i)){
        //     //     max=list.get(i);
        //     // }
        //     max=Math.max(max, list.get(i));
        // }
        
        // System.out.println(max);

        //swap 2 numbers
        // int idx1=1,idx2=3;
        // System.out.println(list);
        // swap(list,idx1,idx2);
        // System.out.println(list);

        // Collections.sort(list);
        // System.out.println(list);
        // Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);

        //multi dimensional arraylist
        // ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
        // ArrayList<Integer> list= new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // mainlist.add(list);

        // ArrayList<Integer> list2= new ArrayList<>();
        // list2.add(3);
        // list2.add(4);
        // mainlist.add(list2);
    
        // for(int i=0;i<mainlist.size();i++){
        //     ArrayList<Integer> currList=mainlist.get(i);
        //     for(int j=0;j<currList.size();j++){
        //         System.out.print(currList.get(j)+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(mainlist);

        //table format
    //     ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();
    //     ArrayList<Integer> list1=new ArrayList<>();
    //     ArrayList<Integer> list2=new ArrayList<>();
    //     ArrayList<Integer> list3=new ArrayList<>();
    //     for(int i=1;i<=5;i++){
    //     list1.add(i*1);
    //     list2.add(i*2);
    //     list3.add(i*3);
    //     }
    //    mainlist.add(list1);
    //    mainlist.add(list2);
    //    mainlist.add(list3);
    //     System.out.println(mainlist);

    //     for(int j=0;j<mainlist.size();j++){
    //         ArrayList<Integer> currList= mainlist.get(j);
    //         for(int i=0;i<currList.size();i++){
    //             System.out.print(currList.get(i)+" ");
    //         }
    //         System.out.println();
    //     }

    //container with most water
    ArrayList <Integer>list= new ArrayList<>();
    // list.add(1);
    // list.add(8);
    // list.add(6);
    // list.add(2);
    // list.add(5);
    // list.add(4);
    // list.add(8);
    // list.add(3);
    // list.add(7);
    //System.out.println(containsWater(list));
    //System.out.println(twopointerMostWater(list));
    
    //pair sum1
    // list.add(1);
    // list.add(2);
    // list.add(3);
    // list.add(4);
    // list.add(5);
    // list.add(6);
    // int target =5;
    // System.out.println(PairSum1(list, target));

    //pair sum2
    list.add(11);list.add(15);list.add(6);
    list.add(8);list.add(9);list.add(10);
    int target=16;
        System.out.println(Pairsum2(list, target));
    }
}
