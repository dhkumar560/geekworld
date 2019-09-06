package array;

public class FindElementInSortedmatrix {

    public static boolean findElement(int[][] arr, int key) {
        boolean found = false;
        int i = 0, j = arr.length - 1;
        while (i < arr.length && j >= 0) {
            if (key == arr[i][j])
                return true;
            else {
                if (key < arr[i][j]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {5, 7, 8}, {11, 14, 56}};
        System.out.println(findElement(arr, 14));
    }
}
