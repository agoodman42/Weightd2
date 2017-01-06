package gts.weightd.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import gts.weightd.Activities.ColorPickerActivity;
import gts.weightd.Indicator;
import gts.weightd.R;
import gts.weightd.Weightd;

import static gts.weightd.InterfaceHelper.blockNullText;
import static gts.weightd.R.id.circleButton;
import static gts.weightd.R.id.indicatorSaveButton;

public class CreateIndicatorsActivity extends AppCompatActivity implements View.OnClickListener {
    static final int PICK_COLOR_REQUEST = 1;  // The request code
    int color = 000000;
    Button colorButton;
    Bundle extras;
    Drawable background;

    EditText nameText;
    EditText unitText;
    Button saveButton;
    Indicator currentIndicator;

    String newIndicatorName = "";
    String newIndicatorUnit = "";

    Weightd appState;
    Map<String, Indicator> indicatorMap;

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_indicators);


        colorButton = (Button) findViewById(R.id.circleButton);
        nameText = (EditText) findViewById((R.id.indicatorNameEditText));
        unitText = (EditText) findViewById(R.id.indicatorUnitEditText);
        saveButton = (Button) findViewById(R.id.indicatorSaveButton);
        saveButton.setOnClickListener(this);
        colorButton.setOnClickListener(this);


        blockNullText(nameText, saveButton);


        appState = ((Weightd) getApplicationContext());
        indicatorMap = appState.indicatorGlobalMap;




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
                nameText.getText();
                Intent intent = new Intent(this, ColorPickerActivity.class);
//                //intent.putExtra(EXTRA_MESSAGE, message);

                startActivityForResult(intent, PICK_COLOR_REQUEST);

                break;

            case indicatorSaveButton:


                newIndicatorName = String.valueOf(nameText.getText());
                newIndicatorUnit = String.valueOf(unitText.getText());

                currentIndicator = new Indicator(newIndicatorName, newIndicatorUnit,
                        color);
                indicatorMap.put(newIndicatorName, currentIndicator);


                nameText.setText("");
                unitText.setText("");

                break;

            default:
                break;

        }
    }

    // Here we override onActivityResult to get the color from the activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_COLOR_REQUEST) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                     extras = data.getExtras();

                if (extras != null) {
                    color = extras.getInt("changeColor");
                    colorButton.setBackgroundColor(color);


            } else {
                Toast.makeText(getApplicationContext(), "fail",
                        Toast.LENGTH_SHORT).show();
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
        }
    }
}



