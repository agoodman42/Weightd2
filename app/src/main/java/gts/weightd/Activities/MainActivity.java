package gts.weightd.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gts.weightd.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{




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

        Button indicatorListButton = (Button) findViewById(R.id.indicatorListButton);
        indicatorListButton.setOnClickListener(this);

        Button userListButton = (Button) findViewById(R.id.userListButton);
        userListButton.setOnClickListener(this);

        Button createUsersButton = (Button) findViewById(R.id.createUsersButton);
        createUsersButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.trackActivityButton:
                Toast.makeText(getApplicationContext(), "Track button works",
                        Toast.LENGTH_SHORT).show();

                Intent trackIntent = new Intent(this, TrackActivity.class);
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

//                Intent entryListIntent = new Intent(this, DailyRecordListActivity.class);
////                intent.putExtra(EXTRA_MESSAGE, message);
//                startActivity(entryListIntent);



                break;

            case R.id.indicatorListButton:

                Toast.makeText(getApplicationContext(), "Indicator List button works",
                        Toast.LENGTH_SHORT).show();
                Intent indicatorListIntent = new Intent(this, IndicatorListActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(indicatorListIntent);

                break;

            case R.id.userListButton:

                Toast.makeText(getApplicationContext(), "User List button works",
                        Toast.LENGTH_SHORT).show();
                Intent userListIntent = new Intent(this, UserListActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(userListIntent);

                break;

            case R.id.createUsersButton:

                Toast.makeText(getApplicationContext(), "login button works",
                        Toast.LENGTH_SHORT).show();
                Intent loginListIntent = new Intent(this, CreateUsersActivity.class);
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(loginListIntent);



            default:




                break;

        }
    }
}