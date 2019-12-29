import java.util.Arrays;

public class Ways2Decode {

    public static int NumberOfWays2Decode(String a){
        int[] dp = new int[a.length()];
        Arrays.fill(dp, -1);
    
        return numDecodings(a, 0, dp);
    }
    public static int numDecodings(String s, int decodePointer, int[] dp) {
        if (decodePointer >= s.length()) {
          return 1; // "" is a valid decomposition
        }

        // Subproblem already solved and has a value
        if (dp[decodePointer] > -1) {
            return dp[decodePointer];
        }
    
        int totalDecompositions = 0;
        for (int i = 1; i <= 2; i++) {
          if (decodePointer + i <= s.length()) {
            String snippet = s.substring(decodePointer, decodePointer + i);
    
            if (isValid(snippet)) {
              totalDecompositions += numDecodings(s, decodePointer + i, dp);
            }
          }
        }
    
        // Record subproblem answer to decompositions from (decodePointer)...(s.length - 1)
        dp[decodePointer] = totalDecompositions;
    
        return dp[decodePointer];
    }

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
          return false;
        }
    
        int value = Integer.parseInt(s);
    
        return value >= 1 && value <= 26;
    }

    public static void main(String[] args){
        String message2Decode = "04612";
        
        System.out.print("Number of ways to decode message " + message2Decode + " is + " + Ways2Decode.NumberOfWays2Decode(message2Decode));
    }
}