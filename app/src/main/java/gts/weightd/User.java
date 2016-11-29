package gts.weightd;

import android.widget.Switch;

public class User {

    private String Name = "Test User";
    private String Gender = "Male";
    private boolean metric = false;
    private double heightEnglish = 69.7;
    private double targetWeight = 194.7;
    private boolean loseWeight = true;
    private boolean active = true;

    public User(String name, String gender, boolean metric,
                double heightEnglish, double targetWeight, boolean loseWeight, boolean active) {
        Name = name;
        Gender = gender;
        this.metric = metric;
        this.heightEnglish = heightEnglish;
        this.targetWeight = targetWeight;
        this.loseWeight = loseWeight;
        this.active = active;
    }
//
    public User(Object[] Args){

        this.Name = (String) Args[0];
        this.Gender = (String) Args[1];
        this.metric = (Boolean) Args[2];
        this.heightEnglish = (Double) Args[3];
        this.targetWeight = (Double) Args[4];
        this.loseWeight = (Boolean) Args[5];
        this.active = (Boolean) Args[6];
    }
    public User(){
          Name = "Test User";
          Gender = "Male";
          metric = false;
          heightEnglish = 69.7;
          targetWeight = 194.7;
          loseWeight = true;
          active = true;



    }


}