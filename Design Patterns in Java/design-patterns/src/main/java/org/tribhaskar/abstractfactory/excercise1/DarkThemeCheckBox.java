package org.tribhaskar.abstractfactory.excercise1;

public class DarkThemeCheckBox implements CheckBox{
    @Override
    public void check() {
        System.out.println("Painting a checkbox in dark theme");
    }
}
