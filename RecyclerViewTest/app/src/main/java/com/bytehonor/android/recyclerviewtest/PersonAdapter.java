package com.bytehonor.android.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonHolder> {

    private List<Person> persons;

    @NonNull
    @Override
    public PersonHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item_person, viewGroup, false);
        final PersonHolder holder = new PersonHolder(view);
        holder.mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int at = holder.getAdapterPosition();
                Person person = persons.get(at);
                Toast.makeText(viewGroup.getContext(), "click " + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.mAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int at = holder.getAdapterPosition();
                Person person = persons.get(at);
                Toast.makeText(viewGroup.getContext(), "click " + person.getAge(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonHolder personHolder, int i) {
        Person person = persons.get(i);
        personHolder.mAge.setText(person.getAge().toString());
        personHolder.mName.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    static class PersonHolder extends RecyclerView.ViewHolder {
        View holderView;

        TextView mName;
        TextView mAge;

        public PersonHolder (View view) {
            super(view);
            holderView = view;
            mName = (TextView) view.findViewById(R.id.text_name);
            mAge = (TextView) view.findViewById(R.id.text_age);
        }

    }

    public PersonAdapter(List<Person> list) {
        this.persons = list;
    }
}
