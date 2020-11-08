package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class RecyNumberAdapter extends RecyclerView.Adapter<RecyNumberAdapter.NumberHander>{
    private Context context;
    private List<User> mDatas;
    public RecyNumberAdapter(Context context,List<User> mDatas){
        this.context=context;
        this.mDatas=mDatas;
    }
    @NonNull
    @Override
    public NumberHander onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,null);
        return new NumberHander(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberHander holder, int position) {
        holder.recyNumberName.setText(String.valueOf(mDatas.get(position).getName()));
        holder.itemTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"dianji",Toast.LENGTH_SHORT).show();
            }
        });
        //holder.recyNumberPhone.setText(String.valueOf(mDatas.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class NumberHander extends RecyclerView.ViewHolder{
        private ImageView recyNumberPhone;
        private TextView recyNumberName;
        private LinearLayout itemTest;

        public NumberHander(@NonNull View itemView) {
            super(itemView);
            itemTest = itemView.findViewById(R.id.item_test);
            recyNumberPhone = itemView.findViewById(R.id.recyNumberPhone);
            recyNumberName = itemView.findViewById(R.id.recyNumberName);
        }
    }
}
