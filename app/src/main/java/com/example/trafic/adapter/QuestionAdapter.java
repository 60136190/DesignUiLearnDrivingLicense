package com.example.trafic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafic.R;
import com.example.trafic.model.QuestionModel;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    List<QuestionModel> questionModel;

    public QuestionAdapter(Context context, List<QuestionModel> questionModel) {
        this.context = context;
        this.questionModel = questionModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_questions,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        QuestionModel model = questionModel.get(position);
        ((ItemViewHolder)holder).itemTitle.setText(model.getTitle());

    }

    @Override
    public int getItemCount() {
        if (questionModel != null){
            return questionModel.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView itemTitle;


        public ItemViewHolder(@NonNull View itemView) {

            super(itemView);
            itemTitle = itemView.findViewById(R.id.tv_title);

        }
    }
}
