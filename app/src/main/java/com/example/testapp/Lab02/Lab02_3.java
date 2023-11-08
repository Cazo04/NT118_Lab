package com.example.testapp.Lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.testapp.Lab02_3_Class.Employee;
import com.example.testapp.Lab02_3_Class.EmployeeFullTime;
import com.example.testapp.Lab02_3_Class.EmployeePartTime;
import com.example.testapp.R;

import java.util.ArrayList;
import java.util.List;

public class Lab02_3 extends AppCompatActivity {

    private List<String> employees;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab023);

        ((RadioButton)findViewById(R.id.rbt_chinhthuc)).setChecked(true);
        ListView list_nv = ((ListView) findViewById(R.id.list_nv));

        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        list_nv.setAdapter(adapter);

        ((Button)findViewById(R.id.btn_apply)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });

    }
    public void addNewEmployee() {
        //Lấy ra đúng id của Radio Button được checked
        Employee employee;
        int radId = ((RadioGroup)findViewById(R.id.rgr_lnv)).getCheckedRadioButtonId();
        String id = ((EditText)findViewById(R.id.edit_manv)).getText().toString();
        String name = ((EditText)findViewById(R.id.edit_name)).getText().toString();
        if (radId == R.id.rbt_chinhthuc) {
            //tạo instance là FullTime
            employee = new EmployeeFullTime();
        } else {
            //Tạo instance là Partime
            employee = new EmployeePartTime();
        }
        //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
        //Đưa employee vào ArrayList
        employees.add(employee.toString());
        //Cập nhập giao diện
        adapter.notifyDataSetChanged();
    }
}
