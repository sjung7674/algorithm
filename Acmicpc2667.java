import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Acmicpc2667 {
    // 위,아래,오,왼
    private final int[] dx = { -1, 1, 0, 0 };
    private final int[] dy = { 0, 0, 1, -1 };
    private final int[][] map;
    private final boolean[][] visited;
    private final ArrayList<Integer> groups;
    private final int size;
    private int cnt;

    public Acmicpc2667(final int size) {
        this.size = size;
        map = new int[size][size];
        visited = new boolean[size][size];
        groups = new ArrayList<Integer>();
    }

    public void print(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int dfs_recursion(final int x, final int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            final int nX = x + dx[i];
            final int nY = y + dy[i];
            if (nX >= 0 && nX < this.size && nY >= 0 && nY < this.size) {
                if (this.map[nX][nY] == 1 && this.visited[nX][nY] == false) {
                    dfs_recursion(nX, nY);
                }

            }
        }
        return cnt;
    }
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int size = Integer.parseInt(st.nextToken());
        final Acmicpc2667 dfs2667 = new Acmicpc2667(size);
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            final String[] line_arr = st.nextToken().split("");
            for (int j = 0; j < line_arr.length; j++) {
                dfs2667.map[i][j] = Integer.parseInt(line_arr[j]);
            }

        }
        // dfs2667.print(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dfs2667.map[i][j] == 1 && dfs2667.visited[i][j] == false) {
                    dfs2667.groups.add(dfs2667.dfs_recursion(i, j));
                    dfs2667.cnt = 0;
                }
            }
        }
        dfs2667.groups.sort(null);
        System.out.println(dfs2667.groups.size());
        for (int i = 0; i < dfs2667.groups.size(); i++) {
            System.out.println(dfs2667.groups.get(i));
        }

    }
}