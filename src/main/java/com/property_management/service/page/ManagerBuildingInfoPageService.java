package com.property_management.service.page;


import com.property_management.pojo.BuildingInfo;

import java.util.List;

public interface ManagerBuildingInfoPageService {

    /**
     * 实现分页查询返回
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<BuildingInfo> getBuildingInfoByPage(int pageNo, int pageSize);

    /**
     * 通过页码计算当前行号
     * @param pageNo
     * @return
     */
    int getStartLineNo(int pageNo);

    /**
     * 计算总页数
     * @param pageSize 每页的大小
     * @return
     */
    int getPageNumber(int pageSize);
}
