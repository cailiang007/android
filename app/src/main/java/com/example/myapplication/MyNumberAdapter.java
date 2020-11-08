package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.IdentityHashMap;
import java.util.List;

public class MyNumberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<User> datas;

    public MyNumberAdapter(Context context, List<User> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==1){
            View view = LayoutInflater.from(context).inflate(R.layout.item,null);
            NumberHander numberHander = new NumberHander(view);
            return numberHander;
        }else if(viewType==2){
            View view = LayoutInflater.from(context).inflate(R.layout.item_one,null);
            NumberHanderOne numberHanderOne = new NumberHanderOne(view);
            return numberHanderOne;
        }else if(viewType==3){
            View view = LayoutInflater.from(context).inflate(R.layout.item_two,null);
            NumberHanderTwo numberHanderTwo = new NumberHanderTwo(view);
            return numberHanderTwo;
        }else if(viewType==4){
            View view = LayoutInflater.from(context).inflate(R.layout.item_three,null);
            NumberHanderThree numberHanderThree = new NumberHanderThree(view);
            return numberHanderThree;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_four,null);
            NumberHanderFour numberHanderFour = new NumberHanderFour(view);
            return numberHanderFour;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 1;
        }else if(position==1){
            return 2;
        }else if(position==2){
            return 3;
        }else if(position==3){
            return 4;
        }else {
            return 5;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position == 0){
            NumberHander holder1 = (NumberHander) holder;
            holder1.recyNumberName.setText(String.valueOf(datas.get(position).getName()));
        }else if(position == 1){
            NumberHanderOne holder1 = (NumberHanderOne) holder;
            holder1.recyNumberNameOne.setImageResource(R.mipmap.ic_launcher);
        }else if(position==2){
            NumberHanderTwo holder1 = (NumberHanderTwo) holder;
            holder1.recyNumberNameTwo.setImageResource(R.mipmap.ic_launcher_round);
        }else if(position==3){
            NumberHanderThree holder1 = (NumberHanderThree) holder;
            holder1.recyNumberNameThree.setText("three");
        }else {
            NumberHanderFour holder1 = (NumberHanderFour) holder;
            holder1.recyNumberNameFour.setImageResource(R.mipmap.ic_launcher_round);
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class NumberHander extends RecyclerView.ViewHolder{
        private TextView recyNumberName;
        public NumberHander(@NonNull View itemView) {
            super(itemView);
            recyNumberName = itemView.findViewById(R.id.recyNumberName);
        }
    }

    class NumberHanderOne extends RecyclerView.ViewHolder{
        private ImageView recyNumberNameOne;
        public NumberHanderOne(@NonNull View itemView) {
            super(itemView);
            recyNumberNameOne = itemView.findViewById(R.id.iv_one);
        }
    }

    class NumberHanderTwo extends RecyclerView.ViewHolder{
        private ImageView recyNumberNameTwo;
        public NumberHanderTwo(@NonNull View itemView) {
            super(itemView);
            recyNumberNameTwo = itemView.findViewById(R.id.iv_two);
        }
    }

    class NumberHanderThree extends RecyclerView.ViewHolder{
        private TextView recyNumberNameThree;
        public NumberHanderThree(@NonNull View itemView) {
            super(itemView);
            recyNumberNameThree = itemView.findViewById(R.id.iv_three);
        }
    }

    class NumberHanderFour extends RecyclerView.ViewHolder{
        private ImageView recyNumberNameFour;
        public NumberHanderFour(@NonNull View itemView) {
            super(itemView);
            recyNumberNameFour = itemView.findViewById(R.id.iv_four);
        }
    }

}
