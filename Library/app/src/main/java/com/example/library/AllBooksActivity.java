package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BooksRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksRecView = findViewById(R.id.booksRecview);
        adapter = new BooksRecViewAdapter(this);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Books> books = new ArrayList<>();
        books.add(new Books(1,"Norse Mythology","Neil Gaiman",282,"https://media.bloomsbury.com/rep/bj/9781526619211.jpg",
                "Norse Mythology” turns out to be a gripping, suspenseful and quite wonderful reworking of these famous tales","LONG DESC"));
        books.add(new Books(2,"The Da Vinci Code","Dan Brown",489,"https://images-na.ssl-images-amazon.com/images/I/51EICsHFHAL._SX302_BO1,204,203,200_.jpg",
                "The Da Vinci Code for all its success, is a poorly written thriller with a controversial hypothesis about the life of Jesus Christ and the Catholic Church","Long Description"));

        adapter.setBook(books);
    }
}