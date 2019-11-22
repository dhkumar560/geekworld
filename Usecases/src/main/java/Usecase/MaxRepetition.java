package Usecase;

public class MaxRepetition {
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,2};
        //System.out.println(arr[maxRepetition(arr)]);
        System.out.println(majorityElement(arr));
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
    public  static int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
