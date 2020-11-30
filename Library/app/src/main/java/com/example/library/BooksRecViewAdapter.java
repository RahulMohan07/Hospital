package com.example.library;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder> {

    private ArrayList<Books> book = new ArrayList<>();
    private Context context;

    public BooksRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder called");
        holder.bookName.setText(book.get(position).getName());
        Glide.with(context).asBitmap().load(book.get(position).getImageURL()).into(holder.imgBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,book.get(position).getName() + " Selected",Toast.LENGTH_SHORT).show();
            }
        });

        holder.txtAuthor.setText(book.get(position).getAuthor());
        holder.txtShortDesc.setText(book.get(position).getShortDesc());

        if(book.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedView.setVisibility(View.VISIBLE);
            holder.downarrow.setVisibility(View.GONE);
        }
        else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedView.setVisibility(View.GONE);
            holder.downarrow.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    public void setBook(ArrayList<Books> book) {
        this.book = book;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView bookName;
        private RelativeLayout expandedView;
        private ImageView uparrow,downarrow;
        private TextView txtShortDesc,txtAuthor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            bookName = itemView.findViewById(R.id.txtBookName);
            expandedView = itemView.findViewById(R.id.expanded_layout);
            uparrow = itemView.findViewById(R.id.uparrow);
            downarrow = itemView.findViewById(R.id.downarrow);
            txtAuthor = itemView.findViewById(R.id.authorname);
            txtShortDesc = itemView.findViewById(R.id.shortdesc);

            downarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books books = book.get(getAdapterPosition());
                    books.setExpanded(!books.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            uparrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books books = book.get(getAdapterPosition());
                    books.setExpanded(!books.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
