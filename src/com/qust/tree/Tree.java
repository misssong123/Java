package com.qust.tree;
/**
 * 树的遍历
 * @author 公共
 *前序遍历:根节点->左节点->右节点
 *中序遍历:左节点->根节点->右节点
 *后序遍历:左节点->右节点->根节点
 */
public class Tree {
public static void main(String[] args) {
	Number root=new Number(5);
	Number node1=new Number(3);
	Number node2=new Number(1);
	Number node3=new Number(4);
	Number node4=new Number(7);
	Number node5=new Number(8);
	Number node6=new Number(9);
	
	BinaryTree tree=new BinaryTree(root);
	tree.root.setLeft(node1);
	node1.setLeft(node2);
	node1.setRight(node3);
	root.setRight(node5);
	node5.setLeft(node4);
	node5.setRight(node6);
	
	System.out.println("前序遍历");
	tree.preOrder();
	System.out.println("中序遍历");
	tree.midOrder();
	System.out.println("后序遍历");
	tree.postOrder();
	System.out.println("前序查找");
	System.out.println(tree.preSearch(7));
	System.out.println("中序查找");
	System.out.println(tree.midSearch(7));
	System.out.println("后序查找");
	System.out.println(tree.postSearch(7));
}
}
class BinaryTree{
	public Number root;
	public BinaryTree(Number root) {
		// TODO Auto-generated constructor stub
		this.root=root;
	}
	//前序遍历
	public void preOrder(){
		if (root!=null) {
			this.root.preOrder();
		}
	}
	//中序遍历
	public void midOrder(){
		if (root!=null) {
			this.root.midOrder();
		}
	}
	//后序遍历
	public void postOrder(){
		if (root!=null) {
			this.root.postOrder();
		}
	}
	//前序查找
	public Number preSearch(int no){
		Number result=null;
		if (root!=null) {
			result=this.root.preSearch(no);
			return result;
		}else {
			return null;
		}
	}
	//中序查找
	public Number midSearch(int no){
		Number result=null;
		if (root!=null) {
			result=this.root.midSearch(no);
			return result;
		}else {
			return null;
		}
	}
	//后序查找
	public Number postSearch(int no){
		Number result=null;
		if (root!=null) {
			result=this.root.postSearch(no);
			return result;
		}else {
			return null;
		}
	}
}
class Number{
	private int no;
	private Number left;
	private Number right;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Number getLeft() {
		return left;
	}
	public void setLeft(Number left) {
		this.left = left;
	}
	public Number getRight() {
		return right;
	}
	public void setRight(Number right) {
		this.right = right;
	}
	public Number(int no) {
		super();
		this.no = no;
	}
	public Number() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Number [no=" + no + "]";
	}
	//前序遍历
	public void preOrder(){
		System.out.println(this);
		if (this.left!=null) {
			this.left.preOrder();
		}
		if (this.right!=null) {
			this.right.preOrder();		
		}
	}
	//中序遍历
	public void midOrder(){		
		if (this.left!=null) {
			this.left.midOrder();
		}
		System.out.println(this);
		if (this.right!=null) {
			this.right.midOrder();			
		}
	}
	//后序遍历
	public void postOrder(){
		if (this.left!=null) {
			this.left.postOrder();
		}
		if (this.right!=null) {
			this.right.postOrder();			
		}
		System.out.println(this);
	}
	//前序查找
	public Number preSearch(int no){
		System.out.println("前序查找~~~~");
		if (this.no==no) {
			return this;
		}
		Number result=null;
		if (this.left!=null) {
			result=this.left.preSearch(no);
		}
		if (result!=null) {
			return result;
		}
		if (this.right!=null) {
			result=this.right.preSearch(no);
		}
		return result;
	}
	//中序查找
	public Number midSearch(int no){
		Number result=null;
		if (this.left!=null) {
			result=this.left.midSearch(no);
		}
		if (result!=null) {
			return result;
		}
		System.out.println("中序查找~~~~");
		if (this.no==no) {
			return this;
		}
		if (this.right!=null) {
			result=this.right.midSearch(no);
		}
		return result;
	}
	//后序查找
	public Number postSearch(int no){
		Number result=null;
		if (this.left!=null) {
			result=this.left.postSearch(no);
		}
		if (result!=null) {
			return result;
		}
		if (this.right!=null) {
			result=this.right.postSearch(no);
		}
		if (result!=null) {
			return result;
		}
		System.out.println("后序查找~~~~");
		if (this.no==no) {
			return this;
		}
		return result;
	}
}