package gts.weightd;

import android.content.Context;

public class Entry {
    private double value = 0;
    private Integer date = 0;
    private Indicator mIndicator = new Indicator("Weight", "Lbs", 000000);
    private User user = new User("Test User");
    private String label;
    private String units;
    private float color;

        // variable to hold context
        private Context context;

//save the context received via constructor in a local variable

    public Entry(Indicator indicator, double value, Integer date,  User user, Context context) {
        this.value = value;
        this.date = date;
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

    public Integer getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public float getColor() {
        return color;
    }

    public void setColor(float color) {
        this.color = color;
    }
}