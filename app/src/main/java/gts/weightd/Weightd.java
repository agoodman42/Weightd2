package gts.weightd;

import android.app.Application;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weightd extends Application {

    public Map<String, User> userGlobalMap;
    public Map<String, Indicator> indicatorGlobalMap;
    public Map<String,Entry> entryGlobalMap;
    Indicator weight;
    Entry emptyEntry;
    User defaultUser;



    public Weightd() {
        userGlobalMap = new HashMap<>();
        defaultUser = new User("Default User");
        userGlobalMap.put("default", defaultUser);

        indicatorGlobalMap = new HashMap<>();
        Indicator weight = new Indicator("Weight", "lbs", 000000);
        Indicator hydration = new Indicator("Hydration", "%", 000000);
        indicatorGlobalMap.put("Weight", weight);
        indicatorGlobalMap.put("Hydration", hydration);

        entryGlobalMap = new HashMap<String, Entry>();
        emptyEntry = new Entry(weight,0,0,defaultUser);
        entryGlobalMap.put("empty entry", emptyEntry);




    }
}