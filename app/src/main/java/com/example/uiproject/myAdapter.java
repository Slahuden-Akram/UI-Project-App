package com.example.uiproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {

    private ArrayList<DataModel> dataModels = new ArrayList<>();
    private Context context;

    public myAdapter(ArrayList<DataModel> dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.singlerow, parent, false);
        return  new myAdapter.holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        final DataModel temp = dataModels.get(position);

        holder.tv.setText(dataModels.get(position).getName());
        Picasso.get().load(dataModels.get(position).getImage()).into(holder.img1);

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Details_Activity.class);
                intent.putExtra("Image",temp.getImage());
                intent.putExtra("Name",temp.getName());
                intent.putExtra("Desc", temp.getDesc());
                intent.putExtra("Id", temp.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView img1;
        public holder(@NonNull View itemView) {
            super(itemView);

            img1 =(ImageView) itemView.findViewById(R.id.img1);
            tv = (TextView)  itemView.findViewById(R.id.t1);
        }
    }
}
