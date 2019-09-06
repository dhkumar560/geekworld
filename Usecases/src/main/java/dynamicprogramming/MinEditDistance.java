package dynamicprogramming;

public class MinEditDistance {
    public static int editDistanceDP(String s1,String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length();i++){
            dp[i][0]=i;
        }
        for(int i=0;i<s2.length();i++){
            dp[0][i]=i;
        }
        for(int m =1;m<=s1.length();m++){
            for(int n=1;n<=s2.length();n++){
                if(s1.charAt(m-1) == s2.charAt(n-1)){
                    dp[m][n]=dp[m-1][n-1];
                } else {
                    dp[m][n]= 1+ Math.min(Math.min(dp[m][n-1],dp[m-1][n]),dp[m-1][n-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "horizon";
        String s2 = "horizontall";
        System.out.println("Minimum Edit Distance -(DP): " + editDistanceDP(s1, s2));
    }
}
