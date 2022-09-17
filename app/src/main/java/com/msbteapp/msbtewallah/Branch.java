package com.msbteapp.msbtewallah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Branch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String titleStr = getIntent().getExtras().getString("branch_selected");
        if (titleStr.equals("co")){
            getSupportActionBar().setTitle("Computer/IT");
        }else if (titleStr.equals("mech")){
            getSupportActionBar().setTitle("Mechanical");
        }else if (titleStr.equals("elec")){
            getSupportActionBar().setTitle("Electrical");
        }else if (titleStr.equals("civil")){
            getSupportActionBar().setTitle("Civil");
        }else{
            getSupportActionBar().setTitle("Msbte Wallah");
        }

        Button btn1 = (Button) findViewById(R.id.sem_1);
        Button btn2 = (Button) findViewById(R.id.sem_2);
        Button btn3 = (Button) findViewById(R.id.sem_3);
        Button btn4 = (Button) findViewById(R.id.sem_4);
        Button btn5 = (Button) findViewById(R.id.sem_5);
        Button btn6 = (Button) findViewById(R.id.sem_6);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Branch.this, Resource.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", "sem1");

                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Branch.this, Resource.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", "sem2");

                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Branch.this, Resource.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", "sem3");

                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Branch.this, Resource.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", "sem4");

                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Branch.this, Resource.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", "sem5");

                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Branch.this, Resource.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", "sem6");

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}