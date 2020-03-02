package com.abraham.sqlite_user_managmenet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button LgBtn,RgBtn;
    private EditText Uname,Passw;
    private SQLiteDBHandler db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new SQLiteDBHandler(this);
        session = new Session(this);
        LgBtn = findViewById(R.id.lginBtnId);
        RgBtn = findViewById(R.id.lgRegBtnId);
        Uname = findViewById(R.id.lgUnameId);
        Passw = findViewById(R.id.lgPassId);
        LgBtn.setOnClickListener(this);
        RgBtn.setOnClickListener(this);

        if (session.loggedIn()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lginBtnId:
                  login();
                break;
            case R.id.lgRegBtnId:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:
        }
    }

    private void login(){
        String uname = Uname.getText().toString();
        String passw = Passw.getText().toString();

        if (db.getUser(uname,passw)){
            session.setLoggedIn(true);
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Wrong User Name/Password",Toast.LENGTH_SHORT).show();
        }
    }
}
