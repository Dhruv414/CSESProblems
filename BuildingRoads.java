

import java.util.*;
import java.io.*;

public class BuildingRoads {

    static class dsu{
        int numComponents;
        int[] sizes;
        int[] id;

        public dsu(int n){
            numComponents = n;
            sizes = new int[n+1];
            id = new int[n+1];
            for(int i = 1; i<=n; i++){
                sizes[i] = 1;
                id[i] = i;
            }
        }
        public int find(int p){
            int root = p;
            while(root != id[root]){
                root = id[root];
            }
            while(p != root){
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }

        public void union(int p, int q){
            int r1 = find(p);
            int r2 = find(q);
            if(r1 == r2) return;
            if(sizes[r1] > sizes[r2]){
                sizes[r1] += sizes[r2];
                id[r2] = r1;
            }
            else{
                sizes[r2] += sizes[r1];
                id[r1] = r2;
            }
            numComponents--;
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dsu ds = new dsu(n);
        for(int i = 0; i<m; i++){
            int j = sc.nextInt();
            int k = sc.nextInt();
            ds.union(j,k);
        }
        int count = 0;
        ArrayList<ArrayList<Integer>> pair = new ArrayList<>();
        int max = -1;
        int maxC = -1;
        for(int i = 1; i<n+1; i++){
            if(ds.sizes[i] > max){
                maxC = ds.find(i);
                max = ds.sizes[maxC];
            }
        }
        int s = 1;
        while(s <= n && ds.numComponents > 1){
            if(!ds.connected(maxC, s)){
                count++;
                ds.union(maxC, s);
                ArrayList<Integer> add = new ArrayList<>();
                add.add(maxC);
                add.add(s);
                pair.add(add);
            }
            s++;
        }
        if(count == 0) pw.println(0);
        else{
            pw.println(count);
            for(ArrayList<Integer> p : pair){
                pw.println(p.get(0) + " " + p.get(1));
            }
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