import java.util.*;
import java.io.*;

public class Playlist {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        HashMap<Integer, Integer> last = new HashMap<>();
        int n = sc.nextInt();
        int[] list = new int[n];
        for(int i = 0; i<n; i++){
            list[i] = sc.nextInt();
        }
        int max = 1;
        int i = 0;
        int j = 1;
        last.put(list[0], 0);
        while(i < n && j < n){
            if(!last.containsKey(list[j])){
                last.put(list[j], j);
            }
            else if(last.get(list[j]) >= i){
                i = last.get(list[j]) + 1;
                last.put(list[j], j);
            }
            else{
                last.put(list[j], j);
            }
            //pw.println(list[j] + " last seen " + last.get(list[j]));
            //pw.println(i + " " + j);
            max = Math.max(max, j - i + 1);
            j++;
        }
        pw.println(max);
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