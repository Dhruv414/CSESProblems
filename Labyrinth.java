import java.util.*;
import java.io.*;

public class Labyrinth {

    static class Node{
        int i;
        int j;
        char prev;
        int dist;
        boolean wall;
        public Node(int i, int j, boolean wall){
            this.i = i;
            this.j = j;
            prev = 'K';
            dist = Integer.MAX_VALUE;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Node start = null;
        Node end = null;
        Node[][] grid = new Node[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String s = sc.nextLine();
            for(int j = 0; j<m; j++){
                if(s.charAt(j) == '#'){
                    grid[i][j] = new Node(i, j, true);
                }
                else if(s.charAt(j) == 'A'){
                    grid[i][j] = new Node(i ,j, false);
                    start = grid[i][j];
                }
                else if(s.charAt(j) == 'B'){
                    grid[i][j] = new Node(i, j, false);
                    end = grid[i][j];
                }
                else{
                    grid[i][j] = new Node(i, j, false);
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        start.dist = 0;
        q.add(start);
        while(!q.isEmpty()){
            Node p = q.poll();
            visited[p.i][p.j] = true;
            //System.out.println(p.i + " " + p.j);
            if(p.i > 0 && !visited[p.i-1][p.j] && !grid[p.i-1][p.j].wall){
                if(p.dist + 1 < grid[p.i-1][p.j].dist){
                    grid[p.i-1][p.j].dist = p.dist + 1;
                    grid[p.i-1][p.j].prev = 'U';
                    q.add(grid[p.i-1][p.j]);
                }
            }
            if(p.j > 0 && !visited[p.i][p.j - 1] && !grid[p.i][p.j-1].wall){
                if(p.dist + 1 < grid[p.i][p.j-1].dist){
                    grid[p.i][p.j-1].dist = p.dist + 1;
                    grid[p.i][p.j-1].prev = 'L';
                    q.add(grid[p.i][p.j-1]);
                }
            }
            if(p.i < n - 1 && !visited[p.i+1][p.j] && !grid[p.i+1][p.j].wall){
                if(p.dist + 1 < grid[p.i+1][p.j].dist){
                    grid[p.i+1][p.j].dist = p.dist + 1;
                    grid[p.i+1][p.j].prev = 'D';
                    q.add(grid[p.i+1][p.j]);
                }
            }
            if(p.j < m - 1 && !visited[p.i][p.j + 1] && !grid[p.i][p.j+1].wall){
                if(p.dist + 1 < grid[p.i][p.j+1].dist){
                    grid[p.i][p.j+1].dist = p.dist + 1;
                    grid[p.i][p.j+1].prev = 'R';
                    q.add(grid[p.i][p.j+1]);
                }
            }
        }
        assert end != null;
        if(end.dist == Integer.MAX_VALUE){
            pw.println("NO");
        }
        else{
            StringBuilder br = new StringBuilder();
            Node k = end;
            while(k.i != start.i || k.j != start.j){
                br.append(k.prev);
                //System.out.println(k.i + " " + k.j);
                if(k.prev == 'D'){
                    k = grid[k.i-1][k.j];
                }
                else if(k.prev == 'U'){
                    k = grid[k.i+1][k.j];
                }
                else if(k.prev == 'L'){
                    k = grid[k.i][k.j+1];
                }
                else{
                    k = grid[k.i][k.j-1];
                }
                //System.out.println(k.i + " " + k.j);
            }
            //pw.println(start.i + " " + start.j);
            pw.println("YES");
            pw.println(br.length());
            pw.println(br.reverse().toString());
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