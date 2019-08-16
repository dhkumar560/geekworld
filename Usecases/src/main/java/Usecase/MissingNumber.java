package Usecase;

import java.util.Collections;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {5,6,4,7,9,8};
        int X= arr[0],Y=1;
        int n = arr.length;
        for(int i=1;i<n;i++){
            X = X^arr[i];
        }
        for(int j=2;j<=n+1;j++){
            Y = Y^j;
        }
        int Z = X ^ Y;
        System.out.println(X);
        System.out.println(Y);
        System.out.println(Z);
    }
}
