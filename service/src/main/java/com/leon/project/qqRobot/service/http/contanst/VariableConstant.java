package com.leon.project.qqRobot.service.http.contanst;

public interface VariableConstant {
    interface Param {
        String ADDRESS = "address";
        String LOCATION = "location";
        String MSG = "msg";
    }

    interface ResponseParser {
        String DATA = "data";

        String CONTENT = "content";
        /**
         * 经度
         */
        String GEO_CODER_LNG = "result.location.lng";
        /**
         * 纬度
         */
        String GEO_CODER_LAT = "result.location.lat";

        /**
         * 和风天气
         */
        String NOW = "now";
        String DAILY = "daily";
        String WARNING = "warning";
    }
}
