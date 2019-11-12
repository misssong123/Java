package com.qust.binarysorttree;
/**
 * 二叉排序树
 * @author 公共
 *增加节点
 *删除节点
 *	1.删除叶子节点
 *	2.删除存在单个节点的节点
 *	3.删除存在左右节点的节点
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int [] arr={7,3,4,1,10,9,13,2};
        BinarySortTree tree=new BinarySortTree();
        for(int a:arr){
            tree.addNode(new Node(a));
        }
        tree.postOrder();
        tree.delNode(9);
        tree.delNode(1);
        tree.delNode(7);
        tree.delNode(2);
        tree.delNode(3);
        tree.delNode(4);
        tree.delNode(13);
        tree.delNode(10);
        System.out.println("--------------------");
        tree.postOrder();
    }
}
class BinarySortTree{
    Node root;
    //添加节点
    public void addNode(Node node){
        if (root==null) {
            root=node;
        }else {
            root.addNode(node);
        }
    }
    //前序遍历
    public void preOrder(){
        if (root==null) {
            System.out.println("该二叉排序树为空");
        }else{
            root.preOrder();
        }
    }
    //中序遍历
    public void midOrder(){
        if (root==null) {
            System.out.println("该二叉排序树为空");
        }else{
            root.midOrder();
        }
    }
    //中序遍历
    public void postOrder(){
        if (root==null) {
            System.out.println("该二叉排序树为空");
        }else{
            root.postOrder();
        }
    }
    //查找要删除的节点
    public Node search(int value){
        if (root==null) {
            return null;
        }else{
            return root.search(value);
        }
    }
    //查找要删除的节点的父节点
    public Node searchParent(int value){
        if (root==null) {
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    //删除节点
    public void delNode(int value){
        if (root==null) {
            return;
        }else{
            //寻找要删除的节点
            Node targetNode=root.search(value);
            if (targetNode==null) {
                return;
            }
            System.out.println(targetNode.value);
            //判断该二叉排序树是否只存在root节点
            if (root.left==null&&root.right==null) {
                root=null;
                return ;
            }
            //去查找目标节点的父节点
            Node parent=root.searchParent(value);
            if (targetNode.left==null && targetNode.right==null) {//删除的节点为叶子节点
                if (parent.left!=null && parent.left.value==targetNode.value) {
                    parent.left=null;
                }else if (parent.right!=null&&parent.right.value==targetNode.value) {
                    parent.right=null;
                }
            }else if(targetNode.left!=null&&targetNode.right!=null){//删除具有左右子节点的节点
                //只需要将目标节点的值该为右侧子树中最小的值，或者左侧子树中最大的值，然后将该子节点删除即可
                //这里采用选取右侧子树中最小的值并将删除该节点
                int minVal=delRightTreeMin(targetNode.right);
                targetNode.value=minVal;
            }else{//删除含有单个子节点的节点
                //如果删除的节点具有左子树，首先判断该父节点是否为空
                if (targetNode.left!=null) {
                    if (parent!=null) {
                        //判断为左子树还是右子树
                        if (parent.left.value==targetNode.value) {
                            parent.left=targetNode.left;
                        }else {
                            parent.right=targetNode.right;
                        }
                    }else{
                        root=targetNode.left;
                    }
                }else{
                    if (parent!=null) {
                        if (parent.left.value==targetNode.value) {
                            parent.left=targetNode.right;
                        }else{
                            parent.right=targetNode.right;
                        }
                    }else{
                        root=targetNode.right;
                    }
                }
            }
        }
    }
    /**
     * 找到右侧子树中最小的值，并将该节点删除
     * @param node 传入的节点
     * @return 返回要删除节点的值
     */
    public int delRightTreeMin(Node node){//不要直接使用传入的节点进行使用
        Node targetNode=node;
        while(targetNode.left!=null){
            targetNode=targetNode.left;
        }
        int value=targetNode.value;
        delNode(value);//无非存在两种情况，一该节点为叶子节点，二该节点存在右子树
        return value;
    }
}
class  Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
    /**
     * 根据值，查找要删除的节点
     * @param value 需要删除的节点的值
     * @return 找到则会返回该节点，否则返回null
     */
    public Node search (int value){
        if (this.value==value) {
            return this;
        }else if(this.value>value){
            if (this.left==null) {
                return null;
            }
            return this.left.search(value);
        }else{
            if (this.right==null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    /**
     * 查找要删除节点的父节点
     * @param value 要查找的节点的值
     * @return 若找到则返回节点，否则返回null
     */
    public Node searchParent(int value){
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
            return this;
        }else{
            if (this.left!=null&&this.value>value) {
                return this.left.searchParent(value);
            }else if (this.right!=null&&this.value<=value) {
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
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
    //添加节点
    public void addNode(Node node){
        if (node==null) {
            return;
        }
        if (this.value>node.value) {//如果当前节点的值大于插入节点的值，则判断左子节点是否为空
            if (this.left==null) {
                this.left=node;
            }else{
                this.left.addNode(node);
            }
        }else{
            if (this.right==null) {
                this.right=node;
            }else {
                this.right.addNode(node);
            }
        }
    }
}
