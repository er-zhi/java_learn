package problem_solving.LinkedList;
import java.util.*;

// https://leetcode.com/problems/middle-of-the-linked-list/

public class GetMiddle {

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int middle = list.size() / 2;

        return list.get(middle);
    }
}
