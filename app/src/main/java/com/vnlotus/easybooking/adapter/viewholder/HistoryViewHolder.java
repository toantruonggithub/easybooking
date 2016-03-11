package com.vnlotus.easybooking.adapter.viewholder;

import android.widget.TextView;

import com.vnlotus.easybooking.R;

import butterknife.Bind;

public class HistoryViewHolder {
  @Bind(R.id.history_store)
  public TextView tvStore;

  @Bind(R.id.history_total)
  public TextView tvTotal;

  @Bind(R.id.history_time)
  public TextView tvTime;
}
