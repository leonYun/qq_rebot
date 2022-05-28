package com.leon.project.qqRobot.service.http;

import com.dtflys.forest.callback.AddressSource;
import com.dtflys.forest.http.ForestAddress;
import com.dtflys.forest.http.ForestRequest;

public class QQAddressSource implements AddressSource {
    @Override
    public ForestAddress getAddress(ForestRequest req) {
        return new ForestAddress("127.0.0.1", 9000);
    }
}
