package DynamicProgrammingCSCE;

import java.util.*;
import java.io.*;

public class MinimizingCoins {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        int[] dp = new int[x+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i<=x; i++){
            for(int c : coins){
                if(i - c >= 0 && dp[i-c] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
            }
        }
        pw.println((dp[x] == Integer.MAX_VALUE) ? -1 : dp[x]);
        pw.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}