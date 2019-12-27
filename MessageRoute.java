import java.util.*;
import java.io.*;

public class MessageRoute {

    static class Node{
        ArrayList<Integer> adj;
        int i;
        int prev;
        int dist;
        public Node(int i){
            this.i = i;
            adj = new ArrayList<>();
            dist = Integer.MAX_VALUE;
            prev = '\0';
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[] list = new Node[n+1];
        for(int i = 1; i<=n; i++) list[i] = new Node(i);
        for(int i = 0; i<m; i++){
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            list[i1].adj.add(i2);
            list[i2].adj.add(i1);
        }
        boolean[] vis = new boolean[n+1];
        Queue<Node> q = new LinkedList<>();
        list[1].dist = 0;
        q.add(list[1]);
        while(!q.isEmpty()){
            Node p = q.poll();
            for(Integer k : p.adj){
                if(!vis[k] && p.dist + 1 < list[k].dist){
                    list[k].dist = p.dist+1;
                    list[k].prev = p.i;
                    q.add(list[k]);
                }
            }
        }
        if(list[n].dist == Integer.MAX_VALUE){
            pw.println("IMPOSSIBLE");
        }
        else{
            ArrayList<Integer> path = new ArrayList<>();
            Node start = list[n];
            pw.println(start.dist+1);
            while(start != list[1]){
                path.add(start.i);
                start = list[start.prev];
            }
            path.add(1);
            for(int i = path.size()-1; i>0; i--){
                pw.print(path.get(i) + " ");
            }
            pw.println(path.get(0));
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