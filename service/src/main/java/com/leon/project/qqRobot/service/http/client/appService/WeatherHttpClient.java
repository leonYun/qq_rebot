package com.leon.project.qqRobot.service.http.client.appService;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;
import com.leon.project.qqRobot.service.http.contanst.UrlConstant;
import com.leon.project.qqRobot.service.http.contanst.VariableConstant;
import com.leon.project.qqRobot.service.http.interceptor.HefengWeatherInterceptor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@BaseRequest(interceptor = HefengWeatherInterceptor.class)
public interface WeatherHttpClient {
    /**
     * {"code":"200","updateTime":"2022-05-04T08:52+08:00","fxLink":"http://hfx.link/2ax1","now":{"obsTime":"2022-05-04T08:46+08:00","temp":"21","feelsLike":"20","icon":"101","text":"多云","wind360":"180","windDir":"南风","windScale":"2","windSpeed":"7","humidity":"50","precip":"0.0","pressure":"1002","vis":"16","cloud":"91","dew":"8"},"refer":{"sources":["QWeather","NMC","ECMWF"],"license":["no commercial use"]}}
     * @param address
     * @return
     */
    @Get(UrlConstant.HEFENG_WEATHER.CURRENT_WEATHER)
    Map getHefengWeatherCurrentWeather(@Query(VariableConstant.Param.ADDRESS) String address);

    /**
     * {"code":"200","updateTime":"2021-12-16T18:35+08:00","fxLink":"http://hfx.link/2ax2","daily":[{"date":"2021-12-16","type":"1","name":"运动指数","level":"3","category":"较不宜","text":"天气较好，但考虑天气寒冷，风力较强，推荐您进行室内运动，若户外运动请注意保暖并做好准备活动。"},{"date":"2021-12-16","type":"2","name":"洗车指数","level":"3","category":"较不宜","text":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"}],"refer":{"sources":["QWeather"],"license":["commercial license"]}}
     * @param address
     * @return
     */
    @Get(UrlConstant.HEFENG_WEATHER.LIFE_INDICES)
    Map getHefengDailyIndices(@Query(VariableConstant.Param.ADDRESS) String address);

    /**
     * {"code":"200","updateTime":"2021-10-10T12:20+08:00","fxLink":"http://hfx.link/2ax5","warning":[{"id":"10101010020211009154607668935939","sender":"北京市气象局","pubTime":"2021-10-09T15:46+08:00","title":"北京市气象台2021年10月09日15时40分发布大风蓝色预警信号","startTime":"2021-10-09T15:40+08:00","endTime":"2021-10-10T15:40+08:00","status":"active","level":"蓝色","type":"11B06","typeName":"大风","text":"市气象台2021年10月9日15时40分发布大风蓝色预警信号：预计，9日22时至10日19时，本市大部分地区有4级左右偏北风，阵风6、7级，山区阵风可达8级左右，请注意防范。","related":""}],"refer":{"sources":["12379"],"license":["commercial license"]}}
     * @param address
     * @return
     */
    @Get(UrlConstant.HEFENG_WEATHER.WEATHER_WARING)
    Map getHefengWeatherWaring(@Query(VariableConstant.Param.ADDRESS) String address);
}
