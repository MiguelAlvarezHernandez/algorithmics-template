package algstudent.s5;

public class PatternMatching {

	private String text;
    private boolean[][] dp; // For the purposes of printing or debugging

    public PatternMatching(String text) {
        this.text = text;
    }

    public boolean checkPattern(String pattern) {
        int m = text.length();
        int n = pattern.length();
        
        dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        
        for (int j = 1; j <= n; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char textChar = text.charAt(i - 1);
                char patternChar = pattern.charAt(j - 1);
                
                if (patternChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if ( textChar == patternChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (patternChar == '?') {
                	dp[i][j] = dp[i - 1][j - 1];
                	if (dp[i][j-1] ) {
                		dp[i][j] = dp[i][j - 1];
                	}
                }
            }
        }

        return dp[m][n];
    }

    public void printsTable() {
        // Simplified debug/info print
        System.out.println("DP table for: " + text + " (Printing whether matched or not)");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }
}