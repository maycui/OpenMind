package com.example.mayc.openmind;

/**
 * Created by mayc on 7/12/17.
 */

class Secrets {
    private String user;
    private String password;
    private String environmentID;
    private String collectionID;
    private String configurationID;

    Secrets() {
        user = "a5272bfb-de6f-4401-8867-b27555808b6e";
        password = "nfbb3ZB6Zal0";
        environmentID = "d83ace81-1722-4566-bd55-47417607f2b1";
        collectionID = "789640cf-7e1a-4f21-bc88-4c0e7f4824a0";
        configurationID = "b9065fbb-2171-4e30-ad16-5e2950f1f4ff";
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getEnvironmentID() {
        return environmentID;
    }

    public String getCollectionID() {
        return collectionID;
    }

    public String getConfigurationID() {
        return configurationID;
    }
}
