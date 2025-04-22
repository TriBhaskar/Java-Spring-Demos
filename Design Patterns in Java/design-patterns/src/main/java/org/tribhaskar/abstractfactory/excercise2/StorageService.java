package org.tribhaskar.abstractfactory.excercise2;

public class StorageService implements Storage{
    @Override
    public void store() {
        System.out.println("Storage service is running");
    }
}
