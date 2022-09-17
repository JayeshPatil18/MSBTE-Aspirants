package com.msbteapp.msbtewallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resource extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        Button btn_books = (Button) findViewById(R.id.res_books);
        Button btn_notes = (Button) findViewById(R.id.res_notes);
        Button btn_manuals = (Button) findViewById(R.id.res_manuals);
        Button btn_solvedManuals = (Button) findViewById(R.id.res_solvedManuals);
        Button btn_pyqp = (Button) findViewById(R.id.res_pyqp);
        Button btn_other = (Button) findViewById(R.id.res_other);

        btn_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resource.this, Content.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", getIntent().getExtras().getString("sem_selected"));
                intent.putExtra("res_selected", "books");

                startActivity(intent);
            }
        });

        btn_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resource.this, Content.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", getIntent().getExtras().getString("sem_selected"));
                intent.putExtra("res_selected", "notes");

                startActivity(intent);
            }
        });

        btn_manuals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resource.this, Content.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", getIntent().getExtras().getString("sem_selected"));
                intent.putExtra("res_selected", "manuals");

                startActivity(intent);
            }
        });

        btn_solvedManuals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resource.this, Content.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", getIntent().getExtras().getString("sem_selected"));
                intent.putExtra("res_selected", "solved_manuals");

                startActivity(intent);
            }
        });

        btn_pyqp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resource.this, Content.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", getIntent().getExtras().getString("sem_selected"));
                intent.putExtra("res_selected", "pyqp");

                startActivity(intent);
            }
        });

        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resource.this, Content.class);
                intent.putExtra("branch_selected", getIntent().getExtras().getString("branch_selected"));
                intent.putExtra("sem_selected", getIntent().getExtras().getString("sem_selected"));
                intent.putExtra("res_selected", "other");

                startActivity(intent);
            }
        });
    }
}