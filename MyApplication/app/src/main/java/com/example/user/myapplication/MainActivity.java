package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button datButton;   //button to add new students
    private EditText nameField; //field to input name
    private EditText phoneField;    //field to input phone number
    private EditText emailField;    //field to input email address
    private ListView nameList;  //ListView object
    private TextView studentInList; //TextView object that reside in each row of ListView

    private String name;    //Student name used for passing to next Activity
    private String[] studentList;   //String array of student names from SQLite

    private SQLiteHandler db;   //SQLiteHandler instance
    private ArrayAdapter<String> adapter;   //Adapter instance
    private Context context;    //Application context of global variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new SQLiteHandler(getApplicationContext());
        context = this;

        datButton = (Button) findViewById(R.id.this_btn);
        nameField = (EditText) findViewById(R.id.nameField);
        phoneField = (EditText) findViewById(R.id.phoneField);
        emailField = (EditText) findViewById(R.id.emailField);
        nameList = (ListView) findViewById(R.id.student_list);
        studentInList = (TextView) findViewById(R.id.student_in_list);
        studentList = db.getStudentNameList();

        //write something about List View

        datButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                db.addStudent(nameField.getText().toString(), phoneField.getText().toString(), emailField.getText().toString());
                adapter = new ArrayAdapter<String>(context, R.layout.student_listview, db.getStudentNameList());
                adapter.notifyDataSetChanged();
                nameList.setAdapter(adapter);
            }
        });

        //write something about action onClick listView
    }
}
