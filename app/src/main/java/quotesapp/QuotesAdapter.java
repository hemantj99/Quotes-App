package com.example.quotesapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {

    List<String> quotes = null;
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
    public void onBindViewHolder(QuotesViewHolder quotesViewHolder, final int i) {
        String[] colors = {"#E91E63","#FFC107","#009688","#448AFF","#FF5722"};
        final String quote = quotes.get(i);
        quotesViewHolder.textQuote.setText(quote);
        int color = i % colors.length;
        final int intColor = Color.parseColor(colors[color]);
        quotesViewHolder.quoteContainer.setBackgroundColor(intColor);

        quotesViewHolder.textQuote.setText(quote);

        quotesViewHolder.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", quotes.get(i));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        quotesViewHolder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent txtIntent = new Intent(Intent.ACTION_SEND);
                txtIntent .setType("text/plain");
                txtIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                txtIntent .putExtra(Intent.EXTRA_TEXT, quotes.get(i));
                context.startActivity(Intent.createChooser(txtIntent ,"Share"));
                Toast.makeText(context, "Sharing..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder {

        TextView textQuote;
        LinearLayout quoteContainer;
        Button copyBtn;
        Button shareBtn;

        public QuotesViewHolder(View itemView) {
            super(itemView);
            textQuote = itemView.findViewById(R.id.textQuote);
            quoteContainer = itemView.findViewById(R.id.quoteContainer);
            copyBtn = itemView.findViewById(R.id.copyBtn);
            shareBtn = itemView.findViewById(R.id.shareBtn);
        }
    }
}
