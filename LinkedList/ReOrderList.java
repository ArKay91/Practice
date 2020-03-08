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

    public void reOList(ListNode head) {
        if (head == null) return;
        int size = size(head);
        if (size == 1) return;
        
        // Split list into two halves. Head and Tail.
        int half = size/2 + size%2;
        ListNode tail = head;
        ListNode headLast = head;
        for (int i=0; i<half; i++) {
            headLast = tail;
            tail = tail.next;
        }
        headLast.next = null;
        
        // Reverse tails order
        // and do final merge
        tail = reverse(tail);
        merge(head, tail);
    }
    
    private int size(ListNode head) {
        int size = 0;
        while(head != null) {
            size++ ;
            head = head.next;
        }
        return size;
    }
    
    private void merge(ListNode head, ListNode tail) {
        ListNode nextHead;
        while ((nextHead = head.next) != null) {
            ListNode nextTail = tail.next;
            head.next = tail;
            tail.next = nextHead;
            head = nextHead;
            tail = nextTail;
        }
        if (tail != null) {
            head.next = tail;
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
        
    }
}