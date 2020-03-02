package com.abraham.sqlite_user_managmenet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private Button logoutBtn;
    private Session session;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private SQLiteDBHandler SQLiteDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        if (!session.loggedIn()){
            logout();
        }


            SQLiteDbHandler = new SQLiteDBHandler(this);
            recyclerView = findViewById(R.id.recyclerviewId);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            myAdapter = new MyAdapter(this, SQLiteDbHandler.getAllUsers());
            recyclerView.setAdapter(myAdapter);
            logoutBtn = findViewById(R.id.logoutBtnId);
            logoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     logout();
                    }
                 });
    }

    private void logout() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

}
