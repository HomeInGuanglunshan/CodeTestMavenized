package treeSetTest.treeSetTest05.comparable.concurrent;

public class Guy implements Comparable<Guy> {

	Integer id;

	public Guy(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int compareTo(Guy guy) {
		
		if (this.id.compareTo(guy.getId()) > 0) {
			return 1;
		} else {
			return -1;
		}
		
//		return -1; // -1表示放在红黑树的左边,即逆序输出
//		return 1; // 1表示放在红黑树的右边，即顺序输出
//		return 0; // 表示元素相同，仅存放第一个元素
		
//		if (this.id.compareTo(guy.getId()) > 0) {
//			return 1;
//		} else if (this.id.compareTo(guy.getId()) < 0) {
//			return -1;
//		} else {
//			return 0;
//		}
	}
	
}
