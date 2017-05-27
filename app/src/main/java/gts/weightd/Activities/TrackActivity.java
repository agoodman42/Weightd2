package gts.weightd.Activities;

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
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

import gts.weightd.Entry;
import gts.weightd.Indicator;
import gts.weightd.R;
import gts.weightd.TimeManager;
import gts.weightd.User;


import static gts.weightd.InterfaceHelper.blockNullText;
import static gts.weightd.R.id.valueNumberTextEdit;


public class TrackActivity extends AppCompatActivity implements View.OnClickListener {


    Integer mDate;
    int mColor;
    Map<String, Indicator> indicatorMap = new HashMap<>();
    Indicator testIndicator = new Indicator("Weight","lbs",0 );
    User testUser = new User("Test User");
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





    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        ButterKnife.bind(this);





        currentUser = new User("Test User");
        currentIndicator = new Indicator("Weight", "Lbs", -1);
        currentEntry = new Entry(currentIndicator, 0, 0, currentUser,
                this,currentIndicator.getIndicatorColor());








        valueEditText = (EditText) findViewById(valueNumberTextEdit);
        submitButton = (Button) findViewById(R.id.entryAddButton);
        submitButton.setOnClickListener(this);
        blockNullText(valueEditText, submitButton);

        saveButton = (Button) findViewById(R.id.entrySubmitButton);
        saveButton.setOnClickListener(this);




        mDateEntryMap = new HashMap<>();
        //// TODO: 2/15/17 figure out how to create the list of entries for each date
        //mDateEntryMap.put(mDate,mTodayEntryList);
        mDateEntryMap.put(TimeManager.getInstance(this).getIntDayOfYear(), mTodayEntryList);


// Fix spinner width so it doesn't spill over onto the number
        //also set up array to avoid blank values. Consider datastructure that onl
        dropDown = (Spinner) findViewById(R.id.indicatorSpinner);
        indicatorMap.put("test", testIndicator);
        indicatorSet = indicatorMap.keySet();
        indicatorStrings = indicatorSet.toArray(new String[0]);




        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, indicatorStrings);
        dropDown.setAdapter(adapter);




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
                        TimeManager.getInstance(this).getIntDayOfYear(),testUser, this, 000000);
//                currentEntry = new Entry(currentIndicator,valueDouble,
//                        TimeManager.getInstance(this).getIntDayOfYear(),
//                        userMap.get("default"), this, currentIndicator.getIndicatorColor());

                mTodayEntryList.add(currentEntry);

//                if (TimeManager.getInstance(this).getIntDayOfYear() == currentEntry.getDateInt()) {
//
//
//                    Toast.makeText(getApplicationContext(), currentEntry.getLabel() + " " +
//                                    currentEntry.getDate(),
//                            Toast.LENGTH_SHORT).show();
//
//                    //preventing duplicates
//                    for(Entry entry: mTodayEntryList){
//                        if(currentEntry.getLabel().equals(entry.getLabel())){
//                            Toast.makeText(this, "Duplicate Entry"
//                                    , Toast.LENGTH_SHORT).show();
//                            mTodayEntryList.remove(entry);
//
//                        }
//                    }
//                    mTodayEntryList.add(currentEntry);
//
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "date problems",
//                            Toast.LENGTH_SHORT).show();
//                }
//
//                break;

            case R.id.entrySubmitButton:

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


    @Override
    protected void onResume() {
        super.onResume();


    }

}


