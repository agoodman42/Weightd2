package gts.weightd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.empty;
import static gts.weightd.R.id.circleButton;
import static gts.weightd.R.id.indicatorSaveButton;

public class CreateIndicatorsActivity extends AppCompatActivity implements View.OnClickListener {

    int color;
    Button colorButton;
    Bundle extras;

    EditText nameText;
    EditText unitText;
    Button saveButton;
    Indicator currentIndicator;

    String newIndicatorName;
    String newIndicatorUnit;

    List<Indicator> indicatorList = new ArrayList<>();
    Indicator testIndicator = new Indicator("Red", "Flabs", "Metric Butts");

    int i = 0;


    ;

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



        indicatorList.add(testIndicator);




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

                break;

            case indicatorSaveButton:


                newIndicatorName = String.valueOf(nameText.getText());
                newIndicatorUnit = String.valueOf(unitText.getText());

                currentIndicator = new Indicator("RED",newIndicatorName, newIndicatorUnit );
                indicatorList.add(currentIndicator);

                Toast.makeText(getApplicationContext(),indicatorList.get(i).getIndicatorName(),
                        Toast.LENGTH_SHORT).show();
                i++;

                nameText.setText("");
                unitText.setText("");

                break;

            default:
                break;





        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = this.getIntent();
        //int id = i.getIntExtra("changeColor", 000000);
        //Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        }

    }
