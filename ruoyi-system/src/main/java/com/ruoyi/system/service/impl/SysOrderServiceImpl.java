package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.mapper.SysOrderMapper;
import com.ruoyi.system.service.ISysOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrderServiceImpl implements ISysOrderService {
    @Autowired
    private SysOrderMapper orderMapper;

    @Override
    public int addOrder(SysOrder order) {
//        return orderMapper.insertOrder(order);
        return orderMapper.insert(order);
    }

    @Override
    public int updateOrder(SysOrder order) {
//        return orderMapper.updateOrder(order);
        return orderMapper.updateById(order);
    }

    @Override
    public SysOrder selectOrderById(Long orderId) {
        return orderMapper.selectOrderById(orderId);
    }

    @Override
    public List<SysOrder> selectOrderList(SysOrder order) {
        return orderMapper.selectOrderList(order);
    }

    @Override
    public List<SysOrder> selectOrderAll(String orderIds) {
        return orderMapper.selectOrderAll(orderIds);
    }

    @Override
    public int deleteOrderByIds(String orderIds) {
        Long[] ids = Convert.toLongArray(orderIds);
//        return orderMapper.deleteOrderByIds(ids);
        return orderMapper.deleteById(ids);
    }

}
