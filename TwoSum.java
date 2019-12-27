import java.util.*;
import java.io.*;

public class TwoSum {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int x = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] arr = new int[n];
        int j = 0;
        for(int i = 0; i<n; i++){
            int k = sc.nextInt();
            arr[i] = k;
            if(map.containsKey(k)){
                list.get(map.get(k)).add(i);
            }
            else{
                map.put(k, j);
                list.add(new ArrayList<>());
                list.get(j).add(i);
                j++;
            }
        }
        for(int i = 0; i<n; i++){
            if(map.containsKey(x-arr[i])){
                ArrayList<Integer> reqsum = list.get(map.get(x-arr[i]));
                if(reqsum.get(0) == i && reqsum.size() > 1){
                    pw.println((i+1) + " " + (reqsum.get(1)+1));
                    pw.close();
                    return;
                }
                else if(reqsum.get(0) != i){
                    pw.println((i+1) + " " + (reqsum.get(0)+1));
                    pw.close();
                    return;
                }
            }
        }
        pw.println("IMPOSSIBLE");
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