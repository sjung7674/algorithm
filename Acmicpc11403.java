import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc11403 {
    private int[][] arr;
    private int[] visited;
    private int[][] result;

    public Acmicpc11403(int node) {
        visited = new int[node];
        arr = new int[node][node];
        result = new int[node][node];
    }

    public void dfs(int node, int x) {
        for (int k = 0; k < node; k++) {
            if (arr[x][k] == 1 && visited[k]==0) {
                System.out.println(x+" "+k);
                visited[k] = 1;
                dfs(node,k);
                
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());

        Acmicpc11403 a = new Acmicpc11403(node);
        for (int i = 0; i < node; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < node; j++) {
                a.arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < node; i++) {
            a.dfs(node,i);
            for (int j = 0; j < node; j++) {
                if(a.visited[j]==1){
                    a.result[i][j] = 1;
                }
            }
            Arrays.fill(a.visited,0);
        }

        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                System.out.print(a.result[i][j] + " ");
            }
            System.out.println();
        }
    }
}