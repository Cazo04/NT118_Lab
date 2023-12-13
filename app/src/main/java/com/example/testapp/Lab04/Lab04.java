package com.example.testapp.Lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapp.R;

import java.util.List;

public class Lab04 extends AppCompatActivity {
    private EditText editTextStudentId, editTextStudentName, editTextStudentPhone, editTextStudentEmail;
    private Button buttonAdd, buttonDelete, buttonUpdate;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private List<Student> students;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab04);
        
        recyclerView = findViewById(R.id.recycler_st);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseHelper = new DatabaseHelper(this);
        students = databaseHelper.getStudents();

        adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);

        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextStudentName = findViewById(R.id.editTextStudentName);
        editTextStudentPhone = findViewById(R.id.editTextStudentPhone);
        editTextStudentEmail = findViewById(R.id.editTextStudentEmail);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStudent();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStudent();
            }
        });
        adapter.setOnStudentClickListener(new StudentAdapter.OnStudentClickListener() {
            @Override
            public void onStudentClick(int position) {
                Student student = students.get(position);
                editTextStudentId.setText(String.valueOf(student.getId()));
                editTextStudentName.setText(student.getName());
                editTextStudentPhone.setText(student.getPhone());
                editTextStudentEmail.setText(student.getEmail());
            }
        });
    }
    private void reesetView(){
        students.clear();
        for (Student student : databaseHelper.getStudents()){
            students.add(student);
        }
        adapter.notifyDataSetChanged();
    }
    private void addStudent() {
        String idStr = editTextStudentId.getText().toString();
        String name = editTextStudentName.getText().toString();
        String phone = editTextStudentPhone.getText().toString();
        String email = editTextStudentEmail.getText().toString();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = (idStr.equals("") ? 0 : Integer.parseInt(idStr));
        Student student = new Student(id, name, phone, email);
        ;
        boolean success = databaseHelper.addStudent(student);

        if (success) {
            Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
            reesetView();
            editTextStudentId.setText("");
            editTextStudentName.setText("");
            editTextStudentPhone.setText("");
            editTextStudentEmail.setText("");
        } else {
            Toast.makeText(this, "Failed to Add Student", Toast.LENGTH_SHORT).show();
        }
    }
    private void deleteStudent() {
        String idStr = editTextStudentId.getText().toString();

        if (idStr.isEmpty()) {
            Toast.makeText(this, "Please enter the student ID", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        boolean success = databaseHelper.deleteStudent(id);

        if (success) {
            Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to Delete Student", Toast.LENGTH_SHORT).show();
        }

        editTextStudentId.setText("");
        editTextStudentName.setText("");
        editTextStudentPhone.setText("");
        editTextStudentEmail.setText("");
        reesetView();
    }
    private void updateStudent() {
        String idStr = editTextStudentId.getText().toString();
        String name = editTextStudentName.getText().toString();
        String phone = editTextStudentPhone.getText().toString();
        String email = editTextStudentEmail.getText().toString();

        if (idStr.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = Integer.parseInt(idStr);
        Student student = new Student(id, name, phone, email);

        boolean success = databaseHelper.updateStudent(student);

        if (success) {
            Toast.makeText(this, "Student Updated", Toast.LENGTH_SHORT).show();
            editTextStudentId.setText("");
            editTextStudentName.setText("");
            editTextStudentPhone.setText("");
            editTextStudentEmail.setText("");
        } else {
            Toast.makeText(this, "Failed to Update Student", Toast.LENGTH_SHORT).show();
        }
        reesetView();
    }

}