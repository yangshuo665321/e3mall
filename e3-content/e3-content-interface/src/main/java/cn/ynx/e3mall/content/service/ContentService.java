package cn.ynx.e3mall.content.service;

import cn.ynx.e3mall.common.pojo.EasyUIDataGridResult;
import cn.ynx.e3mall.common.utils.E3Result;
import cn.ynx.e3mall.pojo.TbContent;

public interface ContentService {

    EasyUIDataGridResult getContentList(long categoryId, int page, int rows);
    E3Result addContent(TbContent content);

}
