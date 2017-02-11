package gts.weightd.Activities;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import gts.weightd.Adapters.EntryAdapter;
import gts.weightd.Entry;
import gts.weightd.EntryDataSource;
import gts.weightd.Indicator;
import gts.weightd.R;
import gts.weightd.TimeManager;
import gts.weightd.User;
import gts.weightd.Weightd;


import static gts.weightd.InterfaceHelper.blockNullText;
import static gts.weightd.R.id.valueNumberTextEdit;

public class TrackActivity extends AppCompatActivity implements View.OnClickListener {


    Weightd appState;
    Integer mDate;
    int mColor;
    Map<String, Indicator> indicatorMap = new HashMap<>();
    Map<String, Entry> entryMap;
    Map<String, User> userMap;
    List<Entry> mTodayEntryList;
    Entry[] mTodayEntryArray;

    Map<Integer, List<Entry>> mDateEntryMap;


    String[] entryStringArray;
    Set<String> entryStringSet;
    String[] indicatorStrings = {"test1", "test2"};
    Set<String> indicatorSet = new HashSet<>();


    Indicator currentIndicator;
    Entry currentEntry;
    User currentUser;

    EditText valueEditText;
    double valueDouble = 0.0;
    Spinner dropDown;
    String spinText = "weight";

    Button submitButton;
    Button saveButton;


    private RecyclerView.LayoutManager layoutManager;

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    EntryAdapter listAdapter;

    @BindView(R.id.entryRecyclerView)
    public RecyclerView mRecyclerView;


    private final String KEY_RECYCLER_STATE = "recycler_state";
    private static Bundle mBundleRecyclerViewState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        ButterKnife.bind(this);


        currentUser = new User("Test User");
        currentIndicator = new Indicator("Weight", "Lbs", -1);
        currentEntry = new Entry(currentIndicator, 0, 0, currentUser,
                this,currentIndicator.getIndicatorColor());
        mTodayEntryList = new ArrayList<Entry>();


        mTodayEntryArray = new Entry[mTodayEntryList.size()];

        for (int i = 0; i < mTodayEntryList.size(); i++) {
            mTodayEntryArray[i] = mTodayEntryList.get(i);
        }

        listAdapter = new EntryAdapter((ArrayList<Entry>) mTodayEntryList);

        mRecyclerView.setAdapter(listAdapter);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);


        valueEditText = (EditText) findViewById(valueNumberTextEdit);
        submitButton = (Button) findViewById(R.id.entryAddButton);
        submitButton.setOnClickListener(this);
        blockNullText(valueEditText, submitButton);

        saveButton = (Button) findViewById(R.id.entrySubmitButton);
        saveButton.setOnClickListener(this);


        appState = ((Weightd) getApplicationContext());
        indicatorMap = appState.indicatorGlobalMap;
        entryMap = appState.entryGlobalMap;
        userMap = appState.userGlobalMap;


        mDateEntryMap = new HashMap<>();
        mDateEntryMap.put(TimeManager.getInstance(this).getIntDayOfYear(), mTodayEntryList);


// Fix spinner width so it doesn't spill over onto the number
        //also set up array to avoid blank values. Consider datastructure that onl
        dropDown = (Spinner) findViewById(R.id.indicatorSpinner);

        indicatorSet = indicatorMap.keySet();
        indicatorStrings = indicatorSet.toArray(new String[0]);

        entryStringSet = entryMap.keySet();
        entryStringArray = entryStringSet.toArray(new String[entryStringSet.size()]);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, indicatorStrings);
        dropDown.setAdapter(adapter);

//
//        currentEntry = new Entry(currentIndicator, 0, 0, currentUser, this,
//                currentIndicator.getIndicatorColor()); duplicate


//
//        -- my first attempt at recyclerviews just reading the tutorials--
//        RecyclerView = (RecyclerView) findViewById(R.id.entry_recycler_view);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        RecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        LayoutManager = new LinearLayoutManager(this);
//        RecyclerView.setLayoutManager(LayoutManager);

//
//        // specify an adapter (see also next example)
////        this.adapter = new EntryAdapter(mTodayEntryArray);
////        RecyclerView.setAdapter(this.adapter);


        EntryDataSource dataSource = new EntryDataSource(this);


    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.entryAddButton:



                spinText = dropDown.getSelectedItem().toString();

                try{
                valueDouble = Double.parseDouble(valueEditText.getText().toString());}
                catch(java.lang.NumberFormatException nfe){
                    Toast.makeText(this, "No number found"
                            , Toast.LENGTH_SHORT).show();
                }


                currentIndicator = indicatorMap.get(spinText);


                currentEntry = new Entry(currentIndicator,valueDouble,
                        TimeManager.getInstance(this).getIntDayOfYear(),
                        userMap.get("default"), this, currentIndicator.getIndicatorColor());


                if (TimeManager.getInstance(this).getIntDayOfYear() == currentEntry.getDateInt()) {

                    //mTodayEntryList.add(currentEntry);
                    Toast.makeText(getApplicationContext(), currentEntry.getLabel() + " " +
                                    currentEntry.getDate(),
                            Toast.LENGTH_SHORT).show();

                    //preventing duplicates
                    for(Entry entry: mTodayEntryList){
                        if(currentEntry.getLabel().equals(entry.getLabel())){
                            Toast.makeText(this, "Duplicate Entry"
                                    , Toast.LENGTH_SHORT).show();
                            mTodayEntryList.remove(entry);

                        }
                    }
                    mTodayEntryList.add(currentEntry);



                    listAdapter.notifyDataSetChanged();
                    //listAdapter.notifyItemInserted(listAdapter.get); this is bad for large
                    //datasets
                    //// TODO: 12/27/16 Refactor the notifyDataSetChanged in your track activity


                } else {
                    Toast.makeText(getApplicationContext(), "date problems",
                            Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.entrySubmitButton:
                   /*We'll need to create a save button that runs the logic below and then pushes
                   the mDateEntryMap data to the sqllite database*/


                if (mDateEntryMap == null) {
                    Toast.makeText(getApplicationContext(), "Input First Entry ",
                            Toast.LENGTH_SHORT).show();
                } else {
                    mDateEntryMap.put(TimeManager.getInstance(this).getIntDayOfYear(),
                            mTodayEntryList);
                    Toast.makeText(getApplicationContext(), "submit button works ",
                            Toast.LENGTH_SHORT).show();
                }


        }
    }


    //These are supposed to maintain the recyclerview when I change intents. not working
    //// TODO: 12/27/16 keep the recyclerview persistent between intents and on rotate
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        // save RecyclerView state
//        mBundleRecyclerViewState = new Bundle();
//        Parcelable listState = mRecyclerView.getLayoutManager().onSaveInstanceState();
//        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);
//
//
//    }
//
    @Override
    protected void onResume() {
        super.onResume();
        //instatiate our entry datasource to create our sqlite database
//        EntryDataSource dataSource = new EntryDataSource(this);

    }

//
//        // restore RecyclerView state
//        if (mBundleRecyclerViewState != null) {
//            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
//            mRecyclerView.getLayoutManager().onRestoreInstanceState(listState);
//        }




    //}


}


