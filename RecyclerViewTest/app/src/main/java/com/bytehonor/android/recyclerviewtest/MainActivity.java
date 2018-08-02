package com.bytehonor.android.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecylerView;

    private List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();

        mRecylerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(layoutManager);

        PersonAdapter adapter = new PersonAdapter(persons);
        mRecylerView.setAdapter(adapter);

    }

    private void initDatas() {
        persons = new ArrayList<Person>(60);
        for (int i=0;i<30;i++) {
            persons.add(new Person("name" + i, i));
        }
    }
}
