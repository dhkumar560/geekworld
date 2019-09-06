package Usecase;

public class DuplicateElementsInArray {
    public static void main(String args [ ])
    {
        int numRay[] = {0,4,3,2,7,8,2,3,1};

        for(int i = 0; i < numRay.length; i++)
            numRay[numRay[i]%10] = numRay[numRay[i]%10] + 10;
        System.out.println("The repeating elements are : ");
        for(int i = 0; i < numRay.length; i++)
            if(numRay[i] > 19)
                System.out.println(i+" ");
    }

}
