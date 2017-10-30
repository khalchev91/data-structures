package com.khalincheverria.mydictionary.LinkedList;


import com.khalincheverria.mydictionary.Model.Word;

import java.io.Serializable;

/*
 * Created by Khalin Cheverria 1501396
 * Chrysannae Mason 1503793
 * Lorenzo Buchanan 1504084
 * on 3/14/2017.
 */
    @SuppressWarnings({"WeakerAccess", "unused"})
    public class Node implements Serializable {
        private Node next;
        private Word data;

        public Node(Word data){
            setData(data);
            setNext(null);
        }
        public Node(){
            this(new Word());
        }

        public Node(Node node){
            this(node.getData());
        }
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;

        }

    public Word getData() {
        return data;
    }

    public void setData(Word data) {
        this.data = data;
    }

    public String toString(){
            return data.toString();
        }
    }

