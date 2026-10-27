import java.util.*;
 
class Solution {
    private void dfs(int row, int col, int[][] image, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if (image[row][col] != oldColor) {
            return;
        }
 
        image[row][col] = newColor;
        dfs(row - 1, col, image, oldColor, newColor);
        dfs(row + 1, col, image, oldColor, newColor);
        dfs(row, col - 1, image, oldColor, newColor);
        dfs(row, col + 1, image, oldColor, newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        dfs(sr, sc, image, oldColor, color);
        return image;
    }
}