package gts.weightd;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static gts.weightd.R.id.circleButton;

public class CreateIndicatorsActivity extends AppCompatActivity implements View.OnClickListener {

    int color;
    Button colorButton;
    Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_indicators);
        Button colorButton = (Button) findViewById(circleButton);
        colorButton.setOnClickListener(this);




        /*

        http://stackoverflow.com/questions/4967740/transfer-data-from-one-activity-to-another-activity-using-intents
        Use this stack overflow page to continue your work. Next steps are to create indicators and
        a) figure out how to store them as persistent data
        and
        b) figure out how to pass them from activity to activity.

        you're also going to need to figure out how to create a list view and then take the
        results of this activity and add to an array which will populate that list-view.         */


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case circleButton:
                Intent intent = new Intent(this, ColorPickerActivity.class);
//                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);


        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = this.getIntent();
        int id = i.getIntExtra("changeColor", 000000);
        Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        }

    }