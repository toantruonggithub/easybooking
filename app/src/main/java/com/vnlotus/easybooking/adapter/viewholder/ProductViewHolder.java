package com.vnlotus.easybooking.adapter.viewholder;

import android.widget.ImageView;
import android.widget.TextView;

import com.vnlotus.easybooking.R;

import butterknife.Bind;

public class ProductViewHolder {

  @Bind(R.id.product_thumb)
  public ImageView ivThumb;

  @Bind(R.id.product_name)
  public TextView tvName;

  @Bind(R.id.product_price)
  public TextView tvPrice;
}
