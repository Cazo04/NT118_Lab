package com.example.testapp.Lab02_6_Class;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.Lab02_4_Class.Employee2;
import com.example.testapp.R;

import java.util.List;

public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<EmployeeRecyclerAdapter.EmployeeViewHolder> {
    List<Employee2> employee2s;

    public EmployeeRecyclerAdapter(List<Employee2> employee2s) {
        this.employee2s = employee2s;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee2 employee2 = employee2s.get(position);
        if (employee2.getFullName()!=null) {
            holder.tvFullName.setText(employee2.getFullName());
        }
        else holder.tvFullName.setText("");
        // If this is a manager -> show icon manager. Otherwise, show Staff in
        if (employee2.isManager())
        {
            holder.ivManager.setVisibility(View.VISIBLE);
            holder.tvPosition.setVisibility(View.GONE);
        }
        else
        {
            holder.ivManager.setVisibility(View.GONE);
            holder.tvPosition.setVisibility(View.VISIBLE);
            holder.tvPosition.setText("Staff");
        }
        // Show different color backgrounds for 2 continuous employees
        if (position%2==0)
        {
            holder.llParent.setBackgroundResource(R.color.white);
        }
        else
        {
            holder.llParent.setBackgroundResource(R.color.light_blue);
        }
    }

    @Override
    public int getItemCount() {
        return employee2s.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        TextView tvPosition ;
        ImageView ivManager;
        LinearLayout llParent;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = (TextView)
                    itemView.findViewById(R.id.item_employee_tv_fullname);
            tvPosition = (TextView)
                    itemView.findViewById(R.id.item_employee_tv_position);
            ivManager = (ImageView)
                    itemView.findViewById(R.id.item_employee_iv_manager);
            llParent = (LinearLayout)
                    itemView.findViewById(R.id.item_employee_ll_parent);
        }
    }
}
