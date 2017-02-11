package gts.weightd;

import android.content.Context;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Entry {
    private double value = 0;
    private Integer mTime = 0;
    private Indicator mIndicator = new Indicator("Weight", "Lbs", 000000);
    private User mUser = new User("Test User");
    private String mLabel;
    private String mUnits;
    private int mColor;
    private int mID = 0;

        // variable to hold context
        private Context context;

//save the context received via constructor in a local variable

    public Entry(Indicator indicator, double value, Integer time,  User user,
                 Context context,int color) {
        this.value = value;
        this.mTime = time;
        this.mIndicator = indicator;
        this.mUser = user;
        this.mLabel = indicator.getIndicatorName();
        this.mUnits = indicator.getIndicatorUnit();
        this.mColor = indicator.getIndicatorColor();
        this.context = context;
        this.mColor = color;

    }

    public int getID() {
        return mID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Integer getTime() {
        return mTime;
    }

    public void setTime(int time) {
        this.mTime = time;
    }

    public Indicator getIndicator() {
        return mIndicator;
    }

    public void setIndicator(Indicator indicator) {
        mIndicator = indicator;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        this.mUser = user;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        this.mLabel = label;
    }

    public String getUnits() {
        return mUnits;
    }

    public void setUnits(String units) {
        this.mUnits = units;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("d M y");
        Date date = new Date(mTime * 1000);
        return formatter.format(date);


    }
    public int getDateInt(){
        return mTime;

    }

}