package com.example.a1stclass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder>
{
    private Context ct;
    private ArrayList<student> al;

    adapter(Context ct, ArrayList<student> al)
    {
        this.ct = ct;
        this.al= al;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater li =  LayoutInflater.from(ct);
        View v1 = li.inflate(R.layout.viewholder,parent,false);
        return new MyViewHolder(v1);
    }

    //@SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        student p = al.get(position);
        holder.tvName.setText(p.getName());
        holder.tvReg.setText(""+p.getReg ());
    }

    @Override
    public int getItemCount()
    {
        return al.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName, tvReg;
        ImageView ivremove;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.textView);
            tvReg = itemView.findViewById(R.id.textView2);

            ivremove = itemView.findViewById(R.id.imageView);

            linearLayout = itemView.findViewById(R.id.R1);

            ivremove.setVisibility(View.INVISIBLE);

            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {

                    ivremove.setVisibility(View.VISIBLE);

                    ivremove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            delete(getAdapterPosition());
                            ivremove.setVisibility(View.INVISIBLE);
                        }
                    });
                    return true;
                }
            });
        }
        public void delete(int position)
        {
            student p1 = al.get(position);
            al.remove(p1);
            notifyDataSetChanged();
        }
    }
}
