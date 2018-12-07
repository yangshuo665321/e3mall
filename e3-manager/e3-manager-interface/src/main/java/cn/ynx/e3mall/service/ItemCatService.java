package cn.ynx.e3mall.service;

import cn.ynx.e3mall.common.pojo.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {

    List<EasyUITreeNode> getCatList(long parentId);

}
