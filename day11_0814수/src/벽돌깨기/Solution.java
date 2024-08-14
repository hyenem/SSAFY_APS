package 벽돌깨기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int[][] arr;
	static int[][] nowarr;
	static int H;
	static int W;
	static int N;
	static boolean[][] visited;
	static int ans;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case<=T; test_case++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			arr = new int[H][W];
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			ans = Integer.MAX_VALUE;
			play(0);
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	static void play(int count) {
		if(count==N) {
			int sum = 0;
			for(int i = 0; i<H; i++) {
				for (int j = 0; j<W; j++) {
					if(nowarr[i][j]!=0) sum++;
				}
			}
			if(sum<ans) ans = sum;
		}
		if(count==0) {
			for(int i = 0; i<H; i++) {
				nowarr[i] = arr[i];
			}
		}
		for(int i = 0; i<W; i++) {
			drop(i);
			play(count+1);
		}
	}
	static void drop(int i) {
		int h = 0;
		for(h = 0; h<H; h++) {
			if(nowarr[h][i]!=0) break;
		}
		visited = new boolean[N][N];
		pop(h,i);
		fall();
	}
	
	static void pop(int h, int w) {
		if(h<0 || h>H||w<0||w>W) return;
		if(visited[h][w]) return;
		visited[h][w]=true;
		nowarr[h][w]=0;
		for(int k = 1; k<nowarr[h][w]; k++) {
			if(h+k<H) pop(h+k,w);
			if(h-k>0) pop(h-k,w);
			if(w+k<W) pop(h,w+k);
			if(w-k>0) pop(h,w-k);
		}
	}
	
	static void fall() {
		for(int j = 0; j<W; j++) {
			for(int i = H-1; i>=0; i--) {
				if(nowarr[i][j]!=0) {
					int tmp = i;
					while(nowarr[tmp][j]==0) {
						tmp++;
					}
					nowarr[tmp][j]=nowarr[i][j];
					nowarr[i][j]=0;
				}
			}
		}
	}
}
