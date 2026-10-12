class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogcolor = image[sr][sc];
           
        if (ogcolor != color) 
        {
            dfs(image, sr, sc, ogcolor, color);
        }
        
        return image;
    }

    private void dfs(int[][] image, int r, int c, int ogcolor, int newColor) 
    {
        
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != ogcolor) 
        {
            return;
        }

        
        image[r][c] = newColor;

        
        dfs(image, r - 1, c, ogcolor, newColor);
        dfs(image, r + 1, c, ogcolor, newColor);
        dfs(image, r, c - 1, ogcolor, newColor);
        dfs(image, r, c + 1, ogcolor, newColor);
    }
}