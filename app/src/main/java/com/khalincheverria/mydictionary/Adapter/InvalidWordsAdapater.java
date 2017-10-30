package com.khalincheverria.mydictionary.Adapter;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.khalincheverria.mydictionary.R;

import java.util.ArrayList;

/**
 * Created by Khalin Cheverria 1501396
 * Chrysannae Mason 1503793
 * Lorenzo Buchanan 1504084
 *
 * on 3/14/2017.
 */
public class InvalidWordsAdapater  extends RecyclerView.Adapter<InvalidWordsAdapater.ViewHolder>{
    private ArrayList<String>list;
    private static RecyclerViewClickListener listener;
    int position;



    public int getPosition() {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(TextView textView){
            super(textView);
            this.textView=textView;
        }
    }

    public InvalidWordsAdapater(ArrayList list,RecyclerViewClickListener listener){
        this.list=list;
        this.listener=listener;
    }
@Override
    public InvalidWordsAdapater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

    TextView textView=(TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.invalidwords,parent,false);
    InvalidWordsAdapater.ViewHolder viewHolder=new InvalidWordsAdapater.ViewHolder(textView);
    return  viewHolder;
}
@Override
public void onBindViewHolder(final InvalidWordsAdapater.ViewHolder viewHolder, final int position){
viewHolder.textView.setText(list.get(position));

viewHolder.textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        InvalidWordsAdapater.this.position=position;
        listener.recyclerViewListClicked(v,InvalidWordsAdapater.this.position);
    }
});
}

    @Override
    public int getItemCount(){
    return list.size();
}


}
