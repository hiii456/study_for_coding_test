package hyewon.bfs_n_dfs_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot{
	int a;
	int b;
	Dot(int a,int b){
		this.a = a;
		this.b = b;
	}
}

public class problem_14502 {
	static int n,m;
	static int result = Integer.MIN_VALUE;
	static int count = 1;
	static int[][] arr;
	static int[][] newtmp;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result =0;
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j]==0){
					arr[i][j] = 1;
					dfs(i,j,count);
					arr[i][j] = 0;
				}
			}
		}
		
		System.out.println(result);
	

	}
	
	public static void dfs(int x,int y,int count){
		if(count == 3){ // 벽 3개를 생성했을 경우
			bfs(x,y);
			return;
			
		}
		else{  // 벽 3개를 다 세우지 못했을 경우 
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(arr[i][j]==0){
						arr[i][j] = 1;
						dfs(i,j,count+1);
						arr[i][j] = 0;
					}
				}
			}
		}
		
		
	}
	
	public static void bfs(int x,int y){
		// 임시 맵 생성
		newtmp = new int[n][m];
		Queue<Dot> q = new LinkedList<>();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				newtmp[i][j] = arr[i][j]; 
			}
		}
					
		// 바이러스 확산 시키기
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(newtmp[i][j]==2){
					q.add(new Dot(i,j));
				}
			}
		}
		
		
		while(!q.isEmpty()){
			Dot dot = q.poll();
			for(int i=0; i<4; i++){
				int nx = dot.a + dx[i];
				int ny = dot.b + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(newtmp[nx][ny]==0){
						newtmp[nx][ny] = 2;
						q.add(new Dot(nx,ny));
					}
				}
			}
		}
		
		int tmpcnt =0;
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(newtmp[i][j]==0){
					tmpcnt++;
				}
			}
		}
		
		

		result = Math.max(result, tmpcnt);
				
				
	}

}
