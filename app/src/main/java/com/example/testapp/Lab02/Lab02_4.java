package com.example.testapp.Lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import com.example.testapp.Lab02_4_Class.Employee2;
import com.example.testapp.Lab02_4_Class.EmployeeAdapter;
import com.example.testapp.R;

import java.util.ArrayList;
import java.util.List;

public class Lab02_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab024);

        ListView list_nv = (ListView) findViewById(R.id.list_nv);
        List<Employee2> employee2s = new ArrayList<>();
        EmployeeAdapter adapter = new EmployeeAdapter(this, R.layout.item_employee, employee2s);
        list_nv.setAdapter(adapter);

        ((Button)findViewById(R.id.btn_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = ((EditText)findViewById(R.id.edit_id)).getText().toString();
                String name = ((EditText)findViewById(R.id.edit_name)).getText().toString();
                boolean manager = ((CheckBox)findViewById(R.id.check_manager)).isChecked();

                Employee2 employee2 = new Employee2();
                employee2.setId(id);
                employee2.setManager(manager);
                employee2.setFullName(name);

                employee2s.add(employee2);
                adapter.notifyDataSetChanged();
            }
        });
    }

}