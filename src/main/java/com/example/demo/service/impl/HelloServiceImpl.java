package com.example.demo.service.impl;

import com.example.demo.entity.auto.PersonDO;
import com.example.demo.entity.auto.PersonDOExample;
import com.example.demo.mapper.auto.PersonDOMapper;
import com.example.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author steel
 * @datetime 2019/3/15 15:10
 */
@Service
@Transactional
public class HelloServiceImpl implements HelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    private final PersonDOMapper personDOMapper;
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public HelloServiceImpl(PersonDOMapper personDOMapper, RedisTemplate<String, String> redisTemplate) {
        this.personDOMapper = personDOMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDO getPerson(PersonDO personDO) {
        PersonDOExample personDOExample = new PersonDOExample();
        personDOExample.createCriteria().andNameEqualTo(personDO.getName());

        List<PersonDO> personDOList = personDOMapper.selectByExample(personDOExample);

        String value = redisTemplate.opsForValue().get("name");
        LOGGER.debug("get name value from redis is {}", value);
        return personDOList.get(0);
    }
}
