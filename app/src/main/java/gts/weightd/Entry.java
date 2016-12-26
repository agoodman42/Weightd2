package gts.weightd;

import android.content.Context;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Entry {
    private double value = 0;
    private Integer mTime = 0;
    private Indicator mIndicator = new Indicator("Weight", "Lbs", 000000);
    private User user = new User("Test User");
    private String label;
    private String units;
    private int color;

        // variable to hold context
        private Context context;

//save the context received via constructor in a local variable

    public Entry(Indicator indicator, double value, Integer date,  User user, Context context) {
        this.value = value;
        this.mTime = date;
        this.mIndicator = indicator;
        this.user = user;
        this.label = indicator.getIndicatorName();
        this.units = indicator.getIndicatorUnit();
        this.color = indicator.getIndicatorColor();
        this.context=context;

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
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
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