package array;

public class SubRectangularMatrixWithMaximumSum {

    public static void main(String[] args) {
        int[][] input = {{2, 1, -3, -4, 5},
                {0, 6, 3, 4, 1},
                {2, -2, -1, 4, -5},
                {-3, 3, 1, 0, 3}};
        SubRectangularMatrixWithMaximumSum saw = new SubRectangularMatrixWithMaximumSum();
        System.out.println(saw.maxSumRectangularMatrix(input));
    }

    public KadaneResult maxSum(int[] arr) {
        int max_sum_so_far = Integer.MIN_VALUE;
        int max_sum_to_end = 0, s = 0, start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            max_sum_to_end = max_sum_to_end + arr[i];
            if (max_sum_to_end < 0) {
                max_sum_to_end = 0;
                s = i + 1;
            } else if (max_sum_so_far < max_sum_to_end) {
                max_sum_so_far = max_sum_to_end;
                start = s;
                end = i;
            }
        }
        return new KadaneResult(max_sum_so_far, start, end);
    }

    public Result maxSumRectangularMatrix(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[] temp = new int[row];
        Result r = new Result();
        for (int left = 0; left < col; left++) {
            for (int i = 0; i < row; i++) {
                temp[i] = 0;
            }
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++) {
                    temp[i] = temp[i] + arr[i][right];
                }
                KadaneResult kadaneResult = maxSum(temp);
                if (kadaneResult.maxSum > r.maxSum) {
                    r.maxSum = kadaneResult.maxSum;
                    r.leftBound = left;
                    r.rightBound = right;
                    r.upBound = kadaneResult.start;
                    r.downBound = kadaneResult.end;
                }
            }

        }
        return r;

    }

    class Result {
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int downBound;

        @Override
        public String toString() {
            return "result{" +
                    "maxSum=" + maxSum +
                    ", leftBound=" + leftBound +
                    ", rightBound=" + rightBound +
                    ", upBound=" + upBound +
                    ", downBound=" + downBound +
                    '}';
        }
    }

    class KadaneResult {
        int maxSum;
        int start;
        int end;

        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }
}
