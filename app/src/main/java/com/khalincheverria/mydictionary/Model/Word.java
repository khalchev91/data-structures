package com.khalincheverria.mydictionary.Model;

import java.io.Serializable;


    public class Word implements Serializable {

        private String word;
        private String definition;
        private String partOfSpeech;

        public Word(String w, String d, String ps){
            setWord(w);
            setDefinition(d);
            setPartOfSpeech(ps);
        }

        public Word(){
            this("", "", "");
        }

        public Word (Word word){
            this(word.getWord(), word.getDefinition(), word.getPartOfSpeech());
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

            out += "Word:" + getWord() + "\n";
            out += "Definition:" + getDefinition() + "\n";
            out += "Part of Speech" + getPartOfSpeech() + "\n";
            return out;
        }

    }





