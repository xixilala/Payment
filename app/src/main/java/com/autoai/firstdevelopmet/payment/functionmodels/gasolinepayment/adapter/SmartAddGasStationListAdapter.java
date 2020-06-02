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

public class SmartAddGasStationListAdapter extends RecyclerView.Adapter<SmartAddGasStationListAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDates;

    public SmartAddGasStationListAdapter(Context context) {
        mContext = context;
    }

    public void setDates(List<String> dates) {
        mDates = dates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_smart_add_gas_station, parent, false);
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

        TextView tvSmartListName;
        TextView tvSmartListLocation;
        TextView tvSmartListPrice;
        TextView tvSmartListBasePrice;
        TextView tvSmartListBranch;
        TextView tvSmartListTicketStyle;
        TextView tvSmartListDistance;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSmartListName = itemView.findViewById(R.id.tv_smart_list_name);
            tvSmartListLocation = itemView.findViewById(R.id.tv_smart_list_location);
            tvSmartListPrice = itemView.findViewById(R.id.tv_smart_list_price);
            tvSmartListBasePrice = itemView.findViewById(R.id.tv_smart_list_base_price);
            tvSmartListBranch = itemView.findViewById(R.id.tv_smart_list_branch);
            tvSmartListTicketStyle = itemView.findViewById(R.id.tv_smart_list_ticket_style);
            tvSmartListDistance = itemView.findViewById(R.id.tv_smart_list_distance);
        }
    }
}
