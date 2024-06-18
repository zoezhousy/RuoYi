package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.domain.SysProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysProductMapper extends BaseMapper<SysProduct> {
    // 插入新订单

    public int insertProduct(SysProduct sysProduct);

    // 更新订单状态
    public int updateProduct(SysProduct sysProduct);

    // 根据ID查询订单
    public SysProduct selectProductById(Long productId);

    // 查询订单列表
    public List<SysProduct> selectProductList(SysProduct sysProduct);

    public List<SysProduct> selectProductAll(String productIds);

    //删除订单
    public int deleteProductByIds(Long[] ids);
}
