package com.example.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editAge, editAddress, editDestination;
    private Button view,add,back;
    private List<Student> studentList = new ArrayList<>();
    private StudentAdapter studentAdapter;
    private RecyclerView studentRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editAge = findViewById(R.id.edit_age);
        editAddress = findViewById(R.id.edit_address);
        editDestination = findViewById(R.id.edit_destination);
        view=findViewById(R.id.btn_view);
        add=findViewById(R.id.btn_add);
        back=findViewById(R.id.btn_back);
        LinearLayout inputWrapper = findViewById(R.id.student_wrapper);
        studentRv = findViewById(R.id.student_list_view);

        inputWrapper.setVisibility(View.VISIBLE);
        studentRv.setVisibility(View.GONE);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            Student student1 = new Student();

            student1.name=editName.getText().toString();
            student1.age=Integer.parseInt(editAge.getText().toString());
            student1.address=editAddress.getText().toString();
            student1.destination=Double.parseDouble(editDestination.getText().toString());

            studentList.add(student1);


        }

       });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              studentAdapter = new StudentAdapter(studentList);
              studentRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
              studentRv.setAdapter(studentAdapter);
                inputWrapper.setVisibility(View.GONE);
                studentRv.setVisibility(View.VISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWrapper.setVisibility(View.VISIBLE);
                studentRv.setVisibility(View.GONE);
            }
        });
    }
}