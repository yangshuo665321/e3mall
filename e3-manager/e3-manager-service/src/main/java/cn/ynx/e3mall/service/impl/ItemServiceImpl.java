package cn.ynx.e3mall.service.impl;

import cn.ynx.e3mall.common.pojo.EasyUIDataGridResult;
import cn.ynx.e3mall.mapper.TbItemMapper;
import cn.ynx.e3mall.pojo.TbItem;
import cn.ynx.e3mall.pojo.TbItemExample;
import cn.ynx.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper tbItemMapper;

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

}
