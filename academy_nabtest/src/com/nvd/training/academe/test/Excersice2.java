package com.nvd.training.academe.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Excersice2 {

	/*
	 * Requirement: Cho một mảng các số nguyên A theo thứ tự và có thể trùng lặp như
	 * bên dưới. Trong một lần di chuyển, bạn có thể xóa một số nguyên khỏi A hoặc
	 * chèn một số nguyên vào trước hoặc sau bất kỳ phần tử nào của A. Mục tiêu là
	 * đạt được một mảng trong đó tất cả các phần tử giá trị X có trong mảng xuất
	 * hiện chính xác X lần. Trả về số lần di chuyển, thực hiện xóa hoặc chèn để ra
	 * được kết quả. Ví dụ: A = [1, 1, 3, 4, 4, 4] 1 xuất hiện 2 lần, 3 xuất hiện 1
	 * lần và 4 xuất hiện 3 lần. Remove một phần tử của 1 và 3 và insert 1 phần tử 4.
	 * Kết quả của mảng A = [1, 4, 4, 4, 4] -> Return 3 lần updates
	 */

	/*
	 * Analyze: 
	 * 1. Kiểm tra phần tử và số lần xuất hiện trong mảng
	 * 2. Nếu số lần xuất hiện lớn hơn phần tử -> Remove n phần tử đó = số lần xuất hiện - phần tử
	 * 3. Nếu số lần xuất hiện bé hơn phần tử
	 * 3.1. Nếu phần tử - số lần xuất hiện > phần tử / 2 
	 * -> Không thể insert thêm để view phần tử đó lên array 
	 * -> Remove m phần tử đó = số lần xuất hiện
	 * 3.2. Nếu phần tử - số lần xuất hiện <= phần tử / 2
	 * -> Insert thêm o phần tử đó = phần tử - số lần xuất hiện
	 * 4. Nếu số lần xuất hiện = phần tử -> Bỏ qua
	 * Trả về kết quả = n + m + o
	 */

	public static int solution(int[] array) {
		Map<Integer, Integer> elementPresentMap = new HashMap<>();
		for (int i : array) {
			int value = 1;
			if (elementPresentMap.containsKey(i)) {
				value = elementPresentMap.get(i) + 1;
			}
			elementPresentMap.put(i, value);
		}
		System.out.println(elementPresentMap.toString());
		int result = 0;
		Set<Integer> keys = elementPresentMap.keySet();
		for (Integer key : keys) {
			Integer value = elementPresentMap.get(key);
			if (value > key) {
				result += value - key;
				System.out.println("2: v " + value + " k " + key + " r " + result);
			} else if (value < key) {
				if (key - value > key / 2) {
					result += value;
					System.out.println("3.1: v " + value + " k " + key + " r " + result);
				} else {
					result += key - value;
					System.out.println("3.2: v " + value + " k " + key + " r " + result);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {1, 1, 3, 4, 4, 4};
		int[] b = {1, 2, 2, 2, 5, 5, 5, 8};
		int[] c = {1, 1, 1, 1, 3, 3, 4, 4, 4, 4, 4};
		System.out.println(solution(a));
		System.out.println(solution(b));
		System.out.println(solution(c));
	}
}
