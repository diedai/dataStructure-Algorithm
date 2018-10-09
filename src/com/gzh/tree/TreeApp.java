package com.gzh.tree;

/**
 * 启动程序
 * <pre>
 * @author gongzhihao
 * @date 2018年10月9日 下午2:00:05
 * </pre>
 */
public class TreeApp {

	public static void main(String[] args) {
		//创建一棵树
		Tree tree = new Tree();
		
		//插入数据
		tree.insert("a", 1);
		tree.insert("c", 3);
		tree.insert("b", 2);
		
		//遍历数据
		tree.iterate(tree.root);
		
		//找数据
		Node n = tree.find(3);
		System.out.println(n.value);
		
		//找最小值和最大值
		Node s = tree.findSmallest();
		System.out.println(s.value);
		
		//删除数据
		boolean b = tree.delete(3);
		System.out.println(b);
		tree.iterate(tree.root);
	}

}
