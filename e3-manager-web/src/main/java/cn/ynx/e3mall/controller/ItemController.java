package cn.ynx.e3mall.controller;

import cn.ynx.e3mall.common.pojo.EasyUIDataGridResult;
import cn.ynx.e3mall.common.utils.E3Result;
import cn.ynx.e3mall.pojo.TbItem;
import cn.ynx.e3mall.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem = itemService.getTbItemById(itemId);
        return tbItem;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getTbItemList(Integer page, Integer rows){
        EasyUIDataGridResult result = itemService.getTbItemList(page, rows);
        return result;
    }

    /**
     * 商品添加 Controller
     * @param item
     * @param desc
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addItem(TbItem item,String desc) {
        E3Result result = itemService.addItem(item, desc);
        return result;
    }

}
