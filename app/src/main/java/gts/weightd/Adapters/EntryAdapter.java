package gts.weightd.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gts.weightd.Entry;
import gts.weightd.R;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder> {

    private Entry[] mEntries;
    private ArrayList mEntrySet;

    public EntryAdapter(ArrayList<Entry> entries) {

        //mEntries = entries;
        mEntrySet = entries;

    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entry_list_item, parent, false);
        EntryViewHolder viewHolder = new EntryViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(EntryViewHolder holder, int position) {
        //holder.bindEntry(mEntries[position]);
        holder.bindEntry((Entry) mEntrySet.get(position));

    }

    @Override
    public int getItemCount() {
        return mEntrySet.size();//mEntries.length;
    }

    public class EntryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mEntryColor;
        public TextView mEntryName;
        public TextView mEntryValue;
        public TextView mEntryUnits;



        public EntryViewHolder(View itemView) {
            super(itemView);
            mEntryColor = (ImageView) itemView.findViewById(R.id.entryColorImage);
            mEntryName = (TextView) itemView.findViewById(R.id.entryLabel);
            mEntryValue = (TextView) itemView.findViewById(R.id.entryValueLabel);
            mEntryUnits = (TextView) itemView.findViewById(R.id.entryUnitLabel);
        }

        public void bindEntry(Entry entry) {
            mEntryColor.setBackgroundColor((entry.getColor()));
            mEntryName.setText(entry.getLabel());
            String valueString = String.format("",entry.getValue());
            mEntryValue.setText(valueString);
            mEntryUnits.setText(entry.getUnits());

        }
    }
}
