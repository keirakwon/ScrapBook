package com.example.soon.scrapbook;

/**
 * Created by soon on 2015-08-05.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerAdapter extends Adapter<RecyclerAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    public RecyclerAdapter(String[] dataset, Context context) {
        mDataset = dataset;
        mContext = context;
    }

    // Not use static
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.avatar);

            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            mContext,
                            "onItemClick - " + getPosition() + " - "
                                    + mTextView.getText().toString() + " - "
                                    + mDataset[getPosition()], Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
       // holder.mImageView.setImageDrawable(R.drawable.iu);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
}
