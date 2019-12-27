import java.util.*;
import java.io.*;

public class BuildingTeams {

    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            list[i1].add(i2);
            list[i2].add(i1);
        }

        int[] color = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(color[i] == 0){
                color[i] = 1;
                q.add(i);
                while(!q.isEmpty()){
                    Integer p = q.poll();
                    for(Integer k : list[p]){
                        if(color[k] == 0) {
                            color[k] = (color[p] == 2) ? 1 : 2;
                            q.add(k);
                        }
                        else if(color[k] == color[p]){
                            pw.println("IMPOSSIBLE");
                            pw.close();
                            return;
                        }
                    }
                }
            }
        }
        for(int i = 1; i<=n; i++){
            pw.print(color[i] + " ");

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