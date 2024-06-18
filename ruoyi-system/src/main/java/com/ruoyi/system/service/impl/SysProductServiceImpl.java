package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.domain.SysProduct;
import com.ruoyi.system.mapper.SysOrderMapper;
import com.ruoyi.system.mapper.SysProductMapper;
import com.ruoyi.system.service.ISysOrderService;
import com.ruoyi.system.service.ISysProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysProductServiceImpl implements ISysProductService {
    @Autowired
    private SysProductMapper productMapper;

    @Override
    public int addProduct(SysProduct sysProduct) {
//        return productMapper.insertProduct(sysProduct);
        return productMapper.insert(sysProduct);
    }

    @Override
    public int updateProduct(SysProduct sysProduct) {
//        return productMapper.updateProduct(sysProduct);
        return productMapper.updateById(sysProduct);
    }

    @Override
    public SysProduct selectProductById(Long productId) {
        return productMapper.selectProductById(productId);
    }

    @Override
    public List<SysProduct> selectProductList(SysProduct sysProduct) {
        return productMapper.selectProductList(sysProduct);
    }

    @Override
    public List<SysProduct> selectProductAll(String productIds) {
        return productMapper.selectProductAll(productIds);
    }

    @Override
    public int deleteProductByIds(String productIds) {
        Long[] ids = Convert.toLongArray(productIds);
//        return productMapper.deleteProductByIds(ids);
        return productMapper.deleteById(ids);
    }

}
