package com.nvd.training.academe.test;

import java.util.HashMap;

public class Excersice4 {
	/*
	 * Requirement: Cho hai mảng số nguyên A và B ngẫu nhiên cùng kích thước. Từ 2
	 * mảng số nguyên theo thứ tự tạo ra length phân số với tử số thuộc A và mẫu số
	 * thuộc B. Tìm trong length phân số số phân số = nhau. Lưu ý rằng hai phân số
	 * có thể bằng nhau ngay cả khi chúng có cách biểu diễn khác nhau; ví dụ 3/5 và
	 * 6/10 bằng nhau.
	 * 
	 * Ví dụ: 
	 * X = [1, 2, 3, 4, 0], Y = [2, 3, 6, 8, 4] -> return về 3, với 1/2, 3/6, 4/8 bằng nhau.
	 * X = [3, 3, 4], Y = [5, 4, 3] return về 1, không có phân số nào bằng nhau
	 * X = [4, 4, 7, 1, 2], Y = [4, 4, 8, 1, 2] -> return về 4, với 4/4, 4/4, 1/1, 2/2 bằng nhau
	 * X = [1, 2, 3, 1, 2], Y = [2, 4, 6, 5, 10] -> return về 3, với 1/2, 2/4, 3/6 bằng nhau
	 */
	
	/*
	 * Analyze: 
	 * 1. Tìm ước chung lớn nhất của tử số và mẫu số để trả về phân số tối giản nhất.
	 * 2. Duyệt 2 mảng
	 * 	2.1 Tìm tử số = phần tử thứ i của A / ước chung lớn nhất của phần tử thứ i của A và B
	 *  2.2 Tìm mẫu số = phần tử thứ i của B / ước chung lớn nhất của phần tử thứ i của A và B
	 * 	2.3 Tạo ra phân số tối giản với tử số và mẫu số tìm được ở 2.1 và 2.2
	 *  2.4 Kiểm tra xem phân số đó đã tồn tại hay chưa
	 *   2.4.1 Nếu chưa thì tạo ra phân số đó với lần đếm đầu tiên
	 *   2.4.2 Nếu đã tồn tại thì tăng biến đếm của phân số đó lên một đơn vị
	 * 3. So sánh và  tìm về phân số + số lần xuất hiện nhiều nhất của nó -> return số lần
	 */
	
	public static int solution(int[] X, int[] Y) {
		return countUniqueFractions(X, Y);
	}

	private static int findGCD(int a, int b) {
		if (b == 0)
			return a;

		return findGCD(b, a % b);
	}

	private static int countUniqueFractions(int[] numerator, int[] denominator) {
		HashMap<String, Integer> fractionMap = new HashMap<>();
		int n = numerator.length;
		for (int i = 0; i < n; i++) {

			int num = numerator[i] / findGCD(numerator[i], denominator[i]);
			int den = denominator[i] / findGCD(numerator[i], denominator[i]);
			String itemPair = num + "/" + den;
			int occurrence = 1;
			if (fractionMap.containsKey(itemPair)) {
				occurrence += fractionMap.get(itemPair);
			}
			fractionMap.put(itemPair, occurrence);
		}
		return fractionMap.values().stream().max(Integer::compareTo).get();
	}
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 0};
		int[] B = {2, 3, 6, 8, 4};
		int[] C = {3, 3, 4};
		int[] D = {5, 4, 3};
		int[] E = {4, 4, 7, 1, 2};
		int[] F = {4, 4, 8, 1, 2};
		int[] G = {1, 2, 3, 1, 2};
		int[] H = {2, 4, 6, 5, 10};
		
		System.out.println(solution(A, B));
		System.out.println(solution(C, D));
		System.out.println(solution(E, F));
		System.out.println(solution(G, H));
		
	}
}
