package com.vnlotus.easybooking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vnlotus.easybooking.R;
import com.vnlotus.easybooking.adapter.HistoryAdapter;
import com.vnlotus.easybooking.objects.History;
import com.vnlotus.easybooking.objects.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import butterknife.Bind;

public class FragmentB extends BaseFragment {

    @Bind(R.id.list_history) protected ListView listViewHistory;

    private HistoryAdapter historyAdapter;

    public FragmentB() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Random random = new Random();
        List<History> histories = new ArrayList<>();
        historyAdapter = new HistoryAdapter(getActivity(), histories);
        listViewHistory.setAdapter(historyAdapter);

        histories.add(new History("Store X", 1000000, Calendar.getInstance().getTime(), false));
        for (int i = 0; i < 50; i++) {
            histories.add(new History("Store " + i, random.nextInt(1000) * 1000, Calendar.getInstance().getTime(), true));
        }

        historyAdapter.notifyDataSetChanged();
    }
}