package org.tribhaskar.abstractfactory.excercise1;

public class DarkThemeFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new DarkThemeCheckBox();
    }
}
