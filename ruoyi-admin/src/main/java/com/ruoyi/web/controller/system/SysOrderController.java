package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.system.domain.SysOrder;
import com.ruoyi.system.service.ISysOrderService;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/order")
public class SysOrderController extends BaseController {
    private final String prefix = "system/order";
    @Autowired
    private ISysOrderService orderService;

    // 订单
    @GetMapping("/view")
    public String view(){
        return prefix + "/order";
    }

    // 添加订单
    @GetMapping("/add")
    public String add(){return prefix + "/add";}

    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysOrder order) {
        order.setCreateBy(getLoginName());
        order.setCreateTime(DateUtils.getNowDate());
        return toAjax(orderService.addOrder(order));
    }


    // 更新订单状态
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap) {
        mmap.put("order", orderService.selectOrderById(orderId));
        return prefix + "/edit";
    }

    //更新保存订单
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysOrder order){
        order.setUpdateBy(getLoginName());
        return toAjax(orderService.updateOrder(order));
    }

    // 根据ID获取订单
    @GetMapping("/{orderId}")
    public AjaxResult select(@PathVariable Long orderId) {
        try {
            SysOrder order = orderService.selectOrderById(orderId);
            return AjaxResult.success(order);
        } catch (Exception e) {
            return AjaxResult.error("Error retrieving order: " + e.getMessage());
        }
    }

    /**
     * 查询订单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOrder order)
    {
        startPage();
        List<SysOrder> list = orderService.selectOrderList(order);
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
            return toAjax(orderService.deleteOrderByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }

    }


}