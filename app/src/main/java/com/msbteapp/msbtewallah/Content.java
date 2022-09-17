package com.msbteapp.msbtewallah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Content extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root;
    private RecyclerView recyclerView;
    private ContentAdapter adapter;
    private ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String titleStr = getIntent().getExtras().getString("res_selected");
        if (titleStr.equals("books")){
            getSupportActionBar().setTitle("Books");
        }else if (titleStr.equals("notes")){
            getSupportActionBar().setTitle("Notes");
        }else if (titleStr.equals("manuals")){
            getSupportActionBar().setTitle("Manuals");
        }else if (titleStr.equals("solved_manuals")){
            getSupportActionBar().setTitle("Solved Manuals");
        }else if (titleStr.equals("pyqp")){
            getSupportActionBar().setTitle("PYQ Papers");
        }else{
            getSupportActionBar().setTitle("Other");
        }

        String selectedBranch = getIntent().getExtras().getString("branch_selected");
        String selectedSem = getIntent().getExtras().getString("sem_selected");
        String selectedRes = getIntent().getExtras().getString("res_selected");

        root = database.getReference("home").child(selectedBranch).child(selectedSem).child(selectedRes);

        recyclerView = findViewById(R.id.contentRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new ContentAdapter(this ,list);

        recyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Item model = dataSnapshot.getValue(Item.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}