package array;

public class GasStationProblem {

    public static void main(String[] args) {
        int A[] = {4,6,7,4};
        int B[] =  {6,7,3,5};
        System.out.println(getCircularRoute(A,B));
        System.out.println(getInitialIndex(A,B));
    }

    public static int getCircularRoute(int a[],int b[]){
        int totalGas=0,totalReq = 0,count =0,n = a.length;

        for(int i=0;i<n;i++){
            for(int j =i;j<(n+i);j++){
                totalGas +=a[(j%n)];
                totalReq +=b[(j%n)];
                if(totalGas - totalReq < 0){
                    break;
                }
            }
            if(totalGas - totalReq >= 0){
                count++;
            }
            totalGas =0;
            totalReq = 0;

        }

        return count;
    }

    public static int getInitialIndex(int a[],int b[]){
        int start = 0, diff = 0, surplus =0;
        for(int i =0;i<a.length;i++){
            surplus = surplus+ a[i] - b[i];
            if(surplus < 0){
                start = i+1;
                diff = surplus;
                surplus = 0;
            }
        }
        return (surplus+diff) >= 0 ? start: -1;


    }
}
