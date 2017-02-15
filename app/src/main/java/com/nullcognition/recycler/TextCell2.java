package com.nullcognition.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;

/**
 * Created by mms on 2/15/17.
 */

class TextCell2 extends SimpleCell<Text2, TextCell2.ViewHolder> {

  public TextCell2(Text2 item) {
    super(item);
  }

  @Override protected int getLayoutRes() {
    return android.R.layout.simple_list_item_1;
  }

  @NonNull @Override protected ViewHolder onCreateViewHolder(ViewGroup viewGroup, View view) {
    return new ViewHolder(view);
  }

  @Override protected long getItemId() {return 0;}

  @Override
  protected void onBindViewHolder(TextCell2.ViewHolder simpleViewHolder, int i, Context context,
      Object o) {
    TextView tv = simpleViewHolder.textView;
    String text = getItem().text;
    if (tv != null && text != null) tv.setText(text);
  }

  static class ViewHolder extends SimpleViewHolder {

    public TextView textView;

    ViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }
}

class Text2 {
  public String text;

  Text2(String t) {
    text = t;
  }
}