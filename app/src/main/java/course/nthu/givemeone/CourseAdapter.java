package course.nthu.givemeone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rex5207 on 16/2/14.
 */
public class CourseAdapter extends BaseAdapter {
    private ArrayList<CourseModel> listData;
    private LayoutInflater layoutInflater;


    public CourseAdapter(Context aContext,ArrayList<CourseModel> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);

    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.courseitem, null);
            holder = new ViewHolder();
            holder.CourseName = (TextView) convertView.findViewById(R.id.CourseNameItem);
            holder.CourseTeacher = (TextView) convertView.findViewById(R.id.CourseTeacherItem);
            holder.CourseTime = (TextView) convertView.findViewById(R.id.CourseTimeItem);
            holder.CourseQuota = (TextView) convertView.findViewById(R.id.CourseQuotaItem);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.CourseName.setText(listData.get(position).getCourseName());
        holder.CourseTeacher.setText(listData.get(position).getCourseTeacher());
        holder.CourseTime.setText(listData.get(position).getCourseTime());
        holder.CourseQuota.setText(listData.get(position).getCourseQuota());

//        holder.next.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent();
//                i.setClass(context, Information.class);
//                context.startActivity(i);
//            }
//        });
        return convertView;
    }

    static class ViewHolder {
        TextView CourseName;
        TextView CourseTeacher;
        TextView CourseTime;
        TextView CourseQuota;
    }

}
