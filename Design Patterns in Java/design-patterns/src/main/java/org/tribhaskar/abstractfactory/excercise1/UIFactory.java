package org.tribhaskar.abstractfactory.excercise1;

public interface UIFactory {
    /**
     * Creates a button of the specific style
     * @return Button object of the factory's style
     */
    Button createButton();

    /**
     * Creates a checkbox of the specific style
     * @return CheckBox object of the factory's style
     */
    CheckBox createCheckBox();
}
