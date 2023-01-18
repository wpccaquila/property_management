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
}
