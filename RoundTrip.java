import java.util.*;
import java.io.*;

public class RoundTrip {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[n+1];
        int[] prev = new int[n+1];
        boolean[] vis = new boolean[n+1];
        Arrays.fill(dist, Integer.MIN_VALUE);
        ArrayList<Integer> adj[] = new ArrayList[n+1];
        for(int i = 1; i<=n; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean solFound = false;
        int last = -1;
        int prev2 = -1;
        loop : for(int i = 1; i<=n; i++){
            if(!vis[i]){
                dist[i] = 0;
                q.add(i);
                while(!q.isEmpty()){
                    int p = q.poll();
                    vis[p] = true;
                    for(Integer k : adj[p]){
                        if((Math.abs(dist[p] - dist[k])) > 1 && vis[k] && prev[k] != p){
                            dist[k] = Math.abs(dist[p] - dist[k]) + 1;
                            //prev[k] = p;
                            solFound = true;
                            last = k;
                            prev2 = p;
                            break loop;
                            // 2 3 4 6 2
                        }
                        else{
                            if(!vis[k] && dist[p] + 1 > dist[k]){
                                dist[k] = dist[p]+1;
                                prev[k] = p;
                                q.add(k);
                            }
                        }
                    }
                }
            }
        }
        if(solFound){
            //pw.println(dist[last]+1);
            ArrayList<Integer> sol = new ArrayList<>();
            int p = last;
            int j = 0;
            //pw.println(prev[last] + " " + prev2);
            while(p != prev[last]){
                sol.add(p);
                if(j == 0) {
                    p = prev2;
                    j = 1;
                }
                else
                    p = prev[p];
            }
            //pw.println(prev[last]);
            if(p != 0) {
                sol.add(p);
                sol.add(last);
            }
            pw.println(sol.size());
            //pw.print(last + " ");
            for(int i = sol.size() -1; i >= 0; i--){
                pw.print(sol.get(i) + " ");
            }
        }
        else{
            pw.println("IMPOSSIBLE");
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