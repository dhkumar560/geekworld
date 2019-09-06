package array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static void printMax(int arr[],int n,int k){
        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i=0;i<k;i++){
            while(!q.isEmpty() && arr[i]>=arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }

        for(;i<n;++i){
            System.out.println(arr[q.peek()]+" ");
            while(!q.isEmpty() && q.peek() <= i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[i]>=arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        System.out.println(arr[q.peek()]);
    }

    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
