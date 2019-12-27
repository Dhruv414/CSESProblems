import java.util.*;
import java.io.*;

public class CountingRooms {

    static boolean[][] visited;
    static int[][] space;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        space = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            String s = sc.nextLine();
            for(int j = 0; j<m; j++){
                if(s.charAt(j) =='.'){
                    space[i][j] = 1;
                }
            }
        }

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(space[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }
        pw.println(count);
        pw.close();
    }

    public static void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= space.length || j >= space[0].length){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(space[i][j] != 1)
            return;
        visited[i][j] = true;
        dfs(i-1, j);
        dfs(i,j-1);
        dfs(i+1,j);
        dfs(i,j+1);
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