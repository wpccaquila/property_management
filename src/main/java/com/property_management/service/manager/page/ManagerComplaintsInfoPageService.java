package com.property_management.service.manager.page;

import com.property_management.pojo.ComplaintsInfo;
import com.property_management.pojo.HouseholdInfo;

import java.util.List;

/**
 * 使用PageHelper 插件实现分页功能
 */
public interface ManagerComplaintsInfoPageService {

    /**
     * 实现分页查询返回
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<ComplaintsInfo> getComplaintsInfoByPage(int pageNo, int pageSize);

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
