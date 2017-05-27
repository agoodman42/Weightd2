package gts.weightd.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gts.weightd.R;
import gts.weightd.User;


public class UserRecyclerAdapter extends  RecyclerView.Adapter<UserRecyclerViewHolder> {


    User testUser = new User("Robert");


    String [] name={testUser.getName()};
    Context context;
    LayoutInflater inflater;
    public UserRecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public UserRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.list_item_user, parent, false);

        UserRecyclerViewHolder viewHolder=new UserRecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserRecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            UserRecyclerViewHolder vholder = (UserRecyclerViewHolder) v.getTag();
            Toast.makeText(context,testUser.getName(),Toast.LENGTH_LONG ).show();

        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}
