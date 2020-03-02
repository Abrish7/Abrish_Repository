package com.abraham.sqlite_user_managmenet;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences prefs ;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myApp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedIn(boolean logggedin){
        editor.putBoolean("loggedInmode", logggedin);
        editor.commit();
    }

    public boolean loggedIn(){
        return prefs.getBoolean("loggedInmode", false);
    }
}
