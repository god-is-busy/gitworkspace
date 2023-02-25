package com.fbi.service.impl;

import com.fbi.domain.People;
import com.fbi.mapper.PeopleMapper;
import com.fbi.service.PeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Generator
 * @since 2023-02-25
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Resource
    PeopleMapper peopleMapper;

    @Override
    public void create() {
        People people = new People();
        people.setPName("张三");
        people.setPAge(14);
        peopleMapper.insert(people);
    }
}
