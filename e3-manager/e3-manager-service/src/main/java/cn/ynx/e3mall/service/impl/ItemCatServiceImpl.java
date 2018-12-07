package cn.ynx.e3mall.service.impl;


import cn.ynx.e3mall.common.pojo.EasyUITreeNode;
import cn.ynx.e3mall.mapper.TbItemCatMapper;
import cn.ynx.e3mall.pojo.TbItemCat;
import cn.ynx.e3mall.pojo.TbItemCatExample;
import cn.ynx.e3mall.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> getCatList(long parentId) {
        //根据parentId查询子节点列表
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        //创建返回结果List
        List<EasyUITreeNode> resultList = new ArrayList<>();
        //把列表转换成EasyUITreeNode列表
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            //设置属性
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            //添加到结果列表
            resultList.add(node);
        }
        //返回结果
        return resultList;
    }

}
