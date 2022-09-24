package com.msbteapp.msbtewallah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Content extends AppCompatActivity {

    TextView emptyTextView;
    ShimmerFrameLayout shimmerFrameLayout;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root;
    private RecyclerView recyclerView;
    private ContentAdapter adapter;
    private ArrayList<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        shimmerFrameLayout = findViewById(R.id.shimmer_content);
        shimmerFrameLayout.startShimmer();

        emptyTextView = findViewById(R.id.emptyDisplayViewContent);

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

        SharedPreferences sharedPreferences = getSharedPreferences("last_items",MODE_PRIVATE);

        String selectedSem = sharedPreferences.getString("semester","sem5");
        String selectedBranch = sharedPreferences.getString("branch","co");
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
                    list.add(0,model);
                }

                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);

                if (list.isEmpty()){
                    recyclerView.setVisibility(View.GONE);
                    emptyTextView.setVisibility(View.VISIBLE);
                }else{
                    emptyTextView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
                adapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(0);
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