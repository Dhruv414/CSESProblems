import java.util.*;
import java.io.*;

public class TreeMatching {

    static ArrayList<ArrayList<Integer>> adj;
    static int[] count;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        adj = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i< n -1; i++){
            int k = sc.nextInt();
            int j = sc.nextInt();
            if(j == 1) adj.get(j).add(k);
            else
                adj.get(k).add(j);
        }
        count = new int[n+1];
        dfs(1, 0);
        int max = 0;

        pw.println(max);
        pw.close();
    }

    public static void dfs(int i, int p){
        count[i] = 0;
        
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