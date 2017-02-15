package com.nullcognition.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.jaychang.srv.SimpleRecyclerView;
import com.jaychang.srv.behavior.SwipeToDismissCallback;

import static com.jaychang.srv.behavior.SwipeDirection.LEFT;
import static com.jaychang.srv.behavior.SwipeDirection.RIGHT;

public class MainActivity extends AppCompatActivity {
  int i = -1;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final SimpleRecyclerView recyclerView;

    Button button = (Button) findViewById(R.id.button);
    recyclerView = (SimpleRecyclerView) findViewById(R.id.recyclerView);

    // Set up your RecyclerView with the SectionedRecyclerViewAdapter
    //recyclerView.setLayoutManager(new LinearLayoutManager(this));

    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        i++;

        //int adapterPosition =
        //    recyclerView.getChildAdapterPosition(recyclerView.findViewById(i + 1));
        //int childLayoutPosition =
        //    recyclerView.getChildLayoutPosition(recyclerView.findViewById(i + 1));

        //recyclerView.addCell(0, new TextCell(new Text(String.valueOf(i),
        //    i < 10 ? 0 : i < 20 ? 1 : i < 30 ? 2 : i < 40 ? 3 : i < 50 ? 4 : 5)));
        recyclerView.addCell(new TextCell3(new Text3(0, "a", "b", "c")));
        recyclerView.addCell(new TextCell3(new Text3(1, "d", "e", "f")));
        recyclerView.addCell(new TextCell3(new Text3(2, "g", "h", "i")));
      }
    });

    Button button2 = (Button) findViewById(R.id.button2);

    button2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //recyclerView.removeCell(3);
        TextCell3.ViewHolder vh = (TextCell3.ViewHolder) recyclerView.findViewHolderForItemId(
            2); // item id will be the section id
        int adapterPosition = vh.getAdapterPosition();
        recyclerView.updateCell(adapterPosition, new Text3(2, "new", "changes", "made"));
      }
    });

    //sectionHeaders();

    //SectionHeaderProvider<Text> sectionHeaderProvider2 = new SectionHeaderProviderAdapter<Text>() {
    //  // Your section header view here
    //  @NonNull @Override public View getSectionHeaderView(Text item, int position) {
    //    View view = LayoutInflater.from(MainActivity.this)
    //        .inflate(android.R.layout.simple_list_item_2, null, false);
    //    view.setBackgroundColor(
    //        ContextCompat.getColor(MainActivity.this, android.R.color.holo_orange_light));
    //    TextView textView = (TextView) view.findViewById(android.R.id.text1);
    //    textView.setText(String.valueOf(item.section));
    //    return view;
    //  }
    //
    //  // Your grouping logic here
    //  @Override public boolean isSameSection(Text item, Text nextItem) {
    //    return item.section == nextItem.section;
    //  }
    //};

    //recyclerView.addCell(0, new TextCell2(new Text2("Text1")));
    //recyclerView.addCell(0, new TextCell2(new Text2("Text2")));
    //recyclerView.addCell(0, new TextCell2(new Text2("Text3")));
    //recyclerView.addCell(0, new TextCell2(new Text2("Text4")));
    //recyclerView.addCell(0, new TextCell2(new Text2("Text5")));
    //recyclerView.addCell(0, new TextCell2(new Text2("Text6")));

    //recyclerView.setSectionHeader(sectionHeaderProvider2);

    //for (int i = 0; i < 56; i++) {
    //  recyclerView.addCell(new TextCell(new Text(String.valueOf(i),
    //      i < 10 ? 0 : i < 20 ? 1 : i < 30 ? 2 : i < 40 ? 3 : i < 50 ? 4 : 5)));
    //}

    SwipeToDismissCallback<Text> swipeToDismissCallback = new SwipeToDismissCallback<Text>() {
    };

    // enable swipe left or right to dismiss
    recyclerView.enableSwipeToDismiss(swipeToDismissCallback, LEFT, RIGHT);
  }

  private void sectionHeaders() {

    //SectionHeaderProvider<Text> sectionHeaderProvider = new SectionHeaderProviderAdapter<Text>() {
    //  // Your section header view here
    //  @NonNull @Override public View getSectionHeaderView(Text item, int position) {
    //    View view = LayoutInflater.from(MainActivity.this)
    //        .inflate(android.R.layout.simple_list_item_2, null, false);
    //    view.setBackgroundColor(
    //        ContextCompat.getColor(MainActivity.this, android.R.color.holo_orange_light));
    //    TextView textView = (TextView) view.findViewById(android.R.id.text1);
    //    //textView.setTextColor(
    //    //    ContextCompat.getColor(MainActivity.this, android.R.color.holo_orange_light));
    //    switch (item.section) {
    //      case 0: {
    //        textView.setText("Ones");
    //        break;
    //      }
    //      case 1: {
    //        textView.setText("Tens");
    //        break;
    //      }
    //      case 2: {
    //        textView.setText("Twenties");
    //        break;
    //      }
    //      case 3: {
    //        textView.setText("Thirties");
    //        break;
    //      }
    //      case 4: {
    //        textView.setText("Fourties");
    //        break;
    //      }
    //      case 5: {
    //        textView.setText("Fifties");
    //        break;
    //      }
    //    }
    //    return view;
    //  }
    //
    //  // Your grouping logic here
    //  @Override public boolean isSameSection(Text item, Text nextItem) {
    //    return item.section == nextItem.section;
    //  }
    //
    //  @Override public boolean isSticky() {
    //    return false;
    //  }
    //};
  }
}