package gts.weightd;

public class Entry {
    private double value = 0;
    private double date = 0;
    private Indicator mIndicator = new Indicator("Weight", "Lbs", 000000);
    private User user = new User("Test User");
    private String label;
    private String units;
    private float color;

    public Entry() {
        this.value = 0;
        this.date = 0;
        this.mIndicator = new Indicator("Weight", "Lbs", 000000);
        this.user = new User("Test User");
        this.label = mIndicator.getIndicatorName();
        this.units = mIndicator.getIndicatorUnit();
        this.color = mIndicator.getIndicatorColor();

    }

    public Entry(Indicator indicator, double value, double date,  User user) {
        this.value = value;
        this.date = date;
        this.mIndicator = indicator;
        this.user = user;
        this.label = indicator.getIndicatorName();
        this.units = indicator.getIndicatorUnit();
        this.color = indicator.getIndicatorColor();

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
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