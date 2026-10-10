class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oricolor= image[sr][sc];
        if(oricolor == color){
            return image;
        }
        color(image,sr,sc,color,oricolor);
        return image;
    }
    private void color(int[][] image, int r , int c , int color , int oricolor){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length || image[r][c] != oricolor){
            return;
        }
        image[r][c] = color;
        color(image,r+1,c,color,oricolor);
        color(image,r-1,c,color,oricolor);
        color(image,r,c+1,color,oricolor);
        color(image,r,c-1,color,oricolor);
    }
}