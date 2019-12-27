package DynamicProgrammingCSCE;

import java.util.*;
import java.io.*;

public class CoinCombinationsI {
    static long modulo = (long)1e9+7;
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int x = sc.nextInt();
        long[] dp = new long[x+1];
        int[] coins = new int[n];
        for(int i = 0; i<n; i++) coins[i] = sc.nextInt();
        Arrays.sort(coins);
        dp[0] = 1;
        loop : for(int i = 1; i<=x; i++){
            for(int c : coins){
                if(i - c >= 0){
                    dp[i] += dp[i-c] %= modulo;
                }
                else{
                    continue loop;
                }
            }
        }
        pw.println(dp[x] % modulo);
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