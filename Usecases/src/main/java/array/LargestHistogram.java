package array;

import java.util.Stack;

public class LargestHistogram {

    public static int maxHistogramArea(int arr[]){
        int maxArea = 0;
        int area = 0;
        int i;
        Stack<Integer> s = new Stack<>();
        for(i = 0;i<arr.length;){
            if(s.isEmpty() || arr[s.peek()]<arr[i]){
                s.push(i++);
            } else {
                int top = s.pop();
                if(s.isEmpty()){
                    area = arr[top] * i;
                }else {
                    area = top * (i - s.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }

        }
    }
        while(!s.isEmpty()){
            int top = s.pop();
            if(s.isEmpty()){
                area = arr[top] * i;
            }else {
                area = top * (i - s.peek() - 1);
            }
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int arr[] = {2,1,2};
        System.out.println(maxHistogramArea(arr));
    }
}
