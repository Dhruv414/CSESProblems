import java.util.*;
import java.io.*;

public class RangeSumQueries {
    static long[] bit;
    public static void update(int i, int v){
        while(i < bit.length){
            bit[i] += v;
            i += i & - i;
        }
    }
    public static long sum(int i){
        long sum = 0;
        while(i != 0){
            sum+=bit[i];
            i -= i & -i;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int q = sc.nextInt();
        bit = new long[n+1];
        int[] list = new int[n+1];
        for(int i = 1; i<=n; i++){
            int k = sc.nextInt();
            list[i] = k;
            update(i, k);
        }
        for(int i = 0; i<q; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == 1){
                update(b, c - list[b]);
                list[b] = c;
            }
            else{
                pw.println(sum(c) - sum(b-1));
            }
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