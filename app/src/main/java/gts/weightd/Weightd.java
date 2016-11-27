package gts.weightd;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Weightd extends Application {

    public List<Indicator> indicatorGlobalArray = null;
    public List<Entry> entryGlobalArray = null;


    public Weightd() {
        indicatorGlobalArray = new ArrayList<>();
        {

        }

        entryGlobalArray = new ArrayList<>();
        {

        }
    }
}