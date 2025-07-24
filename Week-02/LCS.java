
import java.util.*;
public class LCS {
    // ---------- Brute Force Approach ----------
    // Generates all subsequences of str1, checks each in str2 and str3
    // Time Complexity -> O(2^n * (m + k))
    // Space Complexity ->O(2^n)
    public int bruteForceLCS(String str1, String str2, String str3) {
        List<String> allSubsequences = new ArrayList<>();
        generateAllSubsequences(str1, 0, "", allSubsequences);
        int maxLength = 0;
        for (String subseq : allSubsequences) {
            if (isSubsequence(subseq, str2) && isSubsequence(subseq, str3)) {
                maxLength = Math.max(maxLength, subseq.length());
            }
        }
        return maxLength;
    }
    private void generateAllSubsequences(String str, int index, String current, List<String> result) {
        if (index == str.length()) {
            result.add(current);
            return;
        }
        // Include current character
        generateAllSubsequences(str, index + 1, current + str.charAt(index), result);
        // Exclude current character
        generateAllSubsequences(str, index + 1, current, result);
    }
    private boolean isSubsequence(String subseq, String mainStr) {
        int i = 0, j = 0;
        while (i < subseq.length() && j < mainStr.length()) {
            if (subseq.charAt(i) == mainStr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == subseq.length();
    }
    // ---------- Optimized Approach (3D Memoization DP) ----------
    // Time Complexity -> O(n * m * k)
    // Space Complexity -> O(n * m * k)
    public int optimizedLCS(String str1, String str2, String str3) {
        int len1 = str1.length(), len2 = str2.length(), len3 = str3.length();
        int[][][] dp = new int[len1][len2][len3];
        for (int[][] matrix : dp)
            for (int[] row : matrix)
                Arrays.fill(row, -1);
        return computeLCS(0, 0, 0, str1, str2, str3, dp);
    }
    private int computeLCS(int i, int j, int k, String str1, String str2, String str3, int[][][] dp) {
        if (i == str1.length() || j == str2.length() || k == str3.length()) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        if (str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == str3.charAt(k)) {
            dp[i][j][k] = 1 + computeLCS(i + 1, j + 1, k + 1, str1, str2, str3, dp);
        } else {
            int skipStr1 = computeLCS(i + 1, j, k, str1, str2, str3, dp);
            int skipStr2 = computeLCS(i, j + 1, k, str1, str2, str3, dp);
            int skipStr3 = computeLCS(i, j, k + 1, str1, str2, str3, dp);
            dp[i][j][k] = Math.max(skipStr1, Math.max(skipStr2, skipStr3));
        }
        return dp[i][j][k];
    }
    // ---------- Main Method for Testing ----------
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "abc", str2 = "abc", str3 = "abc";
        System.out.println("Brute Force LCS Length: " + solution.bruteForceLCS(str1, str2, str3));
        System.out.println("Optimized LCS Length: " + solution.optimizedLCS(str1, str2, str3));
    }
}
