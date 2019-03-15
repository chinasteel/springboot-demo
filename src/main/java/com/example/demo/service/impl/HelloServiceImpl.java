package com.example.demo.service.impl;

import com.example.demo.entity.auto.PersonDO;
import com.example.demo.entity.auto.PersonDOExample;
import com.example.demo.mapper.auto.PersonDOMapper;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final PersonDOMapper personDOMapper;

    @Autowired
    public HelloServiceImpl(PersonDOMapper personDOMapper) {
        this.personDOMapper = personDOMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDO getPerson(PersonDO personDO) {
        PersonDOExample personDOExample = new PersonDOExample();
        personDOExample.createCriteria().andNameEqualTo(personDO.getName());

        List<PersonDO> personDOList = personDOMapper.selectByExample(personDOExample);
        return personDOList.get(0);
    }
}
