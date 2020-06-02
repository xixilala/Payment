package com.autoai.firstdevelopmet.payment.functionmodels.gasolinepayment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.autoai.firstdevelopmet.payment.R;

import java.util.List;

public class SmartPopSelectAdapter extends RecyclerView.Adapter<SmartPopSelectAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDates;

    public SmartPopSelectAdapter(Context context) {
        mContext = context;
    }

    public void setDates(List<String> dates) {
        mDates = dates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_smart_pop_select, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDates == null ? 0 : mDates.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvSmartPopSelectValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSmartPopSelectValue = itemView.findViewById(R.id.tv_smart_pop_select_value);
        }
    }
}
