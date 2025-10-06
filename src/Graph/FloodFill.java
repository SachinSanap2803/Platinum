package Graph;

public class FloodFill {

    public static int[][] flood(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int oldColor, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }

        image[sr][sc] = color;
        dfs(image, sr-1, sc, oldColor, color);
        dfs(image, sr+1, sc, oldColor, color);
        dfs(image, sr, sc-1, oldColor, color);
        dfs(image, sr, sc+1, oldColor, color);
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        image = flood(image, sr, sc, color);
        for(int i=0; i<image.length; i++) {
            for(int j=0; j<image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}