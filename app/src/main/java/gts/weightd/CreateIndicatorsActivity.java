package gts.weightd;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static gts.weightd.R.id.circleButton;
import static gts.weightd.R.id.indicatorSaveButton;

public class CreateIndicatorsActivity extends AppCompatActivity implements View.OnClickListener {

    int color;
    Button colorButton;
    Bundle extras;
    Drawable background;

    EditText nameText;
    EditText unitText;
    Button saveButton;
    Indicator currentIndicator;

    String newIndicatorName;
    String newIndicatorUnit;

    Weightd appState;
    List<Indicator> IndicatorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_indicators);
        Button colorButton = (Button) findViewById(circleButton);
        colorButton.setOnClickListener(this);

        nameText = (EditText) findViewById((R.id.indicatorNameEditText));
        unitText = (EditText) findViewById(R.id.indicatorUnitEditText);
        saveButton = (Button) findViewById(R.id.indicatorSaveButton);
        saveButton.setOnClickListener(this);





        appState = ((Weightd)getApplicationContext());
        IndicatorList = appState.indicatorGlobalArray;


        extras = getIntent().getExtras();

        if (extras != null) {
            color = extras.getInt("changeColor");
            colorButton.setBackgroundColor(color);


        }
        else{Toast.makeText(getApplicationContext(),"Empty Color Value",
                Toast.LENGTH_SHORT).show();}
    }

    /*

        http://stackoverflow.com/questions/4967740/transfer-data-from-one-activity-to-another-activity-using-intents
        Use this stack overflow page to continue your work. Next steps are to create indicators and
        a) figure out how to store them as persistent data
        and
        b) figure out how to pass them from activity to activity.

        you're also going to need to figure out how to create a list view and then take the
        results of this activity and add to an array which will populate that list-view.         */


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case circleButton:
                Intent intent = new Intent(this, ColorPickerActivity.class);
//                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

                break;

            case indicatorSaveButton:


                newIndicatorName = String.valueOf(nameText.getText());
                newIndicatorUnit = String.valueOf(unitText.getText());

                currentIndicator = new Indicator(color,newIndicatorName, newIndicatorUnit );
                IndicatorList.add(currentIndicator);



                nameText.setText("");
                unitText.setText("");

                break;

            default:
                break;





        }
    }


//    @Override
//    protected void onNewIntent(Intent intent) {
//        extras = getIntent().getExtras();
//
//        if (extras != null) {
//            color = extras.getInt("changeColor");
//            colorButton.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
//        else{Toast.makeText(getApplicationContext(),"fail",
//                Toast.LENGTH_SHORT).show();}
//    }

}


