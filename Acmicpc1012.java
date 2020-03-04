import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Acmicpc1012 {
    // 위,아래,오,왼
    private final int[] dx = { -1, 1, 0, 0 };
    private final int[] dy = { 0, 0, 1, -1 };

    public void print(int[][] map){
        for(int i = 0;i<map.length;i++){
            for(int j =0;j<map[i].length;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void dfs(int[][] map, boolean[][] visited, int x, int y, int width, int height){
        visited[x][y] = true;
        for(int i = 0; i<4;i++){
            final int nX = x + dx[i];
            final int nY = y + dy[i];
            if (nX >= 0 && nX < width && nY >= 0 && nY < height) {
                if (map[nX][nY] == 1 && !visited[nX][nY]) {
                    dfs(map,visited,nX, nY,width,height);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        
        Acmicpc1012 a = new Acmicpc1012();
        for(int i = 0; i<c;i++){
            st = new StringTokenizer(br.readLine());
            int cnt=0;
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            int[][] map = new int[width][height];
            boolean[][] visited = new boolean[width][height];
            for(int j = 0; j<pos;j++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            a.print(map);
            for(int k = 0; k<height; k++){
                for(int l = 0; l<width; l++){
                    if(map[l][k] == 1 && !visited[l][k]){
                        a.dfs(map, visited, l, k, width, height);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        
    }
}