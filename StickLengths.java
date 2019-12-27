import java.util.*;
import java.io.*;

public class StickLengths {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0; i<n; i++) list.add(sc.nextLong());
        Collections.sort(list);
        long median = list.get(n/2);
        if(list.size()%2==0){
            median+=list.get(n/2-1);
            median/=2;
        }
        double cost = 0;
        for(long l : list) cost+=Math.abs(l-median);
        pw.println((long)(cost));
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