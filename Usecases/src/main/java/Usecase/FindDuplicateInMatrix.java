package Usecase;

public class FindDuplicateInMatrix {
    public static void duplicateInMatrix(int arr[][]){
    int rowCount = arr.length;
    int column = arr[0].length;
        for (int i=0;i<(rowCount*column);i++){
            int temp = arr[i/rowCount][i%rowCount];
            int t =0;
        for (int j=0;j<(rowCount*column);j++){
            if(temp ==arr[j/rowCount][j%rowCount]){
                t++;
            }
        }
            if(t>1){
                System.out.println(temp);
                break;
            }}
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,4}};
        duplicateInMatrix(arr);
    }
}
