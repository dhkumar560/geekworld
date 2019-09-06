package array;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int FindKthLargest(List<Integer> list, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k));
        for (int i = k; i < list.size(); i++) {
            if (pq.peek() < list.get(i)) {
                pq.poll();
                pq.add(list.get(i));
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 4;

        System.out.println("K'th largest element in the array is " +
                FindKthLargest(ints, k));
    }
}
