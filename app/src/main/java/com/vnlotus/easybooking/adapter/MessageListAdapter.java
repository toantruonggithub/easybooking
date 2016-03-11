package com.vnlotus.easybooking.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vnlotus.easybooking.R;
import com.vnlotus.easybooking.objects.Message;

import java.util.List;

public class MessageListAdapter extends BaseAdapter {

  private Context context;
  private List<Message> messagesItems;
  private LayoutInflater mInflater;

  public MessageListAdapter(Context context, List<Message> navDrawerItems) {
    this.context = context;
    this.messagesItems = navDrawerItems;
    this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return messagesItems.size();
  }

  @Override
  public Object getItem(int position) {
    return messagesItems.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    /**
     * The following list not implemented reusable list items as list items
     * are showing incorrect data Add the solution if you have one
     * */

    Message m = messagesItems.get(position);

    if (messagesItems.get(position).isSelf()) {
      convertView = mInflater.inflate(R.layout.item_msg_right,
          null);
    } else {
      convertView = mInflater.inflate(R.layout.item_msg_left,
          null);
    }

    TextView lblFrom = (TextView) convertView.findViewById(R.id.lblMsgFrom);
    TextView txtMsg = (TextView) convertView.findViewById(R.id.txtMsg);

    txtMsg.setText(m.getMessage());
    lblFrom.setText(m.getFromName());

    return convertView;
  }
}