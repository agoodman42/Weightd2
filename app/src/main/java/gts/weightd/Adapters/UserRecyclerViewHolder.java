package gts.weightd.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gts.weightd.R;

public class UserRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView tv1;
    public ImageView imageView;

    public UserRecyclerViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.list_title);
        imageView= (ImageView) itemView.findViewById(R.id.list_avatar);

    }
}