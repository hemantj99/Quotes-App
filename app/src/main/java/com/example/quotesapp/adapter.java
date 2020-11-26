package com.example.quotesapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter  extends RecyclerView.Adapter<adapter.viewHolder> {

    ArrayList<data> quotesdata;
    Context context;

    public adapter(ArrayList<data> quotesdata, Context context) {
        this.quotesdata = quotesdata;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.viewHolder holder, int position) {

        holder.quotestext.setText(quotesdata.get(position).getQuotes());


        holder.copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label",quotesdata.get(position).getQuotes());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        holder.sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, quotesdata.get(position).getQuotes());
                context.startActivity(Intent.createChooser(intent, "Share"));

                Toast.makeText(context, "Sharing...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return quotesdata.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView quotestext;
        Button copybtn;
        Button sharebtn;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            quotestext = itemView.findViewById(R.id.quotestext);
            copybtn = itemView.findViewById(R.id.copybtn);
            sharebtn =itemView.findViewById(R.id.sharebtn);


        }
    }
}
