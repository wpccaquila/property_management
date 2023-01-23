package com.property_management.service.manager.page;

import com.property_management.pojo.OwnerInfo;

import java.util.List;

/**
 * 使用PageHelper 插件实现分页功能
 */
public interface ManagerOwnerInformationPageService {

    /**
     * 分页查询用户信息表
     * @param pageNum 查询的页码
     * @param pageSize 每次返回多少行
     * @return
     */
     List<OwnerInfo> getOwnerInfoList(Integer pageNum, Integer pageSize);
    /**
     * 实现分页查询返回
     * @param pageNo
     * @param pageSize
     * @return
     */
     List<OwnerInfo> getOwnerInfoByPage(int pageNo, int pageSize);

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
