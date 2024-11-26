package problem_solving.Graph;
// https://leetcode.com/problems/accounts-merge/
import java.util.*;

public class Accounts_Merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Build the adjacency list for the graph
        Map<String, Set<String>> adj = new HashMap<>();
        for (List<String> account : accounts) {
            String email1 = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String curEmail = account.get(i);

                if (!adj.containsKey(email1)) {
                    adj.put(email1, new HashSet<>());
                }
                adj.get(email1).add(curEmail);

                if (!adj.containsKey(curEmail)) {
                    adj.put(curEmail, new HashSet<>());
                }
                adj.get(curEmail).add(email1);
            }
        }

        // Set to track visited emails
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        // Perform DFS for each account's first email
        for (List<String> account : accounts) {
            String email1 = account.get(1);
            if (visited.contains(email1)) continue;

            // Collect all connected emails
            List<String> mergedEmails = new ArrayList<>();
            dfs(email1, adj, mergedEmails, visited);

            // Sort collected emails lexicographically
            Collections.sort(mergedEmails);

            // Add the name to the beginning of the list
            mergedEmails.add(0, account.get(0));

            // Add to the result
            result.add(mergedEmails);
        }

        return result;
    }

    // DFS to traverse and collect connected emails
    private void dfs(String email, Map<String, Set<String>> adj, List<String> mergedEmails, Set<String> visited) {
        if (visited.contains(email)) return;

        visited.add(email);
        mergedEmails.add(email);

        // Check if the email exists in the adjacency map
        if (adj.containsKey(email)) {
            for (String nextEmail : adj.get(email)) {
                dfs(nextEmail, adj, mergedEmails, visited);
            }
        }
    }
}

/*
 * The solution uses a graph-based approach to merge accounts with overlapping emails.
 *
 * Steps:
 * 1. **Graph Construction**:
 *    - Treat each email as a node.
 *    - Create edges between emails belonging to the same account.
 *    - This is achieved by iterating through each account and connecting the first email with every other email in the account.
 *
 * 2. **DFS Traversal**:
 *    - Use Depth-First Search (DFS) to find all emails connected to a starting email.
 *    - Mark emails as visited to ensure no email is processed more than once.
 *    - Collect all emails connected to the current email into a single group (merged emails).
 *
 * 3. **Sorting**:
 *    - After collecting all emails in a group, sort them lexicographically.
 *
 * 4. **Adding Account Name**:
 *    - Add the account holder's name (first element of the original account) as the first element of the sorted list.
 *
 * 5. **Result Construction**:
 *    - Repeat the process for all accounts and return the merged accounts.
 *
 * Example Walkthrough:
 * --------------------
 * Input:
 * accounts = [
 *     ["A", "a1", "a2"],
 *     ["A", "a2", "a3"],
 *     ["B", "b1"],
 *     ["A", "a4"]
 * ]
 *
 * Step 1: Graph Construction
 * ---------------------------
 * For each account, connect emails in the adjacency list:
 * - Account 1: Connect "a1" with "a2".
 * - Account 2: Connect "a2" with "a3".
 * - Account 3: "b1" has no connections.
 * - Account 4: "a4" has no connections.
 *
 * Adjacency List:
 * {
 *   "a1": ["a2"],
 *   "a2": ["a1", "a3"],
 *   "a3": ["a2"],
 *   "b1": [],
 *   "a4": []
 * }
 *
 * Step 2: DFS Traversal
 * ---------------------
 * Start DFS from each unvisited email:
 * - Start with "a1":
 *     - Visit "a1", then "a2", then "a3".
 *     - Collect emails: ["a1", "a2", "a3"].
 * - Next, visit "b1":
 *     - Collect emails: ["b1"].
 * - Finally, visit "a4":
 *     - Collect emails: ["a4"].
 *
 * Step 3: Sorting
 * ----------------
 * Sort each group of emails lexicographically:
 * - ["a1", "a2", "a3"] -> Already sorted.
 * - ["b1"] -> Already sorted.
 * - ["a4"] -> Already sorted.
 *
 * Step 4: Add Account Name
 * -------------------------
 * Add the account name as the first element of each group:
 * - ["A", "a1", "a2", "a3"]
 * - ["B", "b1"]
 * - ["A", "a4"]
 *
 * Step 5: Result Construction
 * ----------------------------
 * Combine all merged accounts into the final result:
 * Output:
 * [
 *     ["A", "a1", "a2", "a3"],
 *     ["B", "b1"],
 *     ["A", "a4"]
 * ]
 */
