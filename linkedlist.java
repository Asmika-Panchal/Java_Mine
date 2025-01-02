

import java.util.LinkedList;

public class linkedlist{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    public void addFirst(int data){  //O(1)
        //step1 = create new node
        Node newNode= new Node(data);
        size++;
        if(head == null){
        head=tail=newNode;
        return;
        }
        //step2- newNode's next= head
        newNode.next= head; //linking
        
        //step3 head= newNode
        head= newNode;
    }

    public void addLast(int data){   //O(1)
        //step1 = create new node
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail= newNode;
            return;
        }
        //step2- tail.'s next= newNode
        tail.next= newNode; //linking
        
        //step3 tail= newNode
        tail= newNode;
    }

    public void printLL(){  //O(n)
        if(head== null){
            System.out.println("LL is empty");
        }
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp= temp.next;
        }
        System.out.println("null");
    }

    public void addinMiddle(int idx,int data){  //O(n)
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode= new Node(data);
        size++;
        int i=0;
        Node temp=head;
        while(i< idx-1){
            temp=temp.next;
            i++;
        }
        //i=idx-1; temp-> prev
        newNode.next= temp.next;
        temp.next= newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head= head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //prev : i=size -2
        Node prev= head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
       int val=prev.next.data; //tail ka data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    
    public int iterativesearch(int key){ //O(n)
        Node temp=head;
        int i=0;
        while (temp !=null) {
            if(temp.data== key){
                return i;
            }
        temp=temp.next;
        i++;
        }
        
        //key not found
        return -1;
    }
    public int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
       int idx= helper(head.next, key);
       if(idx==-1){
        return -1;
       }
       return idx+1;
    }
    public int recursivesearch(int key){
        
       return helper(head, key);
    }

    public void reverse(){ //O(n )
        Node prev= null;
        Node curr= tail=head;
        Node next;
        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head= prev;
    }
    public void deleteNthfromEnd(int n){ //O(n)
        int size=0;
        Node temp=head;
        while(temp !=null){
            temp= temp.next;
            size++;
        }
        if(n==size){
            head=head.next;
            return;
        }
        //size-n
        int i=1;
        int itoFind=size-n;
        Node prev=head;
        while (i< itoFind) {
            prev= prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;

        //two pointer
        // ListNode dummy= new ListNode(-1);
        // dummy.next=head;

        // ListNode firstPtr= dummy;
        // ListNode secondPtr=dummy;
        // for(int i=0;i<n;i++){
        //     secondPtr= secondPtr.next;
        // }
        // while(secondPtr.next!=null){
        //     firstPtr=firstPtr.next;
        //     secondPtr= secondPtr.next;
        // }
        //  firstPtr.next=firstPtr.next.next;
        // return dummy.next;
    }
//palindrome linked list
    public boolean isPalindrome(Node head) {
        // Check for edge cases: empty list or single-node list
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle node
        Node mid = findMidNode(head);

        // Reverse the second half of the linked list
        Node curr = mid;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare the two halves
        Node right = prev; // This is the head of the reversed second half
        Node left = head;  // This is the head of the original list

        while (right != null) {
            if (left.data != right.data) {
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }

        return true; // All elements matched, it's a palindrome
    }

    private Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Move `slow` by 1 step and `fast` by 2 steps to find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // `slow` will point to the middle node
    }

    //detect cycle
    public static boolean hasCycle() {
        Node slow=head;
        Node fast= head;
        while( fast != null && fast.next != null ){
            slow=slow.next;
            fast= fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    //142. Linked List Cycle II
    public Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
    
            if (slow == fast) {
                Node ptr1 = head; // Start of the list
                Node ptr2 = slow; // Meeting point in the cycle
    
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
    
                return ptr1; // Starting node of the cycle
            }
        }
    
        return null; // No cycle
    }

    public static boolean removeCycle(){
        //detetct cycle
        //find meeting point
        //remove  cycle-> last.next=null
        Node slow = head;
        Node fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
    
            if (slow == fast) {
                Node ptr1 = head; // Start of the list
                Node ptr2 = slow; // Meeting point in the cycle
    
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                ptr2.next=null;
                return true; // Starting node of the cycle
            }
        }
        return false;
    }

    public static void main(String[] args) {
    //     linkedlist ll= new linkedlist();
    //     // ll.head= new Node(1);
    //     // ll.head.next= new Node(2);
       
    //     ll.addFirst(2);
       
    //     ll.addFirst(1);

    //     ll.addLast(4);
        
    //     ll.addLast(5);
        
    //     ll.addinMiddle(2, 3);
    //    // ll.printLL();
    //   //  ll.reverse();;
    //    // ll.removeFirst();
    // //    ll.removeLast();
   
    // ll.printLL();
    // ll.deleteNthfromEnd(3);
    // ll.printLL();
    //    System.out.println(ll.size);
    // System.out.println(ll.recursivesearch(5));
    // System.out.println(ll.recursivesearch(10));


    //using java collection frame work
//     LinkedList<Integer> lt = new LinkedList<>();
//     lt.addLast(1);
//     lt.addLast(2);
//     lt.addFirst(0);    
// System.out.println(lt);
// lt.removeLast();
// lt.removeFirst();
// System.out.println(lt);

    head = new Node(1);
   Node temp = new Node(2);
   head.next=temp;
    head.next.next = new Node(3);
    head.next.next.next = temp;
    // 1 -> 2 -> 3 -> 1
    
     System.out.println(hasCycle());
  System.out.println( removeCycle());;
    System.out.println(hasCycle());
    }
}
