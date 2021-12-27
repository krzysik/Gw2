package com.nauka.Nauka.model;

public class Attributes {
    private int Power;
    private int Precision;
    private int CritDamage;

    public Attributes()
    {
        super();
    }

    public Attributes(int power, int precision, int critDamage) {
        this.Power = power;
        this.Precision = precision;
        this.CritDamage = critDamage;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        this.Power = power;
    }

    public int getPrecision() {
        return Precision;
    }

    public void setPrecision(int precision) {
        this.Precision = precision;
    }

    public int getCritDamage() {
        return CritDamage;
    }

    public void setCritDamage(int critDamage) {
        CritDamage = critDamage;
    }
}
