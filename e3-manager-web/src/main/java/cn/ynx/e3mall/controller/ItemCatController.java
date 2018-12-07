package cn.ynx.e3mall.controller;

import cn.ynx.e3mall.common.pojo.EasyUITreeNode;
import cn.ynx.e3mall.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemCatController {

    @Resource
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(
            @RequestParam(name = "id" ,defaultValue = "0")Long parentId){
        //调用服务查询节点列表
        List<EasyUITreeNode> list = itemCatService.getCatList(parentId);
        return list;
    }

}
