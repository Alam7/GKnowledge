package com.example.hp_.udacitysunshine;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP_$$) on 02-Feb-16.
 */
public class CustomAdapter extends ArrayAdapter {

    List<ScoreBoard> scoreBoardArrayList;
    //List list = new ArrayList();
    public CustomAdapter(Context context, int resource,List<ScoreBoard> arrayList) {
        super(context, resource);

        this.scoreBoardArrayList = arrayList;
    }

//    public void add(ScoreBoard modelClass) {
//        super.add(modelClass);
//        list.add(modelClass);
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row= convertView;
        ViewHolder holder;

        if (row==null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row,parent,false);
            holder = new ViewHolder();

            holder.txName = (TextView) row.findViewById(R.id.txtName);
            holder.txtScore = (TextView) row.findViewById(R.id.txtScore);
            holder.txtTime = (TextView) row.findViewById(R.id.txtTime);

            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();

        }

        ScoreBoard modelClass = (ScoreBoard) this.getItem(position);

        holder.txName.setText(modelClass.getPlayerName());
        holder.txtScore.setText(modelClass.getScore());
        holder.txtTime.setText(modelClass.getTimeTook());

        ScoreBoard scoreBoard = scoreBoardArrayList.get(position);
        return row;
    }

    static class ViewHolder{
        TextView txName;
        TextView txtScore;
        TextView txtTime;
    }
}

