package org.tribhaskar.abstractfactory.excercise1;

public class DarkThemeButton implements Button{
    @Override
    public void paint() {
        System.out.println("Painting a button in dark theme");
    }
}
