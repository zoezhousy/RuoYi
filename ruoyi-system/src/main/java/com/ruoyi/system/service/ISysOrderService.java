package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysOrder;

import java.util.List;

public interface ISysOrderService {
    // 新增订单
    public int addOrder(SysOrder order);
    //更新订单
    public int updateOrder(SysOrder order);

    // 查询订单
    public SysOrder selectOrderById(Long orderId);


    // 批量查询订单
    public List<SysOrder> selectOrderList(SysOrder order);

    public List<SysOrder> selectOrderAll(String orderIds);

    // 删除订单

    public int deleteOrderByIds(String orderIds);
}
