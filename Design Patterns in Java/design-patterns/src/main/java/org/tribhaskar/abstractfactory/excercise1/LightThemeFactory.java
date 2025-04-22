package org.tribhaskar.abstractfactory.excercise1;

public class LightThemeFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new LightThemeButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new LightThemeCheckBox();
    }
}
