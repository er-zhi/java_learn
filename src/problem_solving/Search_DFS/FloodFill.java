package problem_solving.Search_DFS;
// https://leetcode.com/problems/flood-fill/submissions/1449086449/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }

        return image;
    }
    // Depth-First Search (DFS
    // Use recursion to visit all adjacent pixels (up, down, left, right) that share the same original color.
    //Change their color to the new color.
    public void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        // Check if out of bounds
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        // Check if the pixel is not of the original color
        if (image[sr][sc] != originalColor) return;

        // Change the pixel's color
        image[sr][sc] = newColor;

        // Visit neighboring pixels
        dfs(image, sr - 1, sc, originalColor, newColor); // Up
        dfs(image, sr + 1, sc, originalColor, newColor); // Down
        dfs(image, sr, sc  + 1, originalColor, newColor); // Right
        dfs(image, sr, sc  - 1, originalColor, newColor); // Left
    }
}

/*
recursion! might be stack overflow!

Time Complexity: O(m×n)
Every pixel is visited at most once.

Space Complexity: O(m×n)
for the recursive DFS stack or BFS queue in the worst case (all pixels need to be processed).
*/
