package Usecase;

import java.util.Arrays;

public class MinimumNumberOfPlatform {

    public static int  findPlatform(int arr[],int dep[],int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int noOfPlatform = 0,i=0,j=0,result =0;
        while(i<n && j<n){
             if(arr[i] <=dep[j]){
                 noOfPlatform++;
                 i++;
                 if(noOfPlatform > result){
                     result = noOfPlatform;
                 }
             }else {
                 noOfPlatform--;
                 j++;
             }

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }
}
