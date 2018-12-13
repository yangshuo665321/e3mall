package cn.ynx.e3mall.content.service;

import cn.ynx.e3mall.common.pojo.EasyUITreeNode;
import cn.ynx.e3mall.common.utils.E3Result;

import java.util.List;

public interface ContentCategoryService {

    List<EasyUITreeNode> getContentCategoryList(long parentId);
    E3Result addContentCategory(long parentId, String name);

}
