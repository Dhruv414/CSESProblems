import java.util.*;
import java.io.*;

public class StringMatching {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        String s = sc.nextLine();
        String k = sc.nextLine();
        s = k + "#" + s;

        int[] arr = new int[s.length()];
        int n = s.length();
        char[] c = s.toCharArray();

        for(int i = 1; i<n; i++){
            int j = arr[i-1];
            while(j > 0 && c[i] != c[j]){
                j = arr[j-1];
            }
            if(c[j] == c[i]) j++;
            arr[i] = j;
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == k.length()){
                count++;
            }
        }
        pw.println(count);
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