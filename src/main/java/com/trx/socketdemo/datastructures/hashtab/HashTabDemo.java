package com.trx.socketdemo.datastructures.hashtab;

import java.util.Scanner;

public class HashTabDemo {


    public static void main(String[] args) {

        char key = ' ';
        HashTab  hashTab = new HashTab(7);
        Scanner  scanner = new  Scanner(System.in);
        while(true){
            System.out.println("a:增加链表");
            System.out.println("l:显示链表");
            System.out.println("f:查找链表");
            System.out.println("e:退出");
            key = scanner.next().charAt(0);

            switch (key){

                case 'a':
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case 'l':
                    hashTab.list();
                    break;
                case 'f':
                    System.out.println("输入id");
                    int no = scanner.nextInt();
                    hashTab.find(no);
                    break;
                case 'e':
                    scanner.close();
                    System.exit(0);
                    default:
                        break;

            }

        }
    }
}

class Emp {

    public int id;
    public String  name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpList{
    private Emp head;
    public void add(Emp emp){

        if(head==null){
            head = emp;
            return;
        }

        Emp temp = head;
        while(true){

            if(temp.next==null){
                break;
            }

            temp = temp.next;
        }
        temp.next = emp;
    }

    public void list(){

        if(head==null){
            return;
        }
        Emp temp = head;
        while(true){
            System.out.println("雇员id="+temp.id+";雇员name="+temp.name);
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
    }


    public void  find(int no){

        if(head==null){

            return ;
        }

        Emp  temp = head;
        while(true){
            if(temp.id==no){
                System.out.println("雇员id="+temp.id+";雇员name="+temp.name);
                break;
            }
            if(temp.next==null){
                break;
            }

            temp = temp.next;
        }

    }
}

class HashTab{

private int size;

private EmpList[]  empLists;
public HashTab(int size){

    this.size = size;
    empLists = new EmpList[size];
    for (int i = 0; i <size ; i++) {
        empLists[i] = new  EmpList();
    }
}

public void  add(Emp emp){

    empLists[Fun(emp.id)].add(emp);
}

public void list(){
    for (int i = 0; i <size ; i++) {
        empLists[i].list();
    }
}
public void find(int no){
    empLists[Fun(no)].find(no);
}
public int Fun(int id){
    return id%size;
}
}