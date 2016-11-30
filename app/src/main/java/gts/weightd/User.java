package gts.weightd;

import android.widget.Switch;

public class User {

    private String Name;
    private String Gender;
    private boolean metric;
    private double heightEnglish;
    private double targetWeight;
    private boolean loseWeight;
    private boolean active;

    public User(String name) {

        this.Name = name;
        this.Gender = "Male";
        this.metric = false;
        this.heightEnglish = 69.7;
        this.targetWeight = 194.7;
        this.loseWeight = true;
        this.active = true;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public boolean isMetric() {
        return metric;
    }

    public void setMetric(boolean metric) {
        this.metric = metric;
    }

    public double getHeightEnglish() {
        return heightEnglish;
    }

    public void setHeightEnglish(double heightEnglish) {
        this.heightEnglish = heightEnglish;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public boolean isLoseWeight() {
        return loseWeight;
    }

    public void setLoseWeight(boolean loseWeight) {
        this.loseWeight = loseWeight;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}