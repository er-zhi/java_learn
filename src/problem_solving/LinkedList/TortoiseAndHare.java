package problem_solving.LinkedList;

//https://leetcode.com/problems/linked-list-cycle/

public class TortoiseAndHare {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}

/*
This implementation meets the requirement of constant space
O(1) and runs in
O(n) time.

### Detecting a Cycle in a Linked List: Theory and Explanation

To determine if a linked list contains a cycle, we can leverage Floyd's **Tortoise and Hare** algorithm, a classic technique that efficiently detects cycles in a sequence.

---

### 1. **What is a Cycle in a Linked List?**

A cycle in a linked list occurs when a node's `next` pointer points back to a previous node, forming a loop. This means following the `next` pointers will never reach `null` but instead loop infinitely through the same set of nodes.

#### Examples:
- **Cycle**: `3 -> 2 -> 0 -> -4 -> (back to 2)`
- **No Cycle**: `1 -> 2 -> 3 -> null`

---

### 2. **The Challenge**
Detecting a cycle requires knowing if any node is revisited. Using extra memory (like a `HashSet`) could solve this, but it requires \(O(n)\) space. The optimal solution, however, is to detect cycles in **O(1) space**.

---

### 3. **Floyd's Tortoise and Hare Algorithm**

This algorithm uses two pointers:
- **Tortoise** (Slow pointer): Moves 1 step at a time.
- **Hare** (Fast pointer): Moves 2 steps at a time.

#### Key Idea:
- If there’s no cycle, the fast pointer will eventually reach the end (`null`).
- If there’s a cycle, the fast pointer will eventually "lap" the slow pointer, meaning both pointers will meet inside the cycle.

---

### 4. **How It Works**

#### Step-by-Step Process:

1. **Initialization**:
   - Start both pointers at the head of the list.
   - Slow pointer moves 1 step per iteration (`slow = slow.next`).
   - Fast pointer moves 2 steps per iteration (`fast = fast.next.next`).

2. **Cycle Detection**:
   - If `fast` or `fast.next` becomes `null`, the list has no cycle.
   - If `slow` and `fast` meet at some point, a cycle is confirmed.

---

### 5. **Why It Works**

#### Intuition:
- Without a cycle:
  - Fast pointer will quickly reach the end of the list (`null`), confirming no cycle.

- With a cycle:
  - Since the fast pointer moves faster, it will eventually catch up to the slow pointer if they’re both trapped in the cycle.

#### Mathematical Explanation:
- Let the length of the non-cyclic part be \(d\).
- Let the cycle length be \(c\).
- After \(k\) steps:
  - Slow pointer will be at position \(d + k\) (inside the cycle).
  - Fast pointer will be at position \(d + 2k\) (also inside the cycle).
- Since they both move within a cycle, they’ll meet when their distance becomes a multiple of the cycle length.

---

### 6. **Complexity Analysis**

- **Time Complexity**: \(O(n)\)
  - Each pointer traverses at most \(n\) nodes, where \(n\) is the total number of nodes.

- **Space Complexity**: \(O(1)\)
  - Only two pointers are used, regardless of the input size.

---

### 7. **Key Takeaways**

- The Tortoise and Hare algorithm efficiently detects cycles in linked lists using constant space.
- It leverages two pointers moving at different speeds to determine if a cycle exists.
- It guarantees both optimal time and space complexity.

---

Let me know if you'd like further clarification or examples!

*/

