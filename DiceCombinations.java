package DynamicProgrammingCSCE;

import java.util.*;
import java.io.*;

public class DiceCombinations {
    static long modulo = (long)1e9+7;
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for(int i = 1; i<=n; i++){
            dp[i] = 0;
            for(int j = 1; j<=6; j++){
                if(i - j >= 0){
                    dp[i] = ((dp[i] % modulo) + (dp[i-j] % modulo)) % modulo;
                }
            }
        }
        pw.println(dp[n]);
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