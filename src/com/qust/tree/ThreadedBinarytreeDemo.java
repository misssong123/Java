package com.qust.tree;


public class ThreadedBinarytreeDemo {

	public static void main(String[] args) {
		Node root=new Node(5);
		Node node1=new Node(3);
		Node node2=new Node(1);
		Node node3=new Node(4);
		Node node4=new Node(7);
		Node node5=new Node(8);
		Node node6=new Node(9);
		ThreadedBinaryTree tree=new ThreadedBinaryTree(root);
		tree.root.setLeft(node1);
		node1.setLeft(node2);
		node1.setRight(node3);
		root.setRight(node5);
		node5.setLeft(node4);
		node5.setRight(node6);
		tree.preOrder();
		tree.midOrder();
		tree.midThreaded(root);
		System.out.println("-----------------------------");
		System.out.println(node3.getLeftType());
		System.out.println(node3.getRightType());
		System.out.println(node3.getLeft());
		System.out.println(node3.getRight());
	}
}
class ThreadedBinaryTree{
	public Node root;
	public Node pre;//用来记录前一个节点，用于前驱和后驱节点的使用
	public ThreadedBinaryTree(Node root) {
		// TODO Auto-generated constructor stub
		this.root=root;
	}
	//中序线索化遍历
	public void midThreadedList(){
		Node node=root;
		while (node!=null){
			while (node.getLeftType()==0){}
			node=node.getLeft();
		}
		System.out.println(node);
		while (node.getRightType()==1){
			node=node.getRight();
			System.out.println(node);
		}
		node=node.getRight();
	}
	//中序线索化
	public void midThreaded(Node node){
		if (node==null) {
			return;
		}
		//左节点线索化
		midThreaded(node.getLeft());
		//设置前驱节点
		if (node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		//设置后驱节点
		if (pre!=null&&pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		//让pre节点向后移动
		pre=node;
		//右节点线索化
		midThreaded(node.getRight());
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
	public Node preSearch(int no){
		Node result=null;
		if (root!=null) {
			result=this.root.preSearch(no);
			return result;
		}else {
			return null;
		}
	}
	//中序查找
	public Node midSearch(int no){
		Node result=null;
		if (root!=null) {
			result=this.root.midSearch(no);
			return result;
		}else {
			return null;
		}
	}
	//后序查找
	public Node postSearch(int no){
		Node result=null;
		if (root!=null) {
			result=this.root.postSearch(no);
			return result;
		}else {
			return null;
		}
	}
	//删除节点
	public void deleteNode(int no){
		if (root==null&&root.getNo()==no) {
			root=null;
		}else{
			root.deleteNode(no);
		}
	}
}
class Node{
	private int no;
	private Node left;
	private Node right;
	private int leftType;//用来记录当前节点的左节点属于左子树还是前驱节点
	private int rightType;//用来记录当前节点的右节点属于右子树还是后驱节点
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node(int no) {
		super();
		this.no = no;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Node [no=" + no + "]";
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
	public Node preSearch(int no){
		System.out.println("前序查找~~~~");
		if (this.no==no) {
			return this;
		}
		Node result=null;
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
	public Node midSearch(int no){
		Node result=null;
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
	public Node postSearch(int no){
		Node result=null;
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
	public  void deleteNode(int no){
		if (this.left!=null&&this.left.no==no) {
			this.left=null;
			return;
		}
		if (this.right!=null&&this.right.no==no) {
			this.right=null;
			return;
		}
		if (this.left!=null) {
			this.left.deleteNode(no);
		}
		if (this.right!=null) {
			this.right.deleteNode(no);
		}
	}
}