package com.example.property_management.service;


import com.example.property_management.pojo.OwnerInfo;

import java.util.List;


public interface OwnerInfoService {
     void addOwner(OwnerInfo ownerInfo);
     OwnerInfo queryOwnerByName(String ownerName);
     OwnerInfo queryOwnerById(int ownerId);
     List<OwnerInfo> queryAllOwner();
     int updataOwnerById(OwnerInfo ownerInfo);
     int deleteOwnerById(int ownerId);
}
