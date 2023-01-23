package com.property_management.service.common;


import com.property_management.pojo.OwnerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OwnerInfoService {
     /**
      * 添加一个业主用户
      * @param ownerInfo
      * @return
      */
     int addOwner(OwnerInfo ownerInfo);

     /**
      * 通过名字查询
      * @param ownerName
      * @return
      */
     List<OwnerInfo> queryOwnerByName(String ownerName);

     /**
      * 返回表记录数
      * @return
      */
     int selectCount();


     /**
      * 通过ID号查询业主信息
      * @param ownerId
      * @return
      */
     OwnerInfo queryOwnerById(int ownerId);

     /**
      * 通过电话号码与密码查询业主信息
      * @param phone
      * @param password
      * @return
      */
     OwnerInfo queryOwnerByPhoneAndPassword(int phone, String password);

     /**
      * 查询所有业主信息
      * @return
      */
     List<OwnerInfo> queryAllOwner();

     /**
      * 通过id号，修改业主信息
      * @param ownerInfo
      * @return
      */
     int updateOwnerById(OwnerInfo ownerInfo);

     /**
      * 通过id号，删除业主
      * @param ownerId
      * @return
      */
     int deleteOwnerById(int ownerId);
}
