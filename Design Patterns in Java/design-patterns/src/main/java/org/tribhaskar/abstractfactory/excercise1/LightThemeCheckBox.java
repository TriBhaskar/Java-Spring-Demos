package org.tribhaskar.abstractfactory.excercise1;

public class LightThemeCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("Painting a checkbox in light theme");
    }
}
