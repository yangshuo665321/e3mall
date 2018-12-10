package cn.ynx.e3mall.service;

import cn.ynx.e3mall.common.pojo.EasyUIDataGridResult;
import cn.ynx.e3mall.common.utils.E3Result;
import cn.ynx.e3mall.pojo.TbItem;

public interface ItemService {

    TbItem getTbItemById(Long itemId);
    EasyUIDataGridResult getTbItemList(int page, int rows);
    E3Result addItem(TbItem tbItem, String desc);

}
