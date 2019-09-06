package Usecase;

public class PrintDiagonalElements {

    public static void printDiagonal(int arr[][]){
        int row = arr.length;
        int column = arr[0].length;
        for(int i=0;i<row;i++) {
            for(int j=i,k=0;j>=0 && k<=i;j--,k++){
                System.out.println(arr[j][k]+" ");
            }
        }
        for(int i=1;i<column;i++) {
            for(int j=row-1,k=i;j>=0 && k<column;j--,k++){
                System.out.println(arr[j][k]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        printDiagonal(arr);
    }
}
