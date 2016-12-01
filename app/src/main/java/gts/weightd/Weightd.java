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
    public Map<String, Entry/*List<Entry>*/> entryGlobalMap;
    /* This is wrong. It will be necessary to re-work the app to accept a map of lists.
     * the Key will be the Date and the Value will be the list of entries for that day
      * It's probably time to create a date object and figure out how to grab the date from
      * the phone. We should have the recycler view only show the list of the chosen day,
       * or have multiple recycler views shown, one for each day there was an entry. then
       * we'll have to handle null entry days etc. one user, one date - many entries. That's
       * what we were initially trying to do with the value inside entry schema we had, but it
       * makes more sense to use nested collections than nested objects. Collections
       * are built to store data types.*/
    Indicator weight;
    Entry emptyEntry;
    User defaultUser;


/* Public variables for use all over the app. it will be necessary to serialize this or find
 * some other way to make it persistent.  */
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