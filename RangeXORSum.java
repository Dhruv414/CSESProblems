import java.util.*;
import java.io.*;

public class RangeXORSum {

    static long[] bit;

    public static void update(int i, long val){
        while (i < bit.length){
            bit[i] ^= val;
            i += i & -i;
        }
    }

    public static long xor(int i){
        long sum = 0;
        while(i != 0){
            sum ^= bit[i];
            i -= i & -i;
            //System.out.println("stuck");
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int q = sc.nextInt();
        bit = new long[n+1];
        for(int i = 0; i<n; i++){
            long k = sc.nextLong();
            update(i+1, k);
        }
        for(int i = 0; i<q; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            pw.println(xor(r)^xor(l-1));
        }
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