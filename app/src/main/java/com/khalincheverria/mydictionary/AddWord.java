package com.khalincheverria.mydictionary;

/*
 * Created by Khalin Cheverria 1501396
 * Chrysannae Mason 1503793
 * Lorenzo Buchanan 1504084
 *
 * on 3/14/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.khalincheverria.mydictionary.Model.Word;

public class AddWord extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private EditText newWordField;
    private EditText definitionField;
    private Spinner partOfSpeechSpinner;
    private Button addWordButton;
    private Word word=new Word();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        getSupportActionBar().setTitle("Add a New Word");

        String newWord=getIntent().getStringExtra("NewWord");

        newWordField=(EditText)findViewById(R.id.word_name);

        if(newWord!=null){
            newWordField.setText(newWord);
        }

        partOfSpeechSpinner=(Spinner)findViewById(R.id.part_of_speech);
        definitionField=(EditText)findViewById(R.id.word_definition);
        addWordButton=(Button)findViewById(R.id.save_word);


        //ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.part_of_speech,R.layout.spinnerlist);

        //adapter.setDropDownViewResource(R.layout.spinnerlist);
        //partOfSpeechSpinner.setAdapter(adapter);

        partOfSpeechSpinner.setOnItemSelectedListener(this);

        addWordButton.setOnClickListener(this);

    }

@Override
    public void onClick(View view){
    if(checkInput()){
        word.setWord(newWordField.getText().toString().toLowerCase().trim());
        word.setDefinition(definitionField.getText().toString());
        word.setPartOfSpeech(partOfSpeechSpinner.getSelectedItem().toString());
        Intent returnWord= new Intent();
        returnWord.putExtra("NewWord",word);
        setResult(Activity.RESULT_OK,returnWord);
        finish();
    }
}


@Override
public void onItemSelected(AdapterView<?>parent,View view,int pos,long id){
    String partOfSpeech=parent.getItemAtPosition(pos).toString();
    word.setPartOfSpeech(partOfSpeech);
}
@Override
public void onNothingSelected(AdapterView<?> parent){
    Toast.makeText(this, "Nothing is Selected", Toast.LENGTH_SHORT).show();
}

private boolean checkInput(){
    if(TextUtils.isEmpty(newWordField.getText())){
        newWordField.setError("Please enter a word");
    }
    if(TextUtils.isEmpty(definitionField.getText())){
        definitionField.setError("Please enter the definition");
    }
    if(partOfSpeechSpinner.getSelectedItemPosition()==0){
        Toast.makeText(this, "Please select a part of speech", Toast.LENGTH_SHORT).show();
    }
if(newWordField.getError()!=null || definitionField.getError()!=null || partOfSpeechSpinner.getSelectedItemPosition()==0){
    return false;
}
return true;
}
}