package leetcode;

public class LinkedListAddTwoNumbersLC2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head=new ListNode(0);
        ListNode tail=head;
        int yield=0;
        while(l1!=null || l2!=null || yield!=0){
            int l1Val= l1!=null?l1.val:0;
            int l2Val= l2!=null?l2.val:0;

            int currentValue=(yield+l1Val+l2Val)%10;
            yield=(yield+l1Val+l2Val)/10;

            ListNode temp=new ListNode(currentValue);
            tail.next=temp;
            tail=tail.next;

            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        ListNode dummy=head;
        head=head.next;
        dummy.next=null;
        return head;
    }

}

  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
