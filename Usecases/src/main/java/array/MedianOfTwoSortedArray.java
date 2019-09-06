package array;

public class MedianOfTwoSortedArray {
    public static double medianOfTwoSortedArray(int[] ar1, int[] ar2) {
        int x = ar1.length;
        int y = ar2.length;
        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : ar1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : ar1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : ar2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : ar2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] ar1 = {1, 3, 8, 9, 15};
        int[] ar2 = {7, 11, 18, 19, 21, 25};
        System.out.println(medianOfTwoSortedArray(ar1,ar2));
    }
}
