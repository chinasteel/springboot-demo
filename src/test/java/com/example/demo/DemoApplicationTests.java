package com.example.demo;

import com.example.demo.entity.auto.PersonDO;
import com.shimao.iot.udp.UdpClient;
import com.shimao.iot.udp.dto.UdpMessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UdpClient udpClient;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendData() throws InterruptedException {
        PersonDO personDO = new PersonDO();
        personDO.setName("steel");
        udpClient.sendData("group-3", UdpMessageDTO.builder()
                .bizCode("test")
                .timestamp(System.currentTimeMillis())
                .dataType("object")
                .reqId("93jfjfdls")
                .sysCode("yzs")
                .version("v1.0.0")
                .body(personDO).build());

        for (int i = 2; i < 10; i++) {
//            Thread.sleep(1000);
            personDO = new PersonDO();
            personDO.setName("steel" + i);
            udpClient.sendData("group-1", UdpMessageDTO.builder()
                    .bizCode("test").timestamp(System.currentTimeMillis())
                    .dataType("object")
                    .reqId("93jfjfdls")
                    .sysCode("yzs")
                    .version("v1.0.0")
                    .body(personDO).build());
        }

        personDO.setName("steel");
        udpClient.sendData("group-4", UdpMessageDTO.builder()
                .bizCode("test2")
                .timestamp(System.currentTimeMillis())
                .dataType("object")
                .reqId("93jfjfdlsxxxxxxx")
                .sysCode("yzs")
                .version("v1.0.0")
                .body(personDO).build());

        Thread.sleep(5000);
    }

}
