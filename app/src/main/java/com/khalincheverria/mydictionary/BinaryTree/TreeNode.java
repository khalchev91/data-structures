package com.khalincheverria.mydictionary.BinaryTree;

import com.khalincheverria.mydictionary.Model.Word;

import java.io.Serializable;

/*
 * Created by Khalin Cheverria 1501396
 * Chrysannae Mason 1503793
 * Lorenzo Buchanan 1504084
 *
 * on 3/14/2017.
 */

public class TreeNode implements Serializable {
    private TreeNode left,right;
    private Word word;

    public TreeNode(){
        left=null;
        right=null;
        word=new Word();
    }
    public TreeNode(Word word){
        left=null;
        right=null;
        this.word=word;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String toString(){
        return word.toString();
    }
}