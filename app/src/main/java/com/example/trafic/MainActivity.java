package com.example.trafic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trafic.adapter.QuestionAdapter;
import com.example.trafic.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvQuestion;
    QuestionAdapter questionAdapter;
    List<QuestionModel> list;
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        getData();

        rcvQuestion.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL,false));
        rcvQuestion.setHasFixedSize(true);
        questionAdapter = new QuestionAdapter(MainActivity.this, list);
        rcvQuestion.setAdapter(questionAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(1);
            }
        });

        tvCount.setText("Question" + list.size());
    }

    private void getData() {
        list = new ArrayList<>();
        list.add(new QuestionModel("Cau 1"));
        list.add(new QuestionModel("Cau 2"));
        list.add(new QuestionModel("Cau 3"));
        list.add(new QuestionModel("Cau 4"));
    }

    private void initUi() {
        rcvQuestion = findViewById(R.id.rcv_question);
        btnPrevious = findViewById(R.id.btn_previous);
        btnNext = findViewById(R.id.btn_next);
        tvCount = findViewById(R.id.tv_count);
    }
}