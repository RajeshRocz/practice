package leetcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6};
        Node head=new Node(nums[0]);
        Node nextNode=head;
        for(int i=1;i< nums.length;i++){
            Node temp=new Node(nums[i]);
            nextNode.next=temp;
            nextNode=temp;
        }
        Node dummy=head;
        while (dummy!=null){
            System.out.print("-> "+dummy.val);
            dummy=dummy.next;
        }
        System.out.println();
        Node dummy1=getReverseLinkedList(head);
        while (dummy1!=null){
            System.out.print("-> "+dummy1.val);
            dummy1=dummy1.next;
        }
    }

    private static Node getReverseLinkedList(Node head){

        Node current=head;
        Node prev=null;
        Node next;
        while(current!=null){

             next=current.next;
            current.next=prev;
            prev=current;
             current=next;

        }

        return prev;
    }
}

class Node{
    int val;
    Node next;

    public Node(int val){
        this.val=val;
    }
}


