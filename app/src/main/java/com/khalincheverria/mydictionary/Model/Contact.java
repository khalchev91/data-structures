package com.khalincheverria.mydictionary.Model;

import java.io.Serializable;


    public class Contact implements Serializable {

        private String word;
        private String definition;
        private String partOfSpeech;

        public Contact(String w, String d, String ps){
            setWord(w);
            setDefinition(d);
            setPartOfSpeech(ps);
        }

        public Contact(){
            this("", "", "");
        }

        public Contact(Contact contact){
            this(contact.getWord(), contact.getDefinition(), contact.getPartOfSpeech());
        }

        public String getWord() {
            return word;
        }
        public void setWord(String word) {
            this.word = word;
        }
        public String getDefinition() {
            return definition;
        }
        public void setDefinition(String definition) {
            this.definition = definition;
        }
        public String getPartOfSpeech() {
            return partOfSpeech;
        }
        public void setPartOfSpeech(String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
        }

        public String toString(){
            String out = "";

            out += "Contact:" + getWord() + "\n";
            out += "Definition:" + getDefinition() + "\n";
            out += "Part of Speech" + getPartOfSpeech() + "\n";
            return out;
        }

    }





