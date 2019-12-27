import java.util.*;
import java.io.*;

public class MovieFestival {

    static class Event implements Comparable<Event>{
        int start;
        int end;
        public Event(int s, int e){
            start = s;
            end = e;
        }

        public int compareTo(Event e){
            return this.end - e.end;
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
            list.add(new Event(a,b));
        }
        Collections.sort(list);
        int c = 0;
        int start = -1;
        for(Event e : list){
            if(e.start >= start){
                start = e.end;
                c++;
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