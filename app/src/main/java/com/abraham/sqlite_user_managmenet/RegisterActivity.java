package com.abraham.sqlite_user_managmenet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText Fname,Lname,Uname,Email,Phone,Pass;
    private Button rgBtn;
    private RadioGroup radioGroup;
    private Button lgBtn;

    SQLiteDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new SQLiteDBHandler(this);
        Fname = findViewById(R.id.fnameId);
        Lname = findViewById(R.id.lnameId);
        Uname = findViewById(R.id.unameId);
        Email = findViewById(R.id.emailId);
        Phone = findViewById(R.id.phoneId);
        Pass = findViewById(R.id.passId);
        radioGroup = findViewById(R.id.radioGId);
        rgBtn = findViewById(R.id.regBtnId);
        lgBtn = findViewById(R.id.rgLgBtnId);
        rgBtn.setOnClickListener( this);
        lgBtn.setOnClickListener( this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.regBtnId:
                register();
                break;
            case R.id.rgLgBtnId:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    private void register(){
        RadioButton checkBtn = findViewById(radioGroup.getCheckedRadioButtonId());

        String email = Email.getText().toString();
        String fname = Fname.getText().toString();
        String lname = Lname.getText().toString();
        String uname = Uname.getText().toString();
        String phone = Phone.getText().toString();
        String pass = Pass.getText().toString();
        String radio = checkBtn.getText().toString();

        if(email.isEmpty() || fname.isEmpty() || lname.isEmpty() || uname.isEmpty() || phone.isEmpty()|| pass.isEmpty()){
            displayToast("please check if there is empty field!");
        }else{
            db.addUser(fname,lname,uname,email,phone,pass,radio);
            displayToast("User Registered");
            finish();
        }
    }
    private void displayToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
