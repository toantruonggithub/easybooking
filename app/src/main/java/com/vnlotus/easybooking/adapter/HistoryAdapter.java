package com.vnlotus.easybooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vnlotus.easybooking.utils.CommonUtils;
import com.vnlotus.easybooking.R;
import com.vnlotus.easybooking.adapter.viewholder.HistoryViewHolder;
import com.vnlotus.easybooking.objects.History;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.ButterKnife;

public class HistoryAdapter extends BaseAdapter {

  private List<History> products;
  private Context context;
  private LayoutInflater inflater;

  public HistoryAdapter(Context context, List<History> products) {
    this.context = context;
    this.products = products;
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return products.size();
  }

  @Override
  public Object getItem(int position) {
    return products.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    HistoryViewHolder holder;
    History history = (History) getItem(position);
    if (convertView == null) {
        convertView = inflater.inflate(R.layout.history_item, parent, false);
      holder = new HistoryViewHolder();
      ButterKnife.bind(holder, convertView);
      convertView.setTag(holder);
    }
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    if (history != null) {
        holder = (HistoryViewHolder) convertView.getTag();
        holder.tvStore.setText(history.getStoreName());
        holder.tvTime.setText(df.format(history.getDate()));
        holder.tvTotal.setText(CommonUtils.getDotNumberStyle(history.getTotal()));
    }
    return convertView;
  }
}
