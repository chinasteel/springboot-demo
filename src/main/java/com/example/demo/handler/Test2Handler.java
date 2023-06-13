package com.example.demo.handler;

import com.alibaba.fastjson2.JSONObject;
import com.example.demo.entity.auto.PersonDO;
import com.shimao.iot.udp.dto.UdpMessageDTO;
import com.shimao.iot.udp.handler.UdpBizHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author steel
 * @datetime 2023/6/9 16:31
 */
@Component
@Slf4j
public class Test2Handler implements UdpBizHandler {

    @Override
    public String bizCode() {
        return "test2";
    }

    @Override
    public void process(UdpMessageDTO<?> udpMessageDTO) {
        log.info("receive data:{}", udpMessageDTO);
        PersonDO personDO = ((JSONObject) udpMessageDTO.getBody()).toJavaObject(PersonDO.class);
        log.info("the person name is {}", personDO.getName());
    }
}
