import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc6603{
    private static int N;
    private static int [] temp;
    private static int [] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt( st.nextToken());
			temp = new int[N];
			arr = new int[N];
			if(N == 0) {
				break;
			}
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt( st.nextToken());
			}
			dfs(0, 0);	
			System.out.println();
        }
    }
    public static void dfs(int start, int depth){
        if(depth==6){
            for(int i = 0; i<N; i++){
                if(temp[i]==1){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        for(int i = start;i<N;i++){
            temp[i]=1;
            dfs(i+1,depth+1);
            temp[i]=0;
        }

    }
}