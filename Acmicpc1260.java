import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Acmicpc1260 {
    private ArrayList<ArrayList<Integer>> graph;
    
    public Acmicpc1260(int node){
        graph  = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<node+1;i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    public void add(int x, int y){
        this.graph.get(x).add(y);
        this.graph.get(y).add(x);
    }

    public ArrayList<ArrayList<Integer>> getGraph(){
        return graph;
    }
    public void depthFirstSearch(boolean[] visitArr, int start){
        if(visitArr[start]) return;
        visitArr[start] = true;
        System.out.print(start + " ");
        ArrayList<Integer> list = graph.get(start);
        if(list.size()>1){
            list.sort(null);
        }
        for(int i : list){
            if(!visitArr[i]){
                depthFirstSearch(visitArr, i);
            }
        }
    }
    public void breadthFirstSearch(boolean[] visitArr, int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(start);
        while(queue.size()!=0){
            start = queue.poll();
            if(visitArr[start]) continue;
            System.out.print(start + " ");
            visitArr[start] = true;
            ArrayList<Integer> list = graph.get(start);
            if(list.size()>1){
                list.sort(null);
            }
            for(int i : list){
                if(!visitArr[i]){
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();
        
        Acmicpc1260 a = new Acmicpc1260(node);
       
        for(int i = 0; i<edge; i++){
            a.add(sc.nextInt(), sc.nextInt());
        }
        sc.close();

        boolean[] dfsVisited = new boolean[node+1];
        boolean[] bfsVisited = new boolean[node+1];
        a.depthFirstSearch(dfsVisited, start);
        System.out.println();
        a.breadthFirstSearch(bfsVisited, start);
    }
}