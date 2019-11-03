package com.example.a1stclass;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etReg;
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    adapter md;
    ArrayList<student> al;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.tv1);
        etReg = findViewById(R.id.tv2);
        rv = findViewById(R.id.recycle);
        al = new ArrayList<>();
        md = new adapter(this,al);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(md);
        rv.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
    }

    public void dothis(View view)
    {
        String name = etName.getText().toString();
        int reg = Integer.parseInt(etReg.getText().toString());
        student s= new student(name,reg);
        al.add(s);
        md.notifyDataSetChanged();
    }
}

