import java.io.*;

class GFG {
    static int minimumSquare(int m, int n) 
    {
        HashMap<String, Integer> dp = new HashMap<>();
        return getMinimumSquare(m,n,dp);
    }
    
    static int getMinimumSquare(int m, int n, HashMap<String, Integer> dp) {
        if(m == n) {
            return 1;
        } else if(dp.containsKey(getKey(m,n))) {
            return dp.get(getKey(m,n));
        }
        int min = Math.min(m,n);
        int max = Math.max(m,n);
        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i <= max; i++) {
            if(min % i == 0 && i <= min) {
                minValue = Math.min(minValue, (min / i) + getMinimumSquare(min,max - i,dp));
            }
            if (max % i == 0) {
                minValue = Math.min(minValue, (max / i) + getMinimumSquare(min - i,max,dp));
            }
        }
        
        dp.put(getKey(m,n),minValue);
    }
    
    static String getKey(int m, int n) {
        return m + "*" + n;
    }
    
    
    // Driver code
    public static void main(String[] args)
    {
        int m = 30, n = 35;
        System.out.println(minimumSquare(m, n));
    }
}
