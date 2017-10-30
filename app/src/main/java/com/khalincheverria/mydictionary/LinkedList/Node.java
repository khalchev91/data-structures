package com.khalincheverria.mydictionary.LinkedList;


import com.khalincheverria.mydictionary.Model.Contact;

import java.io.Serializable;


    @SuppressWarnings({"WeakerAccess", "unused"})
    public class Node implements Serializable {
        private Node next;
        private Contact data;

        public Node(Contact data){
            setData(data);
            setNext(null);
        }
        public Node(){
            this(new Contact());
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

    public Contact getData() {
        return data;
    }

    public void setData(Contact data) {
        this.data = data;
    }

    public String toString(){
            return data.toString();
        }
    }

