package com.example.testapp.Lab04;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    public interface OnStudentClickListener {
        void onStudentClick(int position);
    }
    private OnStudentClickListener listener;
    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }
    public void setOnStudentClickListener(OnStudentClickListener listener) {
        this.listener = listener;
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student currentStudent = students.get(position);
        holder.textViewName.setText(currentStudent.getName());
        holder.textViewID.setText(String.valueOf(currentStudent.getId()));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewID;

        StudentViewHolder(View itemView, final OnStudentClickListener listener) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.txt_name);
            textViewID = (TextView) itemView.findViewById(R.id.txt_id_2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onStudentClick(position);
                        }
                    }
                }
            });
        }
    }
}
