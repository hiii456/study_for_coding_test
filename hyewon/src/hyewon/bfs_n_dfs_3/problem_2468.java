package hyewon.bfs_n_dfs_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_2468 {
	static int[][] matrix;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int cnt =0;
	static int n;
	static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				matrix[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
				if(matrix[i][j] > max) max = matrix[i][j];
				if(matrix[i][j] < min) min = matrix[i][j];
			}
		}
		int result = 1;
		for(int i=min; i<max; i++){
			cnt = 0;
			for(int a =0; a<n; a++){
				for(int b =0; b<n; b++){
					visited[a][b] = false;
				}
			}
			for(int a=0; a<n; a++){
				for(int b=0; b<n; b++){
					if(!visited[a][b]&&matrix[a][b]>i){
						dfs(a,b,i);
						cnt++;
					}
				}
			}	
			result = Math.max(result, cnt);
		}
		System.out.println(result);
		
		

	}
	static void dfs(int x, int y, int height){
		visited[x][y] = true;
		for(int i=0; i<4; i++){
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if(next_x>=0&&next_x<n&&next_y>=0&& next_y<n){
				if(matrix[next_x][next_y]>height&& visited[next_x][next_y]==false)
					dfs(next_x,next_y,height);
			}
		}
	}

}
