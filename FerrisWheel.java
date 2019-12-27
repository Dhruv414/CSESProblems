import java.util.*;
import java.io.*;

public class FerrisWheel {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int x = sc.nextInt();
        ArrayList<Integer> children = new ArrayList<>();
        for(int i = 0; i<n; i++) children.add(sc.nextInt());
        Collections.sort(children);
        int req = 0;
        int i = 0;
        int j = n-1;
        while(i <= j){
            //pw.println(children.get(i) + " " + children.get(j));
            if(i != j && children.get(i) + children.get(j) <= x){
                i++;
                j--;
                req++;
            }
            else{
                req++;
                j--;
            }
        }
        pw.println(req);
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