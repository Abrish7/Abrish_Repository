package com.abraham.sqlite_user_managmenet;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInformation extends AppCompatActivity {
    TextView Fname,Lname,Uname,Email,Phone,Sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Intent intent = getIntent();
        String fname1 = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String uname = intent.getStringExtra("uname");
        String sex = intent.getStringExtra("sex");

        Fname = findViewById(R.id.postfnameID);
        Fname.setText(fname1);
        Lname = findViewById(R.id.postlnameID);
        Lname.setText(lname);
        Email = findViewById(R.id.postEmailID);
        Email.setText(email);
        Phone = findViewById(R.id.postPoneID);
        Phone.setText(phone);
        Uname = findViewById(R.id.postUnameID);
        Uname.setText(uname);
        Sex = findViewById(R.id.postSexID);
        Sex.setText(sex);
    }
}
