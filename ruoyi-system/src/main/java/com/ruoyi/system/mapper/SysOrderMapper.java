package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.SysOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysOrderMapper extends BaseMapper<SysOrder> {
    // 插入新订单

    public int insertOrder(SysOrder order);

    // 更新订单状态
    public int updateOrder(SysOrder order);

    // 根据ID查询订单
    public SysOrder selectOrderById(Long orderId);

    // 查询订单列表
    public List<SysOrder> selectOrderList(SysOrder order);

    public List<SysOrder> selectOrderAll(String orderIds);

    //删除订单
    public int deleteOrderByIds(Long[] ids);
}
