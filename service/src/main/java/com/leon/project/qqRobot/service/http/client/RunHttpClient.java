package com.leon.project.qqRobot.service.http.client;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Get;
import com.leon.project.qqRobot.service.http.address.QQAddressSource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Address(source = QQAddressSource.class)
public interface RunHttpClient {
    @Get("/run")
    Map toRun();

    @Get("/count")
    Map count();
}
