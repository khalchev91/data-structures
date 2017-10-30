package com.khalincheverria.mydictionary.BinaryTree;


import com.khalincheverria.mydictionary.Model.Contact;

import java.io.Serializable;


@SuppressWarnings("ConstantConditions")
public class BinaryTree implements Serializable {
    private TreeNode root;
    private Contact contact;
    boolean check=false;
   public int count;


    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    public BinaryTree(){
        root=null;
    }


    public boolean isEmpty(){
        return root==null;

    }



    public void insert(Contact contact){
        TreeNode treeNode=new TreeNode(contact);
        TreeNode node;
        if(treeNode!=null){
            if(root==null){
                root=treeNode;
            }else {
                node=root;
                while (true){
                    if(treeNode.getContact().getWord().equalsIgnoreCase(node.getContact().getWord())) {
                        contact.setDefinition(node.getContact().getDefinition()+"\n"+"\n"+ contact.getDefinition());
                        if (!(contact.getPartOfSpeech().trim().compareToIgnoreCase(node.getContact().getPartOfSpeech().trim())==0)) {
                            contact.setPartOfSpeech(contact.getPartOfSpeech()+"\t"+"\t"+node.getContact().getPartOfSpeech());
                        }
                        node.setContact(contact);
                        return;
                    }
                    if(treeNode.getContact().getWord().compareToIgnoreCase(node.getContact().getWord())<0){
                        if(node.getLeft()==null){
                            node.setLeft(treeNode);
                            break;
                        }else {
                            node=node.getLeft();
                        }
                    }else {
                        if(node.getRight()==null){
                            node.setRight(treeNode);
                            break;
                        }else {
                            node=node.getRight();
                        }
                    }
                }
            }
        }
    }
    public void display(){
        inOrder(root);
    }

    private void inOrder(TreeNode node){
        if(node!=null){
            inOrder(node.getLeft());
            System.out.println(node.getContact());
            inOrder(node.getRight());
        }
    }

    public int count(){
        return count(root);

    }

    private int count(TreeNode node){
        if(node==null){
            return 0;
        }else {
            int l=1;
            l+=count(node.getLeft());
            l+=count(node.getRight());
            return l;
        }
    }
    public class Counter {
        int count = 0;
    }

    private void inOrderTraverseTree(TreeNode root, int index, Counter counter){
        if(root == null || counter.count > index) {
            return;
        }
        inOrderTraverseTree(root.getLeft(),index,counter);
        if (counter.count == index) {
            setContact(root.getContact());
        }
        counter.count = counter.count + 1;
        inOrderTraverseTree(root.getRight(),index,counter);

    }
    public Contact get(int index){
        inOrderTraverseTree(root,index,new Counter());
        return contact;
    }

public boolean contains(String key){

  TreeNode node= root;
    while (node!=null) {
        if(key.trim().equalsIgnoreCase(node.getContact().getWord())){
            return true;
        }
        if (key.compareToIgnoreCase(node.getContact().getWord()) < 0) {
            node = node.getLeft();
        } else {
            node = node.getRight();
        }
    }
    return false;
}




    public Contact searchWord(String word) {
        TreeNode current = root;
        count=0;
        while (current != null) {
            if (word.compareToIgnoreCase(current.getContact().getWord()) == 0) {
                return current.getContact();
            } else if (word.compareToIgnoreCase(current.getContact().getWord()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            count++;
        }
        setCount(-1);
        return null;
    }

    public void clear(){
        root=null;
    }
}
