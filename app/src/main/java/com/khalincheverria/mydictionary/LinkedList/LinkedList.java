package com.khalincheverria.mydictionary.LinkedList;


import com.khalincheverria.mydictionary.Model.Word;

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

    public void insert(Word word){
        Node temp1 = new Node(word);
        Node temp2;
        temp2=head;
        if(head==null){
            head = temp1;
        }else{
            while(temp2.getNext()!=null ){
                if(temp2.getData().getWord().compareToIgnoreCase(word.getWord())==0){
                    word.setDefinition(word.getDefinition()+"\n"+"\n"+temp2.getData().getDefinition());
                    if((word.getPartOfSpeech().compareToIgnoreCase(temp2.getData().getPartOfSpeech())!=0)) {
                        word.setPartOfSpeech(word.getPartOfSpeech()+"\t"+"\t"+temp2.getData().getPartOfSpeech());
                    }
                    temp2.setData(word);
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

    public void addWord(Word word){
        Node node=new Node(word);
        if(head==null){
            head=node;
        }else if(head.getData().getWord().compareToIgnoreCase(word.getWord())==0){
            word.setDefinition(word.getDefinition()+"\n"+head.getData().getDefinition());
            if(!word.getPartOfSpeech().trim().equals(head.getData().getPartOfSpeech().trim())) {
                word.setPartOfSpeech(word.getPartOfSpeech()+"\n"+head.getData().getPartOfSpeech());
            }
            head.setData(word);
            return;
        }
        else if(word.getWord().compareTo(head.getData().getWord())<0){
            node.setNext(head);
            head=node;
        }else {
            Node before=head;
            Node after= head.getNext();
            while (after!=null){
                if (before.getData().getWord().compareToIgnoreCase(word.getWord())==0){
                    word.setDefinition(before.getData().getDefinition()+"\n"+"\n"+word.getDefinition());
                    if(!(word.getPartOfSpeech().trim().compareToIgnoreCase(before.getData().getPartOfSpeech().trim())==0)) {
                        word.setPartOfSpeech(before.getData().getPartOfSpeech()+"\t"+"\t"+word.getPartOfSpeech());
                    }
                    before.setData(word);
                    return;
                }
                if(word.getWord().compareTo(after.getData().getWord())<0){
                    break;
                }
                before=after;
                after=after.getNext();
            }
            node.setNext(before.getNext());
            before.setNext(node);
        }
    }


        public Word retrieve(String searchWord){
            Node temp;
            Word word =null;
            int count=0;
            temp=head;
            if(!isEmpty()){
                while (temp!=null){
                    if(temp.getData().getWord().compareToIgnoreCase(searchWord)==0){
                        word=temp.getData();
                        setCount(count);
                        return word;
                    }
                    temp=temp.getNext();
                    count++;
                }
            }else {
                System.out.println("list is empty");
            }
            count=-1;
            return word;
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

    private Word[] convertList(LinkedList linkedList, int size){
        int count = 0, i;
        Word[] words = new Word[size];
        Node temp = head;

        while(temp!=null){
            for(i=count;i<size;i++){
                words[count] = temp.getData();
            }
            temp = temp.getNext();
            count++;
        }
        return words;
    }

    private Word[] sortList(Word[] sortedWords, int size){
        int i, j;
        Word tmp = new Word();
        for(i=0;i<size;i++){
            for(j=i+1;j<size;j++){
                if(sortedWords[i].getWord().compareTo(sortedWords[j].getWord())>0){
                    tmp = sortedWords[i];
                    sortedWords[i] = sortedWords[j];
                    sortedWords[j] = tmp;
                }
            }
        }
        return sortedWords;
    }

    private void arrayToList(Word[] w1, int size){
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
        Word[] arr = null;
        arr = convertList(n1, size);
        arr = sortList(arr, size);
        deleteList(n1);
        arrayToList(arr, size);
    }

public Word get(int index){
int count=0;
    Word word= new Word();

    if(head!=null) {
        Node temp=head;
        while (temp.getNext() != null && count != index) {
            temp = temp.getNext();
            count++;
        }
        word=temp.getData();
    }else {
        System.out.println("List is empty");
    }

    return word;
    }



}

