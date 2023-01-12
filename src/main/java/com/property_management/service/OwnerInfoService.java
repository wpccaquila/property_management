package com.property_management.service;


import com.property_management.pojo.OwnerInfo;

import java.util.List;


public interface OwnerInfoService {
     void addOwner(OwnerInfo ownerInfo);
     List<OwnerInfo> queryOwnerByName(String ownerName);
     OwnerInfo queryOwnerById(int ownerId);
     List<OwnerInfo> queryAllOwner();
     int updataOwnerById(OwnerInfo ownerInfo);
     int deleteOwnerById(int ownerId);
}
