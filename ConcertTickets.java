import java.util.*;
import java.io.*;

public class ConcertTickets {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> tickets = new ArrayList<>();
        boolean[] taken = new boolean[n];
        for(int i = 0; i<n; i++) tickets.add(sc.nextInt());
        Collections.sort(tickets);

        for(int i = 0; i<m; i++){
            int k = sc.nextInt();
            int high = n-1;
            int low = 0;
            int mid = 0;
            boolean poss = false;
            int lastposs = -1;
            for(int j = 0; j<33; j++){
                mid = (high + low) / 2;
                if(tickets.get(mid) <= k){
                    low = mid;
                    lastposs = mid;
                    poss = true;
                }
                else if(tickets.get(mid) <= k){

                }
                else{
                    high = mid - 1;
                }
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