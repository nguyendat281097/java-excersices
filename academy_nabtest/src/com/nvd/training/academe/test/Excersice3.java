package com.nvd.training.academe.test;

public class Excersice3 {
	/*
	 * Requirement: Cho một mảng các số nguyên A theo thứ tự không giảm và số nguyên
	 * K. Kiểm tra xem A có chứa các số 1,2,...K không? (Mỗi số từ 1 đến K xuất hiện
	 * ít nhất 1 lần)
	 * Ví dụ: cho mảng A và K = 3 sau đây:
	 * A[1] =3D 1
  	 * A[2] =3D 2
  	 * A[3] =3D 3
  	 * A[4] =3D 3
  	 * Return về true
  	 * 
  	 * Cho mảng A dưới đây và K = 2:
  	 * A[1] =3D 1
  	 * A[2] =3D 3
  	 * Return về false
	 */

	/*
	 * Analyze: 
	 * 1. Nếu phần tử đầu tiên khác 1 hoặc phần tử cuối cùng khác K -> return về false
	 * 2. Duyệt mảng A từ 1 đến length - 1
	 * 3. Kiểm tra phần tử thứ i và phần tử thứ (i + 1)
	 * 	Nếu phần tử thứ i = phần tử thứ (i + 1) -> skip
	 * 	Nếu phần tử thứ i khác phần tử thứ (i + 1) và phần tử thứ (i + 1) không bằng phần tử thứ i + 1 
	 * 	-> return về false
	 */
	public static boolean solution(int[] A, int K) {
		int n = A.length;
		if (A[0] != 1 || A[n - 1] != K)
			return false;
		for (int i = 0; i < n - 1; i++) {
			if ((A[i] != A[i + 1]) && (A[i] + 1 != A[i + 1]))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 3};
		int[] b = {1, 1, 3};
		System.out.println(solution(a, 3));
		System.out.println(solution(b, 3));
	}
}
