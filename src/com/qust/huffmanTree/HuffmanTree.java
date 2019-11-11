package com.qust.huffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//哈弗满树的使用
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root=createHuffmanTree(arr);
        preOrder(root);
    }
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else{
            System.out.println("该哈夫曼树为空");
        }
    }
    public static Node createHuffmanTree(int [] arr){
        List<Node> list=new ArrayList<>();
        for (int i :arr)
            list.add(new Node(i));
        while(list.size()>1){
            Collections.sort(list);
            Node left=list.get(0);
            Node right=list.get(1);
            Node parent=new Node(left.value+right.value);
            parent.left=left;
            parent.right=right;
            list.add(parent);
            list.remove(left);
            list.remove(right);
        }
        return list.get(0);
    }
}
class Node implements  Comparable<Node>{
    public int value;
    public Node left;
    public Node right;
    public Node(int value){
        this.value=value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    @Override
    public int compareTo(Node o) {//从小到大排序
        return this.value-o.value;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}