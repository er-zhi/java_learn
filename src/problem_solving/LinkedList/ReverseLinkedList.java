package problem_solving.LinkedList;

public class ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // public ListNode reverseList(ListNode head) {
    //     if (head == null) return head;

    //     Stack<ListNode> stack = new Stack<>();

    //     while (head != null) {
    //         stack.push(head);
    //         head = head.next;
    //     }

    //     ListNode revesedHead = stack.pop();
    //     ListNode current = revesedHead;


    //     while (!stack.isEmpty()) {
    //         current.next = stack.pop();
    //         current = current.next;
    //     }

    //     current.next = null; // end Lincked list

    //     return revesedHead;
    // }

}
