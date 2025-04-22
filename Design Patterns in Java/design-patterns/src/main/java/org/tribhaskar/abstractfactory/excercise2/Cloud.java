package org.tribhaskar.abstractfactory.excercise2;

public interface Cloud {
    Storage createStorage();
    Compute createCompute();
}
