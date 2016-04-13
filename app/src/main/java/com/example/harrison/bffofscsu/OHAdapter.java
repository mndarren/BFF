package com.example.harrison.bffofscsu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 4/9/2016.
 */
public class OHAdapter extends ArrayAdapter {

    //Declarations
//    int[] imgs={};
//    String[] names = {};
//    String[] departments = {};
    Context ctx;
    LayoutInflater inflater;
//
//        public OHAdapter(Context context, String[] names, String[] departments, int[] imgs) {
//        super(context, R.layout.professor_item_layout,names);
//
//        this.ctx = context;
//        this.names = names;
//        this.departments = departments;
//        this.imgs = imgs;
//    }

    List<ProfessorInfo> list = new ArrayList<ProfessorInfo>();
    public OHAdapter(Context context,int resource){super(context,resource);}

    public void add(ProfessorInfo object){
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ProfessorInfo getItem(int position) {
        return (ProfessorInfo) list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.professor_item_layout,parent,false);
        }

        //our viewholder
        final ViewHolder holder = new ViewHolder();
        holder.professorFirstName = (TextView) convertView.findViewById(R.id.professorlist_first_name);
        holder.professorLastName = (TextView) convertView.findViewById(R.id.professorlist_last_name);
        holder.professorIcon = (ImageView) convertView.findViewById(R.id.professor_icon);
        holder.professorDepartment = (TextView) convertView.findViewById(R.id.professorlist_department);
        holder.professorJobTitle = (TextView) convertView.findViewById(R.id.professorlist_job_title);

        //assign data
        ProfessorInfo professorInfo = (ProfessorInfo)this.getItem(position);
        holder.professorIcon.setImageResource(R.drawable.sarnath_icon);//need to be changed
        holder.professorFirstName.setText(professorInfo.getProfessor_first_name());
        holder.professorLastName.setText(professorInfo.getProfessor_last_name());
        holder.professorDepartment.setText(professorInfo.getProfessor_department());
        holder.professorJobTitle.setText(professorInfo.getProfessor_job_title());

        return convertView;
    }
    private class ViewHolder{
        ImageView professorIcon;
        TextView professorFirstName, professorLastName;
        TextView professorJobTitle, professorDepartment;
    }
}