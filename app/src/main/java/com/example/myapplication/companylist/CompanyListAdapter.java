package com.example.myapplication.companylist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CompanyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Company> datas;
    private OnCompanyItemClickListener onCompanyItemClickListener;

    public CompanyListAdapter(Context context, List<Company> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.company_item,null);
        HolderOne holderOne = new HolderOne(view);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderOne holderOne = (HolderOne)holder;
        holderOne.tvCreateTime.setText(datas.get(position).getCreateTime());
        holderOne.tvMerchantsYear.setText(datas.get(position).getMerchantsYear());
        if (!TextUtils.isEmpty(datas.get(position).getCompanyName())){
            holderOne.tvCompanyName.setText(datas.get(position).getCompanyName());
        }else {
            holderOne.tvCompanyName.setText("");
        }
        holderOne.rlCompanyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCompanyItemClickListener!=null){
                    onCompanyItemClickListener.onCompanyItemClick(position);
                }
            }
        });
    }

    public void setOnCompanyItemClickListener(OnCompanyItemClickListener onCompanyItemClickListener){
        this.onCompanyItemClickListener=onCompanyItemClickListener;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class HolderOne extends RecyclerView.ViewHolder{
        private TextView tvCompanyName;
        private TextView tvCreateTime;
        private TextView tvMerchantsYear;
        private RelativeLayout rlCompanyItem;
        public HolderOne(@NonNull View itemView) {
            super(itemView);
            tvCompanyName = itemView.findViewById(R.id.tv_company_name);
            tvCreateTime = itemView.findViewById(R.id.tv_create_time);
            tvMerchantsYear = itemView.findViewById(R.id.tv_merchants_year);
            rlCompanyItem = itemView.findViewById(R.id.rl_company_item);
        }
    }
}
