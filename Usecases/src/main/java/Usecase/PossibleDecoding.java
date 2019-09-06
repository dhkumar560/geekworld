package Usecase;

public class PossibleDecoding {

    public static int noOfPossibleDecoding(int num) {
        if (num <= 0) return 0;
        int count = 0;
        String strVal = String.valueOf(num);
        for (int i = 0; i < strVal.length() - 1; i++) {
            String txt = strVal.substring(i, i + 2);
            int val = Integer.parseInt(txt);
            if (val < 27 && val > 0) {
                count++;
            }
        }
        return 1 + count;
    }


    public static void main(String[] args) {
        System.out.println(noOfPossibleDecoding(0));
    }
}
