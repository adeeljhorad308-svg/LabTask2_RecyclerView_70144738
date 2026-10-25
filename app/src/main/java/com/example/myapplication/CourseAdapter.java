package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final List<Course> courseList;
    private final OnItemClickListener listener;

    public CourseAdapter(List<Course> courseList, OnItemClickListener listener) {
        this.courseList = courseList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course, parent, false);
        return new CourseViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courseList.get(position);
        holder.tvCourseCode.setText(course.getCode());
        holder.tvCourseTitle.setText(course.getTitle());
        holder.tvCreditHours.setText(course.getCreditHours() + " Credit Hours");
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourseCode;
        TextView tvCourseTitle;
        TextView tvCreditHours;

        public CourseViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            tvCourseCode = itemView.findViewById(R.id.tvCourseCode);
            tvCourseTitle = itemView.findViewById(R.id.tvCourseTitle);
            tvCreditHours = itemView.findViewById(R.id.tvCreditHours);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getBindingAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
