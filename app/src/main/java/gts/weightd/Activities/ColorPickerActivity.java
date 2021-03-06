package gts.weightd.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;

import gts.weightd.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class ColorPickerActivity extends AppCompatActivity
        implements ColorPicker.OnColorChangedListener, View.OnClickListener {

    private ColorPicker picker;
    private SVBar svBar;
    private OpacityBar opacityBar;
    private Button button;
    private Button submitButton;
    private float color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);



        picker = (ColorPicker) findViewById(R.id.picker);
        svBar = (SVBar) findViewById(R.id.svbar);

        button = (Button) findViewById(R.id.colorPickerChangeColorButton);
        submitButton = (Button) findViewById(R.id.colorSubmitButton);

        picker.addSVBar(svBar);
        picker.setOnColorChangedListener(this);

        button.setOnClickListener(this);
        submitButton.setOnClickListener(this);
        color = picker.getColor();


    }




    @Override
    public void onColorChanged(int color) {
        //gives the color when it's changed.
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.colorPickerChangeColorButton:
                picker.setOldCenterColor(picker.getColor());
                break;


            case R.id.colorSubmitButton:


//                Intent indicatorIntent = new Intent(ColorPickerActivity.this ,
//                        CreateIndicatorsActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putInt("changeColor", picker.getColor());
//                indicatorIntent.putExtras(bundle);
//                indicatorIntent.addFlags (FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(indicatorIntent);

//                Intent output = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putInt("changeColor", picker.getColor());
//                output.putExtras(bundle);
//                setResult(RESULT_OK, output);
//                finish();


                Intent returnIntent = new Intent();

                Bundle bundle = new Bundle();
                bundle.putInt("changeColor", picker.getColor());
                returnIntent.putExtras(bundle);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

                break;

            default:
                break;



        }
    }
}

//http://stackoverflow.com/questions/4967740/transfer-data-from-one-activity-to-another-activity-using-intents