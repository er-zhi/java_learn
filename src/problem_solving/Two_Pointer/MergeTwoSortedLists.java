package problem_solving.Two_Pointer;
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
public class MergeTwoSortedLists {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        // Default constructor
        ListNode() {}

        // Constructor with value
        ListNode(int val) {
            this.val = val;
        }

        // Constructor with value and next node
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Method to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify edge cases and initialize the merged list
        ListNode ans = new ListNode(0);
        ListNode tail = ans; // Tail pointer to keep track of the end of the merged list

        // Traverse both lists until one of them becomes null
        while (list1 != null && list2 != null) {
            // Compare the values at the current nodes of both lists
            if (list1.val <= list2.val) {
                // Attach the node from list1 to the merged list
                tail.next = list1;
                // Move to the next node in list1
                list1 = list1.next;
            } else {
                // Attach the node from list2 to the merged list
                tail.next = list2;
                // Move to the next node in list2
                list2 = list2.next;
            }
            // Move the tail pointer to the newly added node
            tail = tail.next;
        }

        // Attach any remaining nodes from list1 or list2 to the merged list
        tail.next = list1 != null ? list1 : list2;

        // Return the head of the merged list (skip the dummy node)
        return ans.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        // Traverse the list and print each node's value
        while (current != null) {
            System.out.print(current.val);
            // Add an arrow if this is not the last node
            if (current.next != null) {
                System.out.print(" -> ");
            }
            // Move to the next node
            current = current.next;
        }
        System.out.println(); // Newline for better readability
    }

    // Main method to demonstrate how the mergeTwoLists method works
    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // Create first sorted linked list: 1 -> 2 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Merge the two lists
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        System.out.print("Merged List: ");
        solution.printList(mergedList); // 1 -> 2 -> 2 -> 3 -> 4 -> 5 -> 6
    }
}

/*
Theory and Explanation
Problem Overview
We are tasked with merging two sorted singly-linked lists, list1 and list2, into one
sorted linked list. The goal is to create a new list that contains all the nodes from list1 and list2 in ascending order.

Approach
To solve this problem efficiently, we use the Two Pointers Technique, which involves iterating over both lists simultaneously:

Initialize Pointers:

Create a dummy node (ans) to act as the starting point of the merged list. This simplifies handling edge cases.
Initialize a tail pointer (tail) that will always point to the last node in the merged list.
Traverse and Compare:

While both list1 and list2 are not null:
Compare the values at the current nodes of list1 and list2.
Attach the node with the smaller value to tail.next.
Move the pointer (list1 or list2) from which the node was taken to its next node.
Advance the tail pointer to the newly added node.
Attach Remaining Nodes:

After one list is exhausted, attach the remaining nodes of the other list to the merged list.
Since both lists are sorted, the remaining nodes are already in ascending order.
Return Result:

Return ans.next, which points to the head of the merged list (excluding the dummy node).
Classification Pattern
Linked List Manipulation: Directly working with linked list nodes and pointers.
Two Pointers Technique: Simultaneously iterating over two data structures.
Merge Algorithm: Similar to the merge step in the Merge Sort algorithm.
Big O Complexity Analysis
Time Complexity: O(n + m)

Explanation: We traverse each node in list1 and list2 exactly once.
n: Number of nodes in list1.
m: Number of nodes in list2.
Space Complexity: O(1)

Explanation: We only use a constant amount of extra space for pointers (ans, tail, etc.).
The nodes from the original lists are rearranged to form the merged list without allocating additional nodes.
Why This Approach Works
Efficiency: By comparing nodes one by one, we ensure that at each step, the smallest possible node is added to the merged list.
In-Place Merge: We reuse existing nodes, which is memory-efficient.
Simplified Edge Cases: Using a dummy node helps avoid null checks when initializing the merged list.
Visualization Example
Let's consider an example where:

list1: 1 → 3 → 5
list2: 2 → 4 → 6
Merging Steps:

Initialization:

ans (dummy node): 0
tail: Points to ans.
First Iteration:

list1.val (1) ≤ list2.val (2)
Attach node 1 to merged list.
Move list1 to 3.
tail now points to node 1.
Second Iteration:

list1.val (3) > list2.val (2)
Attach node 2 to merged list.
Move list2 to 4.
tail now points to node 2.
Continue Similarly until one list is exhausted.

Attach Remaining Nodes:

After nodes 1, 2, 3, 4, 5, 6 are added, both lists are exhausted.
The merged list is: 1 → 2 → 3 → 4 → 5 → 6
Edge Cases Handled
Empty Lists:
If one or both lists are empty (null), the function correctly returns the non-empty list or null.
Duplicate Values:
Since we use <= in the comparison, duplicates from both lists are included in the merged list.
*/
