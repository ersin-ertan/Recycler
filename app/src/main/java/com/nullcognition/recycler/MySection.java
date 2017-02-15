package com.nullcognition.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mms on 2/15/17.
 */

class MySection extends StatelessSection {

  public ArrayList<String> myList = new ArrayList<>(Arrays.asList("Item1", "Item2", "Item3"));
  ;

  public MySection() {
    // call constructor with layout resources for this Section header and items
    super(android.R.layout.simple_list_item_1, android.R.layout.simple_list_item_2);
  }

  @Override public int getContentItemsTotal() {
    return myList.size(); // number of items of this section
  }

  @Override public RecyclerView.ViewHolder getItemViewHolder(View view) {

    return new MyItemViewHolder(view);
  }

  @Override public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
    MyItemViewHolder itemHolder = (MyItemViewHolder) holder;

    // bind your view here
    itemHolder.textView.setText(myList.get(position));
  }

  class MyItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public MyItemViewHolder(View itemView) {
      super(itemView);

      textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }
}