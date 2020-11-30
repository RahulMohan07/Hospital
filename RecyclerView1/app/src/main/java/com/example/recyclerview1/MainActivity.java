package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactrecview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactrecview = findViewById(R.id.rlist);
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Rahul","rahulmohan190@gmail.com","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/MGK_%2848250880612%29_%28cropped%29.jpg/1200px-MGK_%2848250880612%29_%28cropped%29.jpg"));
        contacts.add(new Contact("Anisha","anishapakki1999@gmail.com","https://www.nme.com/wp-content/uploads/2020/06/megan-fox-1.jpg"));
        contacts.add(new Contact("Regish","regish.george2000@gmail.com","https://i.pinimg.com/originals/ef/e7/e1/efe7e1c136a82ba8fe43b91af486adf9.jpg"));

        ContactRecViewAdapter adapter = new ContactRecViewAdapter(this);
        adapter.setContacts(contacts);
        contactrecview.setAdapter(adapter);
        contactrecview.setLayoutManager(new LinearLayoutManager(this));
    }
}