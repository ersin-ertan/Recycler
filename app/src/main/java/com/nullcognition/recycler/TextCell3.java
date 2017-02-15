package com.nullcognition.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleViewHolder;
import com.jaychang.srv.Updatable;

/**
 * Created by mms on 2/15/17.
 */

class TextCell3 extends SimpleCell<Text3, TextCell3.ViewHolder> implements Updatable<Text3> {

  public TextCell3(Text3 item) {
    super(item);
  }

  @Override protected int getLayoutRes() {
    return R.layout.linear;
  }

  @NonNull @Override protected ViewHolder onCreateViewHolder(ViewGroup viewGroup, View view) {
    return new ViewHolder(view);
  }

  @Override protected long getItemId() {
    return getItem().id;
  }

  @Override
  protected void onBindViewHolder(TextCell3.ViewHolder simpleViewHolder, int pos, Context context,
      Object payload) {

    LinearLayout linear = simpleViewHolder.linear;
    String[] array = getItem().array;
    if (payload != null && payload instanceof Text3) {
      array = ((Text3) payload).array;
      linear.removeAllViews();
    }
    for (int j = 0; j < array.length; j++) {
      TextView tv = new TextView(context);
      tv.setText(array[j]);
      linear.addView(tv);
    }
    switch (getItem().id) {
      case 0:
        linear.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        break;
      case 1:
        linear.setBackgroundColor(
            ContextCompat.getColor(context, android.R.color.holo_orange_light));
        break;
      case 2:
        linear.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
        break;
    }
  }

  @Override public boolean areContentsTheSame(Text3 text3) {
    return getItem().array.equals(text3.array);
  }

  @Override public Object getChangePayload(Text3 text3) {
    return text3;
  }

  static class ViewHolder extends SimpleViewHolder {

    public LinearLayout linear;

    ViewHolder(View itemView) {
      super(itemView);
      linear = (LinearLayout) itemView.findViewById(R.id.linear);
    }
  }
}

class Text3 {
  public String[] array;
  int id;

  Text3(int i, String... strings) {
    array = strings;
    id = i;
  }
}