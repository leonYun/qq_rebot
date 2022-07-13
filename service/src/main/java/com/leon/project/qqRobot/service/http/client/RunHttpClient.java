package com.leon.project.qqRobot.service.http.client;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Get;
import com.leon.project.qqRobot.service.http.address.RunAddressSource;
import org.springframework.stereotype.Service;


@Service
@Address(source = RunAddressSource.class)
public interface RunHttpClient {
    @Get("/run")
    String toRun();

    @Get("/count")
    String count();
}
