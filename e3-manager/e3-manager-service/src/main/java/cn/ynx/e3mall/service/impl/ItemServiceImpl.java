package cn.ynx.e3mall.service.impl;

import cn.ynx.e3mall.common.pojo.EasyUIDataGridResult;
import cn.ynx.e3mall.common.utils.E3Result;
import cn.ynx.e3mall.common.utils.IDUtils;
import cn.ynx.e3mall.mapper.TbItemDescMapper;
import cn.ynx.e3mall.mapper.TbItemMapper;
import cn.ynx.e3mall.pojo.TbItem;
import cn.ynx.e3mall.pojo.TbItemDesc;
import cn.ynx.e3mall.pojo.TbItemExample;
import cn.ynx.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Resource
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItem getTbItemById(Long itemId) {
//        // 方法一：根据主键查询
//        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
//        return tbItem;

        //方法二：条件查询
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria  = example.createCriteria();
        //设置查询条件
        criteria.andIdEqualTo(itemId);
        //执行查询
        List<TbItem> list = tbItemMapper.selectByExample(example);
        if (list != null && list.size() > 0){
            return list.get(0);
        }
        return list.get(0);
    }

    @Override
    public EasyUIDataGridResult getTbItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);

        //创建返回结果对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(list);

        return result;
    }

    @Override
    public E3Result addItem(TbItem tbItem, String desc) {
        // 1、生成商品id
        long itemId = IDUtils.genItemId();
        // 2、补全TbItem对象的属性
        tbItem.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        tbItem.setStatus((byte) 1);
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        // 3、向商品表插入数据
        tbItemMapper.insert(tbItem);
        // 4、创建一个TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        // 5、补全TbItemDesc的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        // 6、向商品描述表插入数据
        tbItemDescMapper.insert(itemDesc);
        // 7、E3Result.ok()
        return E3Result.ok();
    }

}
