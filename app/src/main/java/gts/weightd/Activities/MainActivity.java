package gts.weightd.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gts.weightd.R;
import gts.weightd.TimeManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

 //   Weightd appState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //grabbing time from android
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trackButton = (Button) findViewById(R.id.trackActivityButton);
        trackButton.setOnClickListener(this);

        Button indicatorButton = (Button) findViewById(R.id.indicatorEditButton);
        indicatorButton.setOnClickListener(this);

        Button entryListButton = (Button) findViewById(R.id.dailyEntryListButton);
        entryListButton.setOnClickListener(this);

        Button aboutAppButton = (Button) findViewById(R.id.aboutButton);
        aboutAppButton.setOnClickListener(this);

 //       appState = ((Weightd) getApplicationContext());


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.trackActivityButton:
                Toast.makeText(getApplicationContext(), "Track button works",
                        Toast.LENGTH_SHORT).show();

                Intent trackIntent = new Intent(this, TrackActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(trackIntent);



                break;


            case R.id.indicatorEditButton:
                Toast.makeText(getApplicationContext(), "Indicator button works",
                        Toast.LENGTH_SHORT).show();

                Intent indicatorIntent = new Intent(this, CreateIndicatorsActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(indicatorIntent);



                break;

            case R.id.dailyEntryListButton:
                Toast.makeText(getApplicationContext(), "EntryList button works",
                        Toast.LENGTH_SHORT).show();

                Intent entryListIntent = new Intent(this, DailyRecordListActivity.class);
//                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(entryListIntent);



                break;

            case R.id.aboutButton:

                Toast.makeText(getApplicationContext(),
                        TimeManager.getInstance(this).getDayOfYear(),
                        Toast.LENGTH_SHORT).show();


                break;



            default:

                break;

        }
    }
}