package Usecase;

public class MaxRepetition {
    public static void main(String[] args) {
        int arr[] = {1,2,4,1,3,4,2,1};
        System.out.println(arr[maxRepetition(arr)]);
    }

    public static int maxRepetition(int arr[]){
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int maxindex=0;
        for(int i=0;i<n;i++){
            arr[arr[i]%n] +=n;
        }
        for(int i=0;i<n-1;i++) {
            if (arr[i] / n > max) {
                max = arr[i] / n;
                maxindex = i;
            }
        }
        System.out.println(maxindex);
        return maxindex;
    }
}
