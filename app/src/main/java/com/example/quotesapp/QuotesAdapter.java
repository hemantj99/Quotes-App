package com.example.quotesapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {

    List<String> quotes;
    Context context;

    public QuotesAdapter(List<String> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }
    @Override
    public QuotesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_quote, viewGroup, false);
        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuotesViewHolder quotesViewHolder, int i) {
        String[] colors = {"#E91E63","#FFC107","#009688","#448AFF","#FF5722"};
        final String quote = quotes.get(i);
        quotesViewHolder.textQuote.setText(quote);
        int color = i % colors.length;
        final int intColor = Color.parseColor(colors[color]);
        quotesViewHolder.quoteContainer.setBackgroundColor(intColor);

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {

        TextView textQuote;
        LinearLayout quoteContainer;

        public QuotesViewHolder(View itemView) {
            super(itemView);
            textQuote = itemView.findViewById(R.id.textQuote);
            quoteContainer = itemView.findViewById(R.id.quoteContainer);
        }
    }
}
