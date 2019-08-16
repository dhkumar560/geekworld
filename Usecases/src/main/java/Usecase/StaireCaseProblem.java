package Usecase;

public class StaireCaseProblem {
    public static void main(String[] args) {
        System.out.println(fibonacciSeries(4));
    }

    public static int staireCase(int n){
        int a[] = new int [n];
        a[0]=0;
        a[1]=1;
        a[2]=1;
        for(int i=3;i<n;i++){
            a[i] = a[i-1]+a[i-2];
        }
        return a[n-1];
    }

    public static int fibonacciSeries(int n){
        int n1 = 0, n2 = 1, n3 = 1;
        int sum;

        if (n == n1 || n == n2) {
            return n;
        }

        for(int i=2; i <= n; i++){
            sum = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = sum;
        }
        return n3;
    }
}
