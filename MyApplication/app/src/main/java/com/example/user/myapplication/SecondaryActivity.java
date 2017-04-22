package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class SecondaryActivity extends AppCompatActivity {

    private TextView displayName;
    private TextView displayPhone;
    private TextView displayEmail;

    private String name;
    private String phone;
    private String email;
    private HashMap<String, String> studentDetails;

    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        db = new SQLiteHandler(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("studentName");
        }

        studentDetails = db.getStudent(name);
        name = studentDetails.get("stu_name");
        phone = studentDetails.get("stu_phone");
        email = studentDetails.get("stu_email");

        displayName = (TextView) findViewById(R.id.student_name);
        displayName.setText(name);
        displayPhone = (TextView) findViewById(R.id.student_phone);
        displayPhone.setText(phone);
        displayEmail = (TextView) findViewById(R.id.student_email);
        displayEmail.setText(email);
    }
}
