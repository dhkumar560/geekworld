package array;

public class RainWaterProblem {
    public static int getRainWater(int[] arr) {
        int l = 0, h = arr.length - 1;
        int l_max = arr[l], r_max = arr[h];
        int result = 0;
        while (l < h) {
            if (arr[l] < arr[h]) {
                if (arr[l] > l_max) {
                    l_max = arr[l];
                } else {
                    result += l_max - arr[l];
                }
                l++;
            } else {
                if (arr[h] > r_max) {
                    r_max = arr[h];
                } else {
                    result += r_max - arr[h];
                }
                h--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(getRainWater(arr));
    }
}
