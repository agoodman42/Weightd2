package gts.weightd.Activities;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gts.weightd.EntryDataSource;
import gts.weightd.R;

public class DailyRecordListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list);


    }

    @Override
    protected void onResume() {
        super.onResume();

        EntryDataSource datasource = new EntryDataSource((this));
    }
}
