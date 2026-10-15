import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) 
    {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] record = new int[rows][2];

        for (int r = 0; r < rows; r++) 
        {
            int soldiers = 0;
            
            for (int c = 0; c < cols; c++) 
            {
                if (mat[r][c] == 1) 
                {
                    soldiers++;
                } else 
                {
                    break;
                }
            }
            record[r][0] = soldiers; 
            record[r][1] = r;        
        }

        
        Arrays.sort(record, (a, b) -> {
            if (a[0] != b[0]) 
            {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) 
        {
            result[i] = record[i][1];
        }

        return result;
    }
}