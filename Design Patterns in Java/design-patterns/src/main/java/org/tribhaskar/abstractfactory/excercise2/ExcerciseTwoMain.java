package org.tribhaskar.abstractfactory.excercise2;

public class ExcerciseTwoMain {
    public static void main(String[] args) {
        Cloud cloud = new AWSFactory();
        Compute awsCompute = cloud.createCompute();
        Storage awsStorage = cloud.createStorage();

        awsCompute.compute();
        awsStorage.store();

        cloud = new AzureFactory();
        Compute azureCompute = cloud.createCompute();
        Storage azureStorage = cloud.createStorage();
        azureCompute.compute();
        azureStorage.store();

        cloud = new GCPFactory();
        Compute gcpCompute = cloud.createCompute();
        Storage gcpStorage = cloud.createStorage();
        gcpCompute.compute();
        gcpStorage.store();



    }
}
