package com.fbi.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Override
    public People query(People people) {
        LambdaQueryWrapper<People> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(people.getPName()), People::getPName, people.getPName())
                .eq(people.getPAge() != null, People::getPAge, people.getPAge());
        return peopleMapper.selectList(wrapper).get(0);
    }
}
