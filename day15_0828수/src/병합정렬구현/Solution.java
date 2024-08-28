package 병합정렬구현;

import java.util.Arrays;

public class Solution {
	
	static int[] arr = {29, 4, 7, 12, 5, 100, 3};
	static int N = arr.length;
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSort(int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
				
		while(L<=mid && R<=right) {
			if(arr[L]<=arr[R]) tmp[idx++]=arr[L++];
			else tmp[idx++]=arr[R++];
		}
		
		if(L<=mid) {
			for(int i = L; i<=mid; i++) {
				tmp[idx++]=arr[i];
			}
		}
		if(R<=right) {
			for(int i = R; i<=right; i++) {
				tmp[idx++]=arr[i];
			}
		}
		for(int i = left; i<=right; i++) {
			arr[i]=tmp[i];
		}
	}
}
