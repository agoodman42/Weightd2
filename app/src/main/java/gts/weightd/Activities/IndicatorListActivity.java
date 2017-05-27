package gts.weightd.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gts.weightd.Adapters.MyAdapter;
import gts.weightd.Indicator;
import gts.weightd.R;

public class IndicatorListActivity extends AppCompatActivity {


    List<String> indicatorStringList = new ArrayList<>();
    Indicator testIndicator;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_list);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        // TODO: 3/5/17 now we have a working recyclerview that can take strings. Next step is to populate the string list with the sqlite database
        testIndicator = new Indicator("Weight", "Lbs", 000000);
        indicatorStringList.add(testIndicator.getIndicatorName());
        String[] myDataset = indicatorStringList.toArray(new String[0]);



        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

}
