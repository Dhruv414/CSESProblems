import java.util.*;
import java.io.*;

public class Towers {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        TreeSet<Integer> towers = new TreeSet<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = sc.nextInt();
        int[] list = new int[n];
        for(int i = 0; i<n; i++){
            int k = sc.nextInt();
            list[i] = k;
            /*if(!freq.containsKey(k)){
                freq.put(k, 1);
            }
            else{
                freq.put(k, freq.get(k) + 1);
            }*/
        }
        //pw.println(freq);
        int t = 0;
        for(int i = 0; i<n; i++){
            int k = list[i];
            Integer l = towers.higher(k);
            //System.out.println(freq);
            //System.out.println(l);
            //System.out.println(towers);
            if(l == null){
                //pw.println(k);
                if(!freq.containsKey(k) || freq.get(k) == 0){
                    //System.out.println(freq);
                    freq.put(k, 1);
                    towers.add(k);
                }
                else{
                    freq.put(k, freq.get(k) + 1);
                }
                //System.out.println(k);
                t++;
            }
            else{
                //System.out.println(l);
                freq.put(l, freq.get(l)-1);
                if(freq.get(l) == 0)
                    towers.remove(l);
                towers.add(k);
                if(!freq.containsKey(k)){
                    //System.out.println(freq);
                    freq.put(k, 1);
                    towers.add(k);
                }
                else{
                    freq.put(k, freq.get(k) + 1);
                }
            }
        }
        pw.println(t);
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