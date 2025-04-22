package org.tribhaskar.abstractfactory.excercise2;

public class GCPFactory implements Cloud{
    @Override
    public Storage createStorage() {
        return new StorageService();
    }

    @Override
    public Compute createCompute() {
        return new ComputeService();
    }
}
