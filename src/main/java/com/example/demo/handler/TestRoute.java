package com.example.demo.handler;

import com.shimao.iot.udp.route.UdpRoute;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author steel
 * @datetime 2023/6/13 15:11
 */
@Component
public class TestRoute implements UdpRoute {
    @Override
    public Map<String, String> route() {
        Map<String, String> map = new HashMap<>();
        map.put("group-4", "224.1.1.4:9000");
        return map;
    }
}
