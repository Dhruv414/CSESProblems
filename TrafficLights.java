import java.util.*;
import java.io.*;

public class TrafficLights {

    static class Seg{
        int s;
        int e;
        public Seg(int a, int b){
            s = a;
            e = b;
        }
    }


    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int x = sc.nextInt();
        int n = sc.nextInt();
        Seg seg1 = new Seg(0, x);
        Seg seg2 = new Seg(0,x);


        for(int i = 0; i<n; i++){
            int k = sc.nextInt();
            if(k > seg1.s && k < seg1.e){
                if(k - seg1.s > seg1.e - k){
                    seg1.e = k;
                }
                else{
                    seg1.s = k;
                }
            }
            if(k > seg2.s && k < seg2.e){
                if(k - seg2.s > seg2.e - k){
                    seg2.e = k;
                }
                else{
                    seg2.s = k;
                }
            }
            int ls1 = seg1.e - seg1.s;
            int ls2 = seg2.e - seg2.s;
            pw.print(Math.max(ls1, ls2) + " ");
            if(ls1 > ls2){
                seg2.s = seg1.s;
                seg2.e = seg1.e;
            }
            else if(ls2 > ls1){
                seg1.s = seg2.s;
                seg1.e = seg2.e;
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