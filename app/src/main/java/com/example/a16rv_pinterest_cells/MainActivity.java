package com.example.a16rv_pinterest_cells;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.a16rv_pinterest_cells.adapter.CustomAdapter;
import com.example.a16rv_pinterest_cells.helper.SpacesItemDecoration;
import com.example.a16rv_pinterest_cells.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = prepareUserList();
        refreshAdapter(users);
    }
    public void refreshAdapter(List<User> users){
        CustomAdapter adapter = new CustomAdapter(context, users);
        recyclerView.setAdapter(adapter);
    }

    private List<User> prepareUserList() {
        List<User> users = new ArrayList<>();
        for (int i=1; i<41; i++){
            users.add(new User("A"+i, " B "+i));
        }
        return users;
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration= new SpacesItemDecoration(20);
        recyclerView.addItemDecoration(decoration);
    }


}