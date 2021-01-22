package com.trx.socketdemo.datastructures.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        //先需要创建一颗二叉树
        BinaryTree  binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        HeroNode node6 = new HeroNode(6, "关胜1");
        HeroNode node7 = new HeroNode(7, "关胜2");
        HeroNode node8 = new HeroNode(8, "关胜3");
        HeroNode node9 = new HeroNode(9, "关胜4");
        HeroNode node10 = new HeroNode(10, "关胜5");
        HeroNode node11 = new HeroNode(11, "关胜6");
        HeroNode node12 = new HeroNode(12, "关胜7");
        //说明，我们先手动创建该二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
//        node2.setLeft(node6);
//        node2.setRight(node7);
//        node6.setLeft(node8);
//        node5.setLeft(node9);
//        node5.setRight(node10);
//        node4.setLeft(node11);
//        node11.setRight(node12);
        binaryTree.setRoot(root);

//        System.out.println("前序遍历");
//        binaryTree.preOrder();

//        System.out.println("中序遍历");
//		binaryTree.infixOrder();
//
//		System.out.println("后序遍历");
//		binaryTree.postOrder();

//        		System.out.println("前序遍历方式~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //中序遍历查找
        //中序遍历3次
//		System.out.println("中序遍历方式~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //后序遍历查找
        //后序遍历查找的次数  2次
//		System.out.println("后序遍历方式~~~");
//		HeroNode resNode = binaryTree.postOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}


        System.out.println("删除前,前序遍历");
        binaryTree.preOrder(); //  1,2,3,5,4
//        binaryTree.delNode(1);
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); // 1,2,3,4
    }
}

class BinaryTree{

    private HeroNode root;
    public void setRoot(HeroNode root){

        this.root = root;
    }

    //前序遍历
    public void preOrder(){

        if(this.root!=null){

            this.root.preOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder(){

        if(this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //后续遍历
    public void postOrder(){

        if(this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //前序遍历
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    public void delNode(int no){
        if(root!=null){
            if(root.getNo()==no){
                root = null;
            }else{
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树不能删除");
        }
    }
}

class HeroNode{

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder(){

        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if(this.left!=null){
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){

        //递归向左子树中序遍历
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);//先输出父节点
        //递归向右子树中序遍历
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){

        //递归向左子树后序遍历
        if(this.left!=null){
            this.left.postOrder();
        }

        //递归向右子树后序遍历
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);//先输出父节点
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        if(this.no==no){
            return this;
        }

        //1.则判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2.如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){//说明我们左子树找到
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no){

        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode!=null){
            return  resNode;
        }
        System.out.println("进入中序查找");
        if(this.no ==no){
            return this;
        }
        if(this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){

        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }

        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后续查找");
        if(this.no==no){

            return this;
        }

        return resNode;
    }

    //如果删除的节点是叶子节点，则删除该节点
    //如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no){

        //如果当前节点的左子节点不为空，并且左子节点就是要删除节点，就将this.left=null;并且就返回(结束递归删除)
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        //如果当前节点的右子节点不为空，并且右子节点就是要删除节点，就将this.right=null;并且就返回(结束递归删除)
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }

        //向左子树进行递归删除
        if(this.left!=null){
            this.left.delNode(no);
        }

        //向右子树进行递归删除
        if(this.right!=null){
            this.right.delNode(no);
        }
    }
}
