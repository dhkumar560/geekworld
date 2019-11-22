package dynamicprogramming;

public class UniquePathInGridWithObstacle {
    public static int uniquePath(int path[][]){
        int r = path.length;
        int c = path[0].length;
        int res[][] = new int [r][c];
        for(int i=0;i<r;i++){
            if(path[i][0] == 0){
                res[i][0] = 1;
            }
        }
        for(int j=0;j<c;j++){
            if(path[0][j] == 0){
                res[0][j] = 1;
            }
        }
        for(int i =1;i<r;i++){
            for(int j=1;j<c;j++){
                if(path[i][j]==0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
       return res[r-1][c-1];
    }
    public static void main(String[] args) {
        int path[][] = {{0,0,0},{1,1,0},{0,0,0}};
        System.out.println(uniquePath(path));
    }
}
