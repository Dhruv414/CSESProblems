import java.util.*;
import java.io.*;

public class RestaurantCustomers {

    static class Event implements Comparable<Event>{
        int t;
        boolean start;
        public Event(boolean s, int t){
            start = s;
            this.t = t;
        }
        public int compareTo(Event e){
            return this.t - e.t;
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        ArrayList<Event> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Event(true,a));
            list.add(new Event(false, b));
        }
        Collections.sort(list);
        int count = 0;
        int maxC = -1;
        for(Event k : list){
            if(k.start){
                count++;
            }
            else{
                count--;
            }
            maxC = Math.max(maxC, count);
        }
        pw.println(maxC);
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