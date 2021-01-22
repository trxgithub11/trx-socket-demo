package com.trx.socketdemo.datastructures.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(3, "吴用", "智多星");
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero5);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.list();
    }
}

class SingleLinkedList{

    private HeroNode head = new HeroNode(0,"","");
    public HeroNode getHead(){

        return head;
    }

    public void add(HeroNode heroNode){

        HeroNode  temp = head;
        while(true){

            if(temp.next==null){

                break;
            }

            temp = temp.next ;
        }

        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){

        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next==null){

                break;
            }
            if(temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no==heroNode.no){

                flag=true;
                break;
            }

            temp = temp.next;

        }

        if(flag){

            System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode){

        if(head.next==null){

            System.out.println("链表为空~");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }

            temp = temp.next;
        }
        if(flag){

            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.printf("没有找到编号%d的节点,不能修改\n",newHeroNode);
        }
    }

    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){

            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode{

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
