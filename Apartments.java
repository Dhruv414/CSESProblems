import java.util.*;
import java.io.*;

public class Apartments {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] apartments = new int[m];
        int[] applicants = new int[n];
        ArrayList<Integer> sorting = new ArrayList<>();
        for(int i = 0; i<n; i++) sorting.add(sc.nextInt());
        Collections.sort(sorting);
        for(int i = 0; i<n; i++) applicants[i] = sorting.get(i);
        sorting.clear();
        for(int i = 0; i<m; i++) sorting.add(sc.nextInt());
        Collections.sort(sorting);
        for(int i = 0; i<m; i++) apartments[i] = sorting.get(i);
        int i = 0;
        int j = 0;
        int c = 0;

        while(i < n && j < m){
            if(Math.abs(applicants[i] - apartments[j]) <= k){
                c++;
                i++;
                j++;
            }
            else if(apartments[j] < applicants[i] - k){
                j++;
            }
            else{
                i++;
            }
        }

        pw.println(c);
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