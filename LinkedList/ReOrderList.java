// 1->2->3->4, reorder it to 1->4->2->3.
// 1->2->3->4->5, reorder it to 1->5->2->4->3.
public class ReOrderList{

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { this.val = x; }
    }

    public ReOrderList(){

    }

    public void reOList(ListNode head){
        if(head == null){
            return;
        }
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        
        while(fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        
        ListNode newList = reverse(slowPointer.next);
        slowPointer.next = null;
        slowPointer = head;
        
        ListNode next = null;
        
        while(newList != null){
            next = newList.next;
            newList.next = slowPointer.next;
            slowPointer.next = newList;
            newList = next;
            slowPointer = slowPointer.next.next;
        }
    }

    private static ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode next = null;
        ListNode prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;

        ReOrderList rOL = new ReOrderList();
        rOL.reOList(head);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}