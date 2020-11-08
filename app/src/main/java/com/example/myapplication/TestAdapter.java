package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> datas;

    public TestAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 1){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_one,null);
            HolderOne holderOne = new HolderOne(view);
            return holderOne;
        }else if(viewType == 2){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_two,null);
            HolderTwo holderTwo = new HolderTwo(view);
            return holderTwo;
        }else if(viewType == 3){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_three,null);
            HolderThree holderThree = new HolderThree(view);
            return holderThree;
        }else if(viewType == 4){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_four,null);
            HolderFour holderFour = new HolderFour(view);
            return holderFour;
        }else if(viewType == 5){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_five,null);
            HolderFive holderFive = new HolderFive(view);
            return holderFive;
        }else if(viewType == 6){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_six,null);
            HolderSix holderSix = new HolderSix(view);
            return holderSix;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_item_seven,null);
            HolderSeven holderSeven = new HolderSeven(view);
            return holderSeven;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position == 0){
            HolderOne holderOne = (HolderOne)holder;
            holderOne.imageView.setImageResource(R.mipmap.cl);
        }else if(position == 1){
            HolderTwo holderTwo = (HolderTwo)holder;
        }else if(position == 2){
            HolderThree holderThree = (HolderThree)holder;
        }else if(position == 3){
            HolderFour holderFour = (HolderFour) holder;
        }else if(position >=4&&position<7){
            HolderFive holderFive = (HolderFive) holder;
        }else if(position == 7){
            HolderSix holderSix = (HolderSix) holder;
        }else {
            HolderSeven holderSeven = (HolderSeven) holder;
            String url = "http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg";
            Glide.with(context)
                    .load(url)
                    .into(holderSeven.imageView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return 1;
        }else if(position == 1){
            return 2;
        }else if(position==2){
            return 3;
        }else if(position == 3){
            return 4;
        }else if(position >=4&&position<7){
            return 5;
        }else if(position == 7){
            return 6;
        }else {
            return 7;
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public HolderOne(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_one);
        }
    }

    class HolderTwo extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        public HolderTwo(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.llt_two);
        }
    }

    class HolderThree extends RecyclerView.ViewHolder{
        private RelativeLayout relativeLayout;
        public HolderThree(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.rlt_three);
        }
    }

    class HolderFour extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public HolderFour(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_one);
        }
    }

    class HolderFive extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private ImageView imageView1;
        private ImageView imageView2;
        private ImageView imageView3;
        public HolderFive(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_one);
            imageView = itemView.findViewById(R.id.iv_item_one);
            imageView = itemView.findViewById(R.id.iv_item_one);
            imageView = itemView.findViewById(R.id.iv_item_one);
        }
    }

    class HolderSix extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public HolderSix(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_one);
        }
    }

    class HolderSeven extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public HolderSeven(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_one);
        }
    }

}
