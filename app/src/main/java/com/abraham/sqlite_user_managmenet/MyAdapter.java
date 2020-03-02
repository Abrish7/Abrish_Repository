package com.abraham.sqlite_user_managmenet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private ArrayList<Users> users;
    private CardView cardView;

    public MyAdapter(Context context, ArrayList<Users> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        cardView = holder.itemView.findViewById(R.id.cardViewId);
        final SQLiteDBHandler SQLiteDbHandler = new SQLiteDBHandler(context);
        SQLiteDbHandler.getAllUsers();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "toast", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), UserInformation.class);
                    intent.putExtra("fname",users.get(position).getFname());
                    intent.putExtra("lname",users.get(position).getLname());
                    intent.putExtra("uname",users.get(position).getUname());
                    intent.putExtra("email",users.get(position).getEmail());
                    intent.putExtra("phone",users.get(position).getPhone());
                    intent.putExtra("sex",users.get(position).getGender());
                    intent.putExtra("pass",users.get(position).getPass());
                v.getContext().startActivity(intent);
            }
        });
        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SQLiteDbHandler.removeUser(users.get(position).getId());
                users.remove(users.get(position));
                MyAdapter.this.notifyDataSetChanged();
                return false;
            }
        });
        holder.title.setText(users.get(position).getFname());
        holder.descriptor.setText(users.get(position).getLname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

}
