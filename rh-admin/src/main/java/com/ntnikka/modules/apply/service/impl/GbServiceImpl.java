package com.ntnikka.modules.apply.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ntnikka.modules.apply.dao.GbDao;
import com.ntnikka.modules.apply.entity.GbEntity;
import com.ntnikka.modules.apply.service.GbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luk
 * @create 2018-04-04 14:44
 * @desc GbService实现类
 **/
@Service("GbService")
public class GbServiceImpl extends ServiceImpl<GbDao, GbEntity> implements GbService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(GbEntity gb) {
        this.insert(gb);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(GbEntity gb) {
        this.updateById(gb);
    }

}
