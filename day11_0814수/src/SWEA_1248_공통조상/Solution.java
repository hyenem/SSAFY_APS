package SWEA_1248_공통조상;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case<=T; test_case++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			int[][] child = new int[2][V+1];
			int[] parent = new int[V+1];
			for (int i =0; i<E; i++) {
				int p_idx = sc.nextInt();
				int c_idx = sc.nextInt();
				
				if(child[0][p_idx]!=0) child[1][p_idx]=c_idx;
				else child[0][p_idx]=c_idx;
				
				parent[c_idx]=p_idx;
			}
			
			
		}
	}
}