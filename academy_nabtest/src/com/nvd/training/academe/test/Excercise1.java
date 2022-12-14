package com.nvd.training.academe.test;

import java.util.Arrays;

public class Excercise1 {

	/*
	 * Requirement: Cho một mảng các số nguyên không theo thứ tự và có thể trùng lặp
	 * như bên dưới. Tìm một số nhỏ nhất sao cho số đó lớn hơn 0 và không thuộc mảng
	 * đã cho. Ví dụ: [-3, 2, 5, 5, 6, 0, -1, 3, 1] -> Return về 4 [1, -3, 4, 0, 2,
	 * 4, 6, 1] -> Return về 3 [6, 4, 6, 3, 2, 1, 0, 5, -1] -> Return về 7
	 */

	/*
	 * Analyze: 
	 * 1. Sort mảng 
	 * 2. Duyệt mảng đến vị trí length - 1 
	 * 3. Kiểm tra và bỏ qua các phần tử < 0 
	 * 4. Kiểm tra phần tử vị trí i và (i + 1) 
	 * Nếu phần tử (i + 1) khác phần tử i + 1 thì trả về phần tử i + 1
	 * Nếu duyệt hết mảng -> trả về phần tử cuối cùng của mảng + 1
	 */
	public static int solution(int[] a) {
		Arrays.sort(a);
		int ai, aj, result = -1;
		for (int i = 0; i < a.length - 1; i++) {
			ai = a[i];
			aj = a[i + 1];
			if (ai <= 0) {
				continue;
			}
			if (ai == aj || aj == (ai + 1)) {
				continue;
			} else {
				result = ai + 1;
				break;
			}
		}
		if (result == -1) {
			return a[a.length - 1] + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = { -3, 2, 5, 5, 6, 0, -1, 3, 1 };
		int[] b = { 1, -3, 4, 0, 2, 4, 6, 1 };
		int[] c = { 6, 4, 6, 3, 2, 1, 0, 5, -1 };

		System.out.println(solution(a));
		System.out.println(solution(b));
		System.out.println(solution(c));
	}
}
