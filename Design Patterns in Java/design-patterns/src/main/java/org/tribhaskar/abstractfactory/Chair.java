package org.tribhaskar.abstractfactory;

/**
 * Abstract Chair product interface
 * Defines methods that all chair variants must implement
 */
public interface Chair {
    /**
     * Returns the style of the chair
     * @return String representing the chair style
     */
    String getStyle();

    /**
     * Returns whether the chair has legs
     * @return boolean indicating if the chair has legs
     */
    boolean hasLegs();

    /**
     * Allows a user to sit on the chair
     * @return String describing the sitting experience
     */
    String sitOn();
}

