package com.autoai.payment.functionmodels.gasolinepayment.view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.autoai.payment.R;
import com.autoai.payment.base.BaseMvpFragment;
import com.autoai.payment.functionmodels.gasolinepayment.adapter.SmartAddGasStationListAdapter;
import com.autoai.payment.functionmodels.gasolinepayment.adapter.SmartPopSelectAdapter;
import com.autoai.payment.functionmodels.gasolinepayment.contract.SmartAddGosolineContract;
import com.autoai.payment.functionmodels.gasolinepayment.presenter.SmartAddGasolinePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SmartAddGasolineFragment extends BaseMvpFragment<SmartAddGasolinePresenter> implements SmartAddGosolineContract.View {

    @BindView(R.id.tv_gas_num)
    TextView tvGasNum;
    @BindView(R.id.tv_gas_branch)
    TextView tvGasBranch;
    @BindView(R.id.tv_gas_nearest)
    TextView tvGasNearest;
    @BindView(R.id.tv_gas_cheapest)
    TextView tvGasCheapest;
    @BindView(R.id.rv_gasStation_list)
    RecyclerView rvGasStationList;
    @BindView(R.id.view_smart_select_line)
    View viewSmartSelectLine;
    PopupWindow mSmartSelectPop;
    SmartPopSelectAdapter mSmartPopSelectAdapter;
    RecyclerView mSmartPopSelectRv;

    public static SmartAddGasolineFragment newInstance(String s) {
        SmartAddGasolineFragment fragment = new SmartAddGasolineFragment();
        Bundle args = new Bundle();
        args.putString("testS", s);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            String s = args.getString("testS");
            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvGasStationList.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_smart_add_gasoline;
    }

    @Override
    protected void lazyLoad() {
        SmartAddGasStationListAdapter adapter = new SmartAddGasStationListAdapter(getActivity());
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            dates.add("" + i);
        }
        adapter.setDates(dates);
        rvGasStationList.setAdapter(adapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @OnClick({R.id.tv_gas_num, R.id.tv_gas_branch, R.id.tv_gas_nearest, R.id.tv_gas_cheapest})
    public void onViewClicked(View view) {
        setSelectedTextColor(view.getId());
        switch (view.getId()) {
            case R.id.tv_gas_num:
                List<String> dates = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    dates.add("" + i);
                }
                showPopupWindow(dates);
                break;
            case R.id.tv_gas_branch:
                break;
            case R.id.tv_gas_nearest:
                break;
            case R.id.tv_gas_cheapest:
                break;
        }
    }

    private void setSelectedTextColor(int id){
        switch (id){
            case R.id.tv_gas_num:
                tvGasNum.setTextColor(getActivity().getColor(R.color.FF4281FF));
                tvGasBranch.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasNearest.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasCheapest.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                break;
            case R.id.tv_gas_branch:
                tvGasNum.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasBranch.setTextColor(getActivity().getColor(R.color.FF4281FF));
                tvGasNearest.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasCheapest.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                break;
            case R.id.tv_gas_nearest:
                tvGasNum.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasBranch.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasNearest.setTextColor(getActivity().getColor(R.color.FF4281FF));
                tvGasCheapest.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                break;
            case R.id.tv_gas_cheapest:
                tvGasNum.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasBranch.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasNearest.setTextColor(getActivity().getColor(R.color.ffc8c8c8));
                tvGasCheapest.setTextColor(getActivity().getColor(R.color.FF4281FF));
                break;
        }
    }

    private void showPopupWindow(List<String> dates){
        if (mSmartSelectPop == null){
            View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pop_select, null);
            mSmartPopSelectRv = contentView.findViewById(R.id.rv_smart_pop_select);
            mSmartSelectPop = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            mSmartPopSelectAdapter = new SmartPopSelectAdapter(getActivity());
            mSmartPopSelectRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mSmartPopSelectAdapter.setDates(dates);
        mSmartPopSelectRv.setAdapter(mSmartPopSelectAdapter);
//        mSmartSelectPop.showAsDropDown(viewSmartSelectLine);
        mSmartSelectPop.showAtLocation(rvGasStationList,Gravity.CENTER,0,0);
    }
}
