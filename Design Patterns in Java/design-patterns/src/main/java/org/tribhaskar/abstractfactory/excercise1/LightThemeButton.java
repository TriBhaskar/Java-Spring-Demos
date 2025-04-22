package org.tribhaskar.abstractfactory.excercise1;

public class LightThemeButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a button in light theme");
    }
}
