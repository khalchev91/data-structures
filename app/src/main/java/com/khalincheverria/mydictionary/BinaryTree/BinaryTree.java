package com.khalincheverria.mydictionary.BinaryTree;


import com.khalincheverria.mydictionary.Model.Word;

import java.io.Serializable;

/**
 * Created by Khalin Cheverria 1501396
 * Chrysannae Mason 1503793
 * Lorenzo Buchanan 1504084
 *
 * on 3/14/2017.
 */
@SuppressWarnings("ConstantConditions")
public class BinaryTree implements Serializable {
    private TreeNode root;
    private Word word;
    boolean check=false;
   public int count;


    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setWord(Word word) {
        this.word = word;
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



    public void insert(Word word){
        TreeNode treeNode=new TreeNode(word);
        TreeNode node;
        if(treeNode!=null){
            if(root==null){
                root=treeNode;
            }else {
                node=root;
                while (true){
                    if(treeNode.getWord().getWord().equalsIgnoreCase(node.getWord().getWord())) {
                        word.setDefinition(node.getWord().getDefinition()+"\n"+"\n"+word.getDefinition());
                        if (!(word.getPartOfSpeech().trim().compareToIgnoreCase(node.getWord().getPartOfSpeech().trim())==0)) {
                            word.setPartOfSpeech(word.getPartOfSpeech()+"\t"+"\t"+node.getWord().getPartOfSpeech());
                        }
                        node.setWord(word);
                        return;
                    }
                    if(treeNode.getWord().getWord().compareToIgnoreCase(node.getWord().getWord())<0){
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
            System.out.println(node.getWord());
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
            setWord(root.getWord());
        }
        counter.count = counter.count + 1;
        inOrderTraverseTree(root.getRight(),index,counter);

    }
    public Word get(int index){
        inOrderTraverseTree(root,index,new Counter());
        return word;
    }

public boolean contains(String key){

  TreeNode node= root;
    while (node!=null) {
        if(key.trim().equalsIgnoreCase(node.getWord().getWord())){
            return true;
        }
        if (key.compareToIgnoreCase(node.getWord().getWord()) < 0) {
            node = node.getLeft();
        } else {
            node = node.getRight();
        }
    }
    return false;
}




    public Word searchWord(String word) {
        TreeNode current = root;
        count=0;
        while (current != null) {
            if (word.compareToIgnoreCase(current.getWord().getWord()) == 0) {
                return current.getWord();
            } else if (word.compareToIgnoreCase(current.getWord().getWord()) < 0) {
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
