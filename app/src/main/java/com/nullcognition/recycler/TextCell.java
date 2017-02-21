package com.nullcognition.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;
import com.jaychang.srv.Updatable;

/**
 * Created by mms on 2/14/17.
 */

class TextCell extends SimpleCell<MainActivity.Text, TextCell.ViewHolder>
    implements Updatable<MainActivity.Text> {

  public TextCell(MainActivity.Text item) {
    super(item);
  }

  @Override protected int getLayoutRes() {
    return android.R.layout.simple_list_item_1;
  }

  @NonNull @Override protected ViewHolder onCreateViewHolder(ViewGroup viewGroup, View view) {
    return new ViewHolder(view);
  }

  @Override protected long getItemId() {
    return Integer.parseInt(getItem().text);
  }

  @Override
  protected void onBindViewHolder(TextCell.ViewHolder simpleViewHolder, int i, Context context,
      Object o) {
    if (o != null && o instanceof MainActivity.Text) {
      setItem((MainActivity.Text) o);
    }
    TextView tv = simpleViewHolder.textView;
    String text = getItem().text;
    if (tv != null && text != null) tv.setText(text);
  }

  @Override public boolean areContentsTheSame(MainActivity.Text text) {
    return getItem().text.equals(text.text) && getItem().section == text.section;
  }

  @Override public Object getChangePayload(MainActivity.Text text) {
    return text;
  }

  static class ViewHolder extends SimpleViewHolder {

    public TextView textView;

    ViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(android.R.id.text1);
    }
  }
}