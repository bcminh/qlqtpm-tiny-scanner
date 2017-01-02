package com.hcmus.tinyscanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by XuanThai_VaiO on 1/1/2017.
 */

public class listAdapter extends BaseAdapter {

    Context myContext;
    int myLayout;
    List<document> ArrayDoc;

    public listAdapter(Context myContext, int myLayout, List<document> arrayDoc) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        ArrayDoc = arrayDoc;
    }

    @Override
    public int getCount() {
        return ArrayDoc.size();
    }

    @Override
    public Object getItem(int i) {
        return ArrayDoc.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder
    {
        TextView txtMoTa;
        ImageView imgHinh;
        CheckBox checkBox;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = view;
        if(rowView == null)
        {
            rowView = inflater.inflate(myLayout, viewGroup, false);//lay layout
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtMoTa = (TextView) rowView.findViewById(R.id.txt_title);

            viewHolder.checkBox = (CheckBox) rowView.findViewById(R.id.check_Hinh);
            viewHolder.imgHinh = (ImageView)rowView.findViewById(R.id.imageHinh);

            rowView.setTag(viewHolder);// giu anh xa
        }


        //anh xa + gan gia tri

        ViewHolder holder =  (ViewHolder) rowView.getTag();

        holder.checkBox.setChecked(ArrayDoc.get(i).getCheck());

        holder.txtMoTa.setText("Mo Ta: "+ ArrayDoc.get(i).getMoTa());


        holder.imgHinh.setImageResource(ArrayDoc.get(i).getHinhAnh());
        Animation animation = AnimationUtils.loadAnimation(myContext,R.anim.anim_listview_rotate);
        rowView.startAnimation(animation );
        return rowView;
    }
}
