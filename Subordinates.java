import java.util.*;
import java.io.*;

public class Subordinates {
    static int[] count;
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        adj = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 2; i<=n; i++){
            int par = sc.nextInt();
            adj.get(par).add(i);
        }
        count = new int[n+1];
        dfs(1,0);
        for(int i = 1; i<=n; i++) pw.print(count[i]-1 + " ");
        pw.println();
        pw.close();
    }

    public static void dfs(int n, int p){
        count[n] = 1;
        for(int i : adj.get(n)){
            if(i == p) continue;
            dfs(i, n);
            count[n] += count[i];
        }
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