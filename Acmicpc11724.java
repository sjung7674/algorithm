import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Acmicpc11724{
    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private int[] visited;
    public Acmicpc11724(int node){
        for(int i =0;i<node+1;i++){
            list.add(new ArrayList<Integer>());
        }
        visited = new int[node+1];
    }
    public void dfs(int node){
        visited[node] = 1;
        for(int v : list.get(node)){
            if(visited[v]==0){
                dfs(v);
            }
        }
    }
    public void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);

        while(!que.isEmpty()){
            int point = que.poll();
            if(visited[point]==1) continue;
            visited[point] =1;
            
            for(int v : list.get(point)){
                if(visited[v]==0){
                    que.add(v);
                    
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        Acmicpc11724 a = new Acmicpc11724(node);
        int cnt = 0;
        for(int i = 0; i< line;i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            a.list.get(f).add(l);
            a.list.get(l).add(f);
        }
        for(int i = 1; i<= node;i++){
            if(a.visited[i]==0){
                a.bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}