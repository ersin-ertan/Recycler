package com.nullcognition.recycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jaychang.srv.SimpleRecyclerView;
import com.jaychang.srv.behavior.SwipeToDismissCallback;
import com.jaychang.srv.decoration.SectionHeaderProvider;
import com.jaychang.srv.decoration.SectionHeaderProviderAdapter;

import static com.jaychang.srv.behavior.SwipeDirection.LEFT;
import static com.jaychang.srv.behavior.SwipeDirection.RIGHT;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final SimpleRecyclerView recyclerView;

    Button button = (Button) findViewById(R.id.button);
    recyclerView = (SimpleRecyclerView) findViewById(R.id.recyclerView);

    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        int i;
        i = -1;

        int adapterPosition =
            recyclerView.getChildAdapterPosition(recyclerView.findViewById(i + 1));
        int childLayoutPosition =
            recyclerView.getChildLayoutPosition(recyclerView.findViewById(i + 1));

        recyclerView.addCell(adapterPosition + 1, new TextCell(new Text(String.valueOf(i),
            i < 10 ? 0 : i < 20 ? 1 : i < 30 ? 2 : i < 40 ? 3 : i < 50 ? 4 : 5)));

        //i = 59;
        //adapterPosition = recyclerView.getChildAdapterPosition(recyclerView.findViewById(56));
        //childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.findViewById(56));
        //
        //recyclerView.addCell(adapterPosition + 1, new TextCell(new Text(String.valueOf(i),
        //    i < 10 ? 0 : i < 20 ? 1 : i < 30 ? 2 : i < 40 ? 3 : i < 50 ? 4 : 5)));
      }
    });

    SectionHeaderProvider<Text> sectionHeaderProvider = new SectionHeaderProviderAdapter<Text>() {
      // Your section header view here
      @NonNull @Override public View getSectionHeaderView(Text item, int position) {
        View view = LayoutInflater.from(MainActivity.this)
            .inflate(android.R.layout.simple_list_item_2, null, false);
        view.setBackgroundColor(
            ContextCompat.getColor(MainActivity.this, android.R.color.holo_orange_light));
        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        //textView.setTextColor(
        //    ContextCompat.getColor(MainActivity.this, android.R.color.holo_orange_light));
        switch (item.section) {
          case 0: {
            textView.setText("Ones");
            break;
          }
          case 1: {
            textView.setText("Tens");
            break;
          }
          case 2: {
            textView.setText("Twenties");
            break;
          }
          case 3: {
            textView.setText("Thirties");
            break;
          }
          case 4: {
            textView.setText("Fourties");
            break;
          }
          case 5: {
            textView.setText("Fifties");
            break;
          }
        }

        return view;
      }

      // Your grouping logic here
      @Override public boolean isSameSection(Text item, Text nextItem) {
        return item.section == nextItem.section;
      }

      @Override public boolean isSticky() {
        return true;
      }
    };

    recyclerView.setSectionHeader(sectionHeaderProvider);
    recyclerView.postInvalidate();

    for (int i = 0; i < 56; i++) {
      recyclerView.addCell(new TextCell(new Text(String.valueOf(i),
          i < 10 ? 0 : i < 20 ? 1 : i < 30 ? 2 : i < 40 ? 3 : i < 50 ? 4 : 5)));
    }

    SwipeToDismissCallback<Text> swipeToDismissCallback = new SwipeToDismissCallback<Text>() {
      // Optional, return false if you manipulate custom swipe effect in the rest of callbacks.

      //@Override public boolean enableDefaultFadeOutEffect() {
      //  // default return true
      //  return super.enableDefaultFadeOutEffect();
      //}

      //// Optional
      //@Override public void onCellSwiping(SimpleRecyclerView simpleRecyclerView, View itemView,
      //    Text item, int position, Canvas canvas, float dX, float dY, boolean isControlledByUser) {
      //  resultView.setText("Item " + item + " is swiping.");
      //}
      //
      //// Optional
      //@Override public void onCellSettled(SimpleRecyclerView simpleRecyclerView, View itemView,
      //    Text item, int position) {
      //  resultView.setText("Item " + item + " is settled.");
      //}
      //
      //// Optional
      //@Override public void onCellDismissed(SimpleRecyclerView simpleRecyclerView, Text item,
      //    int position) {
      //  resultView.setText("Item: " + item + " is dismissed.");
      //}
    };

    // enable swipe left or right to dismiss
    recyclerView.enableSwipeToDismiss(swipeToDismissCallback, LEFT, RIGHT);
  }

  class Text {
    public String text;
    public int section;

    Text(String t, int s) {
      text = t;
      section = s;
    }
  }

  class Text2 {
    public String text;

    Text2(String t) {
      text = t;
    }
  }

  class Text3 {
    public String text;

    Text3(String t) {
      text = t;
    }
  }
}