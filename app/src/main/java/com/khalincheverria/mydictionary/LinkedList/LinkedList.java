package com.khalincheverria.mydictionary.LinkedList;


import com.khalincheverria.mydictionary.Model.Contact;

import java.io.Serializable;


public class LinkedList implements Serializable{

        private Node head;
        public int count;
        public LinkedList(){
            setHead(null);
        }



        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

    public void setCount(int count) {
        this.count = count;
    }


    public boolean isEmpty() {
            return head == null;
        }
        public boolean isFull(){
            Node temp =new Node();
            if(temp!=null){
                return false;
            }
            return true;
        }

        public void clear(){
            if(!isEmpty()) {
                Node temp = null;
                while (head!=null){
                    temp=head;
                    head=head.getNext();
                    temp=null;
                }
            }else {
                System.out.println("List is empty");
            }
        }

    public void insert(Contact contact){
        Node temp1 = new Node(contact);
        Node temp2;
        temp2=head;
        if(head==null){
            head = temp1;
        }else{
            while(temp2.getNext()!=null ){
                if(temp2.getData().getWord().compareToIgnoreCase(contact.getWord())==0){
                    contact.setDefinition(contact.getDefinition()+"\n"+"\n"+temp2.getData().getDefinition());
                    if((contact.getPartOfSpeech().compareToIgnoreCase(temp2.getData().getPartOfSpeech())!=0)) {
                        contact.setPartOfSpeech(contact.getPartOfSpeech()+"\t"+"\t"+temp2.getData().getPartOfSpeech());
                    }
                    temp2.setData(contact);
                    return;
                }
                temp2 = temp2.getNext();
            }
            temp2.setNext(temp1);
        }
    }

public boolean contains(String word){
           Node temp= head;
            if(head!=null){
                while (temp!=null){
                    if(temp.getData().getWord().trim().equalsIgnoreCase(word.trim())){
                        return true;
                    }
                    temp=temp.getNext();
                }
            }
            return false;
}

    public void addWord(Contact contact){
        Node node=new Node(contact);
        if(head==null){
            head=node;
        }else if(head.getData().getWord().compareToIgnoreCase(contact.getWord())==0){
            contact.setDefinition(contact.getDefinition()+"\n"+head.getData().getDefinition());
            if(!contact.getPartOfSpeech().trim().equals(head.getData().getPartOfSpeech().trim())) {
                contact.setPartOfSpeech(contact.getPartOfSpeech()+"\n"+head.getData().getPartOfSpeech());
            }
            head.setData(contact);
            return;
        }
        else if(contact.getWord().compareTo(head.getData().getWord())<0){
            node.setNext(head);
            head=node;
        }else {
            Node before=head;
            Node after= head.getNext();
            while (after!=null){
                if (before.getData().getWord().compareToIgnoreCase(contact.getWord())==0){
                    contact.setDefinition(before.getData().getDefinition()+"\n"+"\n"+ contact.getDefinition());
                    if(!(contact.getPartOfSpeech().trim().compareToIgnoreCase(before.getData().getPartOfSpeech().trim())==0)) {
                        contact.setPartOfSpeech(before.getData().getPartOfSpeech()+"\t"+"\t"+ contact.getPartOfSpeech());
                    }
                    before.setData(contact);
                    return;
                }
                if(contact.getWord().compareTo(after.getData().getWord())<0){
                    break;
                }
                before=after;
                after=after.getNext();
            }
            node.setNext(before.getNext());
            before.setNext(node);
        }
    }


        public Contact retrieve(String searchWord){
            Node temp;
            Contact contact =null;
            int count=0;
            temp=head;
            if(!isEmpty()){
                while (temp!=null){
                    if(temp.getData().getWord().compareToIgnoreCase(searchWord)==0){
                        contact =temp.getData();
                        setCount(count);
                        return contact;
                    }
                    temp=temp.getNext();
                    count++;
                }
            }else {
                System.out.println("list is empty");
            }
            count=-1;
            return contact;
        }
        public void display() {
            Node temp = head;
            if (head != null) {
                while (temp != null) {
                    System.out.println(temp);
                    temp = temp.getNext();
                }
            }else {
                System.out.println("List empty");
            }
        }

    private Contact[] convertList(LinkedList linkedList, int size){
        int count = 0, i;
        Contact[] contacts = new Contact[size];
        Node temp = head;

        while(temp!=null){
            for(i=count;i<size;i++){
                contacts[count] = temp.getData();
            }
            temp = temp.getNext();
            count++;
        }
        return contacts;
    }

    private Contact[] sortList(Contact[] sortedContacts, int size){
        int i, j;
        Contact tmp = new Contact();
        for(i=0;i<size;i++){
            for(j=i+1;j<size;j++){
                if(sortedContacts[i].getWord().compareTo(sortedContacts[j].getWord())>0){
                    tmp = sortedContacts[i];
                    sortedContacts[i] = sortedContacts[j];
                    sortedContacts[j] = tmp;
                }
            }
        }
        return sortedContacts;
    }

    private void arrayToList(Contact[] w1, int size){
        int i;

        for(i=0;i<size;i++){
            insert(w1[i]);
        }
    }

    private void deleteList(LinkedList l1){
        head = null;
    }

    public int getSizeOfList(){
        Node temp;
        int count = 1;

        if(head!=null) {
            temp = head;
            while (temp.getNext() != null) {
                count++;
                temp = temp.getNext();
            }
        }else {
            return 0;
        }
        return count;
    }


    public void sortList(LinkedList n1){
        int size = getSizeOfList();
        Contact[] arr = null;
        arr = convertList(n1, size);
        arr = sortList(arr, size);
        deleteList(n1);
        arrayToList(arr, size);
    }

public Contact get(int index){
int count=0;
    Contact contact = new Contact();

    if(head!=null) {
        Node temp=head;
        while (temp.getNext() != null && count != index) {
            temp = temp.getNext();
            count++;
        }
        contact =temp.getData();
    }else {
        System.out.println("List is empty");
    }

    return contact;
    }



}

