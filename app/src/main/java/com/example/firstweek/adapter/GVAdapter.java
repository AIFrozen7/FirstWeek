package com.example.firstweek.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.firstweek.R;
import com.example.firstweek.bean.JsonBean;

import java.util.List;

/**
 * @Auther: 李
 * @Date: 2019/1/28 08:54:14
 * @Description:
 */
public class GVAdapter extends BaseAdapter {
    private List<JsonBean.DataBean> list;
    private Context context;

    public GVAdapter(List<JsonBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item,null);
            holder.item_text = convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.item_text.setText(list.get(position).getNews_title());
        return convertView;
    }
    class ViewHolder{
        private TextView item_text;
    }
}
