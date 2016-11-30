package gts.weightd;

import android.app.Application;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Weightd extends Application {

    public List<Indicator> indicatorGlobalList;
    public List<Entry> entryGlobalList;



    public Weightd() {
        indicatorGlobalList = new ArrayList<>();
        entryGlobalList = new ArrayList<>();




    }
}