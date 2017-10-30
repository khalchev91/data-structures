package com.khalincheverria.mydictionary;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.khalincheverria.mydictionary.Model.Word;


public class ViewWord extends AppCompatActivity {


    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_word);
        ActionBar actionBar= getSupportActionBar();
        TextView definition;
        TextView wordText;
        TextView partOfSpeech;
        Word word;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle=getIntent().getExtras();
        word=(Word)bundle.getSerializable("Word");

        actionBar.setTitle(word.getWord());
        wordText=(TextView)findViewById(R.id.word);
        partOfSpeech=(TextView)findViewById(R.id.partOfSpeech);
        definition=(TextView)findViewById(R.id.definition);

        wordText.setText(word.getWord());
        partOfSpeech.setText(word.getPartOfSpeech());
        definition.setText(word.getDefinition());



    }
}
