package com.leon.project.qqRobot.service.http.client.appService;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;
import com.leon.project.qqRobot.service.http.contanst.UrlConstant;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CommonUtilHttpClient {
    /**
     * https://api.map.baidu.com/geocoder?address=西安市长安区&output=json
     * {"status":"OK","result":{"location":{"lng":108.91358,"lat":34.16329},"precise":0,"confidence":20,"level":"区县"}}
     * @param address
     * @return
     */
    @Get(value = UrlConstant.BAIDU_GEOCODER)
    Map getGeoCoder(@Query(VariableConstant.Param.ADDRESS) String address);

    @Get(value = UrlConstant.ROBOT_CHAT)
    Map getReplay(@Query(VariableConstant.Param.MSG) String msg);
}
