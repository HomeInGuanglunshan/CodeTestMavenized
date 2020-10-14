package treeSetTest.treeSetTest05.comparable.concurrent;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		TreeSet<Guy> ts = new TreeSet<Guy>();
		ts.add(new Guy(3));
		ts.add(new Guy(2));
		ts.add(new Guy(5));
		ts.add(new Guy(7));
		ts.add(new Guy(1));
		ts.add(new Guy(6));
		ts.add(new Guy(6));
		ts.add(new Guy(9));
		for (Guy guy : ts) {
			System.out.println(guy.getId());
		}
	}
}
