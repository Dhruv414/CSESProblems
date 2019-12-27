import java.util.*;
import java.io.*;

public class MaximumSubarraySum {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        long[] list = new long[n];
        for(int i = 0; i<n; i++) list[i] = sc.nextLong();
        long max = Long.MIN_VALUE;
        long currMax = 0;
        int s = 0;
        int e = 0;

        for(int i = 0; i<n; i++){
            currMax = Math.max(currMax + list[i], list[i]);
            // Kadane's Algorithm : localmax[i] = max(list[i], list[i] + localmax[i-1])
            if(currMax > max){
                max = currMax;
            }
        }
        pw.println(max);
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