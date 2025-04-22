package org.tribhaskar.abstractfactory.excercise1;

public class ExcerciseOneMain {
    public static void main(String[] args) {
        UIFactory factory = new DarkThemeFactory(); // Try LightThemeFactory too
        Button btn = factory.createButton();
        CheckBox chk = factory.createCheckBox();

        btn.paint();     // Output: Painting a dark-themed button
        chk.check();     // Output: Checking a dark-themed checkbox
    }
}
