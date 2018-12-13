package cn.ynx.e3mall.controller;

import cn.ynx.e3mall.common.pojo.EasyUITreeNode;
import cn.ynx.e3mall.common.utils.E3Result;
import cn.ynx.e3mall.content.service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Resource
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(
            @RequestParam(value="id", defaultValue="0") Long parentId) {
        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public E3Result createContentCategory(Long parentId, String name){
        E3Result result = contentCategoryService.addContentCategory(parentId, name);
        return result;
    }

}
