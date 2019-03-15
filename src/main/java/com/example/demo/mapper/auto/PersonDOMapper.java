package com.example.demo.mapper.auto;

import com.example.demo.entity.auto.PersonDO;
import com.example.demo.entity.auto.PersonDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonDOMapper {
    int countByExample(PersonDOExample example);

    int deleteByExample(PersonDOExample example);

    int insert(PersonDO record);

    int insertSelective(PersonDO record);

    List<PersonDO> selectByExample(PersonDOExample example);

    int updateByExampleSelective(@Param("record") PersonDO record, @Param("example") PersonDOExample example);

    int updateByExample(@Param("record") PersonDO record, @Param("example") PersonDOExample example);
}