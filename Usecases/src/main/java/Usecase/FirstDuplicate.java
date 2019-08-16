package Usecase;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstDuplicate {
    public static void main(String[] args) {
        int arr[] ={1,5,2,5,2,3,1};
        System.out.println(firstDuplicate(arr));
       System.out.println(firstDuplicateInArr(arr));
        System.out.println(firstDuplicateAbs(arr));
    }
    public static int firstDuplicate(int[] arr){
        LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<>();
        for(int a:arr) {
            if (lhm.containsKey(a)){
                lhm.put(a,lhm.get(a)+1);
            } else{
                lhm.put(a,1);
            }
        }
        for(Map.Entry<Integer,Integer> e:lhm.entrySet()){
            if(e.getValue()>1){
                return e.getKey();
            }
        }
        return 0;
    }

    public static int firstDuplicateInArr(int arr[]){
        HashSet<Integer> hash = new HashSet<>();
        int min = -1;
        for(int i=arr.length-1;i>=0 ;i--) {
            if (hash.contains(arr[i])) {
                min = i;
            } else {
                hash.add(arr[i]);
            }
        }
            if(min != -1){
                return arr[min];
            }

        return -1;
    }
    public static int firstDuplicateAbs(int a[]){
        //int arr[] ={1,5,2,5,2,3,1};
        for(int i=0;i<a.length-1;i++){

            if(a[Math.abs(a[i])]<0) return Math.abs(a[i]);
            else a[Math.abs(a[i])] = - a[Math.abs(a[i])];
        }
        return -1;
            }



}
