package com.gzh.tree;

/**
 * 二叉树
 * <pre>
 * @author gongzhihao
 * @date 2018年10月9日 下午1:59:38
 * </pre>
 */
public class Tree {
	//数据
	Node root;
	
	//方法
	//插入
	/**
	 * 插入数据
	 * <pre>
	 * @author gzh
	 * @date 2018年10月8日 下午7:47:08
	 * @param key
	 * @param value
	 * </pre>
	 */
	public void insert(String key,int value) {
		//创建新节点
		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		
		//插入节点
		if (root == null) { //如果是第一个节点
			root = newNode;
		} else { //如果不是第一个节点
			//先找到数据
			Node p = root;
			Node pParent = root; //初始值是root
			
			while (true) {
				//指针指向左子节点或右子节点
				if (value < p.value) { //指针指向左子节点
					pParent = p; //保存p的父节点
					p = p.leftChild;
					
					if (p == null) { //当指针为null时，就是新节点要插入的位置
						pParent.leftChild = newNode; //插入新节点
						return;
					}
				} else { //指针指向右子节点
					pParent = p; //保存p的父节点
					p = p.rightChild;
					
					if (p == null) { //当指针为null时，就是新节点要插入的位置
						pParent.rightChild = newNode; //插入新节点
						return;
					}
				}
			}
			
			//再插入数据
			//上面代码查找数据的时候，就已经立即插入新节点了
		}
	}
	
	//查询
	/**
	 * 查询数据
	 * <pre>
	 * 注：这个方法的代码假设树至少有1个以上的节点数据。
	 * @author gzh
	 * @date 2018年10月8日 下午7:20:27
	 * @param value
	 * @return 找到的节点
	 * </pre>
	 */
	public Node find(int value) {
		Node p = root; //指针从根节点开始
		
		//指针开始扫描
		while(p.value != value) { //如果值不相等，就一直扫描下去
			//指针要么指向左子节点，要么指向右子节点
			if (p.value > value) { //指针指向左子节点
				p = p.leftChild;
			} else { //指针指向右子节点
				p = p.rightChild;
			}
			
			//指针如果为null，那么扫码结束
			if (p == null) { //没找到节点
				return p; 
			}
		}
		
		return p; //找到节点
		
	}
	
	//找最小值和最大值
	/**
	 * 找最小值
	 * <pre>
	 * @author gzh
	 * @date 2018年10月8日 下午8:07:45
	 * @return 最小值
	 * </pre>
	 */
	public Node findSmallest() {
		Node p = root;
		Node pParent = root; //p的父节点初始值是root
		
		while(p != null) { //只要指针不为null，一直左移扫描左子节点
			pParent = p; //保存父节点
			p = p.leftChild; //如果是找最大值，那么这里是指向右子节点
		}
		
		return pParent;
		
	}
	
	//遍历所有数据
	/**
	 * 中序遍历
	 * <pre>
	 * @author gzh
	 * @date 2018年10月8日 下午8:14:20
	 * @param p 传入根节点
	 * </pre>
	 */
	public void iterate(Node p) {
		if (p != null) { //结束的标志
			iterate(p.leftChild);
			System.out.println(p.value); //输出的顺序在第几个
			iterate(p.rightChild);
		}
	}
	
	//删除
	public boolean delete(int value) {
		Node p = root; //指针
		Node pNode = root; //指针的父节点(但是初始值和指针一样都是root)
		
		boolean isLeftNode = true; //指针是左节点还是右节点
		
		//找到要删除的节点
		while (p.value != value) { 
			if (value < p.value) { 
				pNode = p;
				p = p.leftChild;
				isLeftNode = true;
			} else {
				pNode = p;
				p = p.rightChild;
				isLeftNode = false;
			}
			
			if (p == null) { //没找到数据
				return false;
			}
		}
		
		//找到了数据
		//按要删除的节点是否有子节点分以下几种情况，1.没有子节点 2.有子节点：1）只有左子节点 2）只有右子节点 3）有左右子节点
		if (p.leftChild==null && p.rightChild==null) { //1.没有子节点
			if (p == root) { //根节点就是要删除的节点
				root = null; //根节点置空，树是一颗空树
			}else if (isLeftNode) {
				pNode.leftChild = null; //置空(即删除节点)
			}else {
				pNode.rightChild = null;
			}
		} else if (p.rightChild == null) { //1)只有左子节点
			if (p == root) { //根节点就是要删除的节点
				root = p.leftChild; //根节点指向p的左子节点
			}else if (isLeftNode) { //p是父节点的左子节点，决定了是使用父节点的左指针指向p的左子节点
				pNode.leftChild = p.leftChild; //p父节点指向p的左子节点
			}else {  //p是父节点的右子节点，决定了是使用父节点的右指针指向p的左子节点
				pNode.rightChild = p.leftChild; //p父节点指向p的左子节点
			}
		} else if (p.leftChild == null) { //2)只有右子节点
			if (p == root) { //根节点就是要删除的节点
				root = p.rightChild; //根节点指向p的右子节点(即删除旧的根节点，插入新的根节点p.rightChild到根节点的位置)
			}else if (isLeftNode) { 
				pNode.leftChild = p.rightChild; 
			}else {  
				pNode.rightChild = p.rightChild; 
			}
		}else { //3)有左右子节点：最难的就是这种情况
			//找到要删除节点的后继节点
			//分2种情况，1.后继节点是p的右子节点 2.后继节点不是p的右子节点，而是右子节点的左子节点
			Node h = findH(p);
			if (p == root) {
				root = h;
			} if (isLeftNode) {
				pNode.leftChild = h;
			} else {
				pNode.rightChild = h;
			}
			
			//插入后继节点
			h.rightChild = p.rightChild;
		}
		return true;
	}

	/**
	 * 找后继节点
	 * <pre>
	 * @author gzh
	 * @date 2018年10月9日 上午11:00:18
	 * @param p1 找传入节点的后继节点
	 * @return
	 * </pre>
	 */
	private Node findH(Node p) {
		Node p1 = p.rightChild; //用于扫描右子树，找到右子树的最小值
		Node h =  p.rightChild; //后继节点初始值是右子节点 
		Node hParent = p; //p1的父节点初始值是p
				
		while(p1 != null) {
			hParent = p1; //保存父节点
			p1 = p1.leftChild; //指向左子节点
			h = p1; //后继节点也指向左子节点
		}
		
		if (h != p.rightChild) {
			//后继节点的父节点(父节点的左子节点)指向后继节点的右子节点
			hParent = h.rightChild;
			
			//后继节点的右子节点指向要删除节点的右子节点
			h.rightChild = p.rightChild;
		}
		
		return h;
	}
}
