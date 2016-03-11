package com.vnlotus.easybooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.vnlotus.easybooking.R;
import com.vnlotus.easybooking.adapter.viewholder.ProductViewHolder;
import com.vnlotus.easybooking.objects.Product;

import java.util.List;

import butterknife.ButterKnife;

public class GridProductAdapter extends BaseAdapter {

  private List<Product> products;
  private Context context;
  private LayoutInflater inflater;

  public GridProductAdapter(Context context, List<Product> products) {
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
    ProductViewHolder holder;
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.product_item, parent, false);
      holder = new ProductViewHolder();
      ButterKnife.bind(holder, convertView);
      convertView.setTag(holder);
    }
    Product product = (Product) getItem(position);
    if (product != null) {
      holder = (ProductViewHolder) convertView.getTag();
      Glide.with(context).load(product.getThumbUrl())
          .placeholder(R.drawable.ic_lightbulb)
          .into(holder.ivThumb);
      holder.tvName.setText(product.getName());
      holder.tvPrice.setText(product.getPrice() + "");
    }
    return convertView;
  }
}
