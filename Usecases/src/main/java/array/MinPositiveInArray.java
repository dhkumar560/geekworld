package array;

import java.util.PriorityQueue;

public class MinPositiveInArray {

    public static int minPositive(int arr[],int minElem){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] >=minElem && min > arr[i]){
                min= arr[i];
            }
        }

        return min;
    }
    public static int minPositive1(int arr[],int minElem){
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] >= 0) {
            minHeap.add(arr[i]);
        }
    }
    int c = 0;
    while (!minHeap.isEmpty()) {
        if (minHeap.peek() == c || minHeap.peek() - 1 == c) {
            c = minHeap.remove();
        } else {
            return c + 1;
        }
    }
    return c + 1;
}

    public static void main(String[] args) {
        int arr[] = {-11,-31,0,1,2,4,5};
        System.out.println(minPositive(arr,0));
        int min =minPositive(arr,0);
        int nextMin = minPositive(arr,min+1);
        System.out.println(nextMin);
        if(min >1){
            System.out.println("the missing min is 1");
        } else {
            while (nextMin - min == 1) {
                min = nextMin;
                nextMin = minPositive(arr, nextMin + 1);
            }
            if(nextMin == Integer.MAX_VALUE){
                System.out.println("the missing no is "+(min+2));
            } else {
                System.out.println("the missing is :" + (min + 1));
            }
        }
    }
}
