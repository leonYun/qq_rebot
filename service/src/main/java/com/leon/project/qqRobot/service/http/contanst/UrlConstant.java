package com.leon.project.qqRobot.service.http.contanst;

public interface UrlConstant {
    /**
     * 根据地址生成经纬度
     */
    String BAIDU_GEOCODER = "https://api.map.baidu.com/geocoder?output=json";

    /**
     * 根据关键词回复
     */
    String ROBOT_CHAT = "http://api.qingyunke.com/api.php?key=free&appid=0";

    interface HEFENG_WEATHER {
        String APP_ID = "f6733993fa71455e98c8e79d4c7b3e83";
        String CURRENT_WEATHER = "https://devapi.qweather.com/v7/weather/now?" + "key=" + APP_ID;
        String LIFE_INDICES = "https://devapi.qweather.com/v7/indices/1d?type=0&" + "key=" + APP_ID ;
        String WEATHER_WARING = "https://devapi.qweather.com/v7/warning/now?" + "key=" + APP_ID;
    }

}
