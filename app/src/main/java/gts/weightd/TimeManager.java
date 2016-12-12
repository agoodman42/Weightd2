package gts.weightd;

import android.content.Context;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.SimpleTimeZone;
import java.util.TimeZone;


//Singleton pattern. Research and use this instead of your silly global instance thing

public class TimeManager {

    String[] ids;
    SimpleTimeZone pdt;
    String dayOfYear;
    Integer intDayOfYear;

    Context mContext;
    private static TimeManager mTimeManager;


    public Integer getIntDayOfYear() {
        return intDayOfYear;
    }



    public String getDayOfYear() {
        return dayOfYear;
    }



    public static TimeManager getInstance(Context context){

        if (mTimeManager == null){
            mTimeManager = new TimeManager();
            mTimeManager.setupTime(context);
        }

        return mTimeManager;
    }

    private void setupTime(Context context){
        mContext = context;


        //Setting up global variable for time for the app

        ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);

        // get the supported ids for GMT-08:00 (Pacific Standard Time)


        // create a Pacific Standard Time time zone
        pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

        // set up rules for Daylight Saving Time
        pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);


        // create a GregorianCalendar with the Pacific Daylight time zone
        // and the current date and time
        Calendar calendar = new GregorianCalendar(pdt);
        Date trialTime = new Date();
        calendar.setTime(trialTime);


        intDayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        dayOfYear = Integer.toString(intDayOfYear);



    }
}
