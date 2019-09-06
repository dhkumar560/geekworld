package string;

public class KMPPatternMatching {

    private int[] computeTemporaryArray(char pattern[]){
        int lps[] = new int[pattern.length];
        int index =0,i=1;
        while(i<pattern.length){
            if(pattern[i]==pattern[index]){
                lps[i]=index+1;
                i++;
                index++;
            } else {
                if(index!=0){
                    index = lps[index-1];
                } else {
                    lps[i]=0;
                    i++;
                }
            }
        }
    return lps;
    }

    public boolean KMP(char text[],char pattern[] ){
    int lps[] = computeTemporaryArray(pattern);
    int i=0,j=0;
    while(i< text.length && j < pattern.length){
        if(text[i]== pattern[j]){
            i++;
            System.out.println(i);
            j++;
        }else {
            if(j!=0){
                j=lps[j-1];
            }
            else {
                i++;
            }
        }
    }
    if(j == pattern.length){
        return true;
    }
    return false;
    }


    public static void main(String[] args) {
        String str = "abcxabcdabcdabcyvhxb";
        String subString = "abcdabcy";
        KMPPatternMatching ss = new KMPPatternMatching();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }
}
