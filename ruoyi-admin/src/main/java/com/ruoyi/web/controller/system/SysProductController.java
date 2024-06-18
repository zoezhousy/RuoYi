package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.domain.SysProduct;
import com.ruoyi.system.service.ISysOrderService;
import com.ruoyi.system.service.ISysProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/product")
public class SysProductController extends BaseController {
    private final String prefix = "system/product";
    @Autowired
    private ISysProductService productService;

    // 订单
    @GetMapping("/view")
    public String view(){
        return prefix + "/product";
    }

    // 添加订单
    @GetMapping("/add")
    public String add(){return prefix + "/add";}

    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysProduct sysProduct) {
//        sysOrder.setCreateBy(getLoginName());
//        sysOrder.setCreateTime(DateUtils.getNowDate());
        return toAjax(productService.addProduct(sysProduct));
    }


    // 更新订单状态
    @GetMapping("/edit/{productId}")
    public String edit(@PathVariable("productId") Long productId, ModelMap mmap) {
        mmap.put("product", productService.selectProductById(productId));
        return prefix + "/edit";
    }

    //更新保存订单
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysProduct sysProduct){
//        sysOrder.setUpdateBy(getLoginName());
        return toAjax(productService.updateProduct(sysProduct));
    }

    // 根据ID获取订单
    @GetMapping("/{productId}")
    public AjaxResult select(@PathVariable Long productId) {
        try {
            SysProduct sysProduct = productService.selectProductById(productId);
            return AjaxResult.success(sysProduct);
        } catch (Exception e) {
            return AjaxResult.error("Error retrieving prouct: " + e.getMessage());
        }
    }

    /**
     * 查询订单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysProduct sysProduct)
    {
        startPage();
        List<SysProduct> list = productService.selectProductList(sysProduct);
        return getDataTable(list);
    }


    // 根据ID删除
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(productService.deleteProductByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }

    }


}