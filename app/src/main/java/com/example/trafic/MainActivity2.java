package com.example.trafic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trafic.adapter.QuestionAdapter;
import com.example.trafic.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<QuestionModel> list;
    QuestionAdapter questionAdapter;
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvCount;
    private ImageView imgChange;
    private ImageView imgChanged;

    boolean barIsShowing = true;

    public void fade(View view){
        Log.i("Info","selected");
        ImageView view1 = findViewById(R.id.img_change);
        ImageView view2 = findViewById(R.id.img_changed);
        if (barIsShowing){
            barIsShowing = false;
            view1.animate().alpha(0).setDuration(500);
            view2.animate().alpha(1).setDuration(500);
        }else{
            barIsShowing = true;
            view1.animate().alpha(1).setDuration(500);
            view2.animate().alpha(0).setDuration(500);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getData();
        initUi();

        mRecyclerView = findViewById(R.id.rcv_question);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        questionAdapter = new QuestionAdapter(MainActivity2.this, list);
        mRecyclerView.setAdapter(questionAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    int position = getCurrentItem();
//                    tvCount.setText("Question " + (position+1) + " / " + list.size());
//                }
                int position = getCurrentItem();
                tvCount.setText("Question " + (position+1) + " / " + list.size());
            }
        });
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview();
            }
        });
    }

    private void initUi() {
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        tvCount = findViewById(R.id.tv_count);
        imgChange = findViewById(R.id.img_change);
    }


    public boolean hasPreview() {
        return getCurrentItem() > 0;
    }

    public boolean hasNext() {
        return mRecyclerView.getAdapter() != null &&
                getCurrentItem() < (mRecyclerView.getAdapter().getItemCount() - 1);
    }

    public void preview() {
        int position = getCurrentItem();
        if (position > 0)
            setCurrentItem(position - 1, true);
    }

    public void next() {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        if (adapter == null)
            return;

        int position = getCurrentItem();
        int count = adapter.getItemCount();
        if (position < (count - 1))
            setCurrentItem(position + 1, true);
    }

    private int getCurrentItem() {
        return ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                .findFirstVisibleItemPosition();
    }

    private void setCurrentItem(int position, boolean smooth) {
        if (smooth)
            mRecyclerView.smoothScrollToPosition(position);
        else
            mRecyclerView.scrollToPosition(position);
    }

    private void getData() {
        list = new ArrayList<>();
        list.add(new QuestionModel("Cau 1"));
        list.add(new QuestionModel("Cau 2"));
        list.add(new QuestionModel("Cau 3"));
        list.add(new QuestionModel("Cau 4"));
        list.add(new QuestionModel("Cau 5"));
        list.add(new QuestionModel("Cau 6"));
        list.add(new QuestionModel("Cau 7"));
        list.add(new QuestionModel("Cau 8"));
    }


}