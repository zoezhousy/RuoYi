package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.domain.SysProduct;

import java.util.List;

public interface ISysProductService {
    // 新增商品
    public int addProduct(SysProduct sysProduct);
    // 更新商品
    public int updateProduct(SysProduct sysProduct);

    // 查询商品
    public SysProduct selectProductById(Long productId);


    // 批量查询商品
    public List<SysProduct> selectProductList(SysProduct sysProduct);

    public List<SysProduct> selectProductAll(String productIds);

    // 删除商品
    public int deleteProductByIds(String productIds);
}
