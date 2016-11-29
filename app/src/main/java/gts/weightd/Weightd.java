package gts.weightd;

import android.app.Application;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Weightd extends Application {

    public List<Indicator> indicatorGlobalArray;
    public List<Entry> entryGlobalArray;



    public Weightd() {
        indicatorGlobalArray = new ArrayList<>();

        entryGlobalArray = new ArrayList<>();


    }
}