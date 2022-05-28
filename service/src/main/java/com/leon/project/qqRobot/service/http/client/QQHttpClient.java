package com.leon.project.qqRobot.service.http.client;

import com.dtflys.forest.annotation.*;
import com.leon.project.qqRobot.service.http.model.req.SendMsg;
import com.leon.project.qqRobot.service.http.QQAddressSource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Address(source = QQAddressSource.class)
public interface QQHttpClient {

    @Post("/send_msg")
    Map sendPrivateMsg(@JSONBody SendMsg sendMsg);

    @Post("/send_group_msg")
    Map sendGroupMsg(@JSONBody SendMsg sendMsg);

    @Post("/get_stranger_info")
    Map getQQInfo(@JSONBody("user_id") String qq);

    @Post("/set_friend_add_request")
    Map approveFriendRequest(@JSONBody("flag") String flag, @JSONBody("approve") Boolean approve);
}
