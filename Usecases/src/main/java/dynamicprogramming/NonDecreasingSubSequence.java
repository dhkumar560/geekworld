package dynamicprogramming;

import java.util.Arrays;

public class NonDecreasingSubSequence {

    public static int[] subseqLengthArr(int arr[]){
        int resArr[] = new int[arr.length];
        int subSeqArr[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            resArr[i]=1;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && resArr[i]<= resArr[j]+1 ){
                    resArr[i] = Math.max(resArr[j]+1,resArr[i]);
                    subSeqArr[i] = j;
                }
            }
        }
        Arrays.stream(subSeqArr).forEach(System.out::print);
        return resArr;
    }

    public static void main(String[] args) {
        int arr[]= {0,4,12,2,10,6,9,13,3,11,7,15};
        int res[] =subseqLengthArr(arr);
        System.out.println(Arrays.stream(res).max().getAsInt());
    }
}
