package com.leon.project.qqRobot.service.http.address;

import com.dtflys.forest.callback.AddressSource;
import com.dtflys.forest.http.ForestAddress;
import com.dtflys.forest.http.ForestRequest;

public class RunAddressSource implements AddressSource {
    @Override
    public ForestAddress getAddress(ForestRequest req) {
        return new ForestAddress("127.0.0.1", 8000);
    }
}
