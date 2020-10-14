package jdk18.lambda.p09;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		/**
		 * 预期效果：奇数在左边，偶数在右边，并且都是递增排序，如：
		 * 
		 * <pre>
		 * [1, 9, 11, 13, 13, 13, 15, 15, 15, 0, 4, 4, 6, 6, 12, 12, 14, 14, 18, 18]
		 * </pre>
		 */

//		假如不是连续add递增数字，则不能达到预期效果
//		Comparator<Integer> comparator = (newOne, oldOne) -> {
//			if (newOne % 2 == 1 && oldOne % 2 != 1) {
//				return -1;
//			} else {
//				return 1;
//			}
//		};
//		TreeSet<Integer> treeSet = new TreeSet<>(comparator);
//		for (int i = 0; i < 20; i++) {
//			treeSet.add(i);
//		}

		Comparator<Integer> comparator = (newOne, oldOne) -> {
//			if (newOne % 2 == 1) {
//				if (oldOne % 2 == 0) {
//					return -1;
//				} else {
//					if (newOne > oldOne) {
//						return 1;
//					} else {
//						return -1;
//					}
//				}
//			} else {
//				if (oldOne % 2 == 1) {
//					return 1;
//				} else {
//					if (newOne > oldOne) {
//						return 1;
//					} else {
//						return -1;
//					}
//				}
//			}
			// below are simplification
			if (newOne % 2 != oldOne % 2) {
				return newOne % 2 == 1 ? -1 : 1;
			} else {
				if (newOne > oldOne) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		TreeSet<Integer> treeSet = new TreeSet<>(comparator);
		for (int i = 0; i < 20; i++) {
			treeSet.add(new java.util.Random().nextInt(20));
		}

		System.out.println(treeSet);
	}

}
