package com.property_management;

import com.property_management.pojo.OwnerInfo;
import com.property_management.service.OwnerInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PropertyManagementApplicationTests {
    @Resource
    OwnerInfoService ownerInfoService;

    @Test
    public void addOwnerTest(){
        ownerInfoService.addOwner(new OwnerInfo("小李",13756875,"锦南7幢","123456",2,"业主"));
        System.out.println("添加成功");
    }

    @Test
    public void queryOwnerTest(){
        List<OwnerInfo> list = ownerInfoService.queryOwnerByName("王鹏程");
        list.forEach(ownerInfo -> System.out.println(ownerInfo));
    }
//
    @Test
    public void queryOwnerByIdTest1(){
        OwnerInfo ownerInfo = ownerInfoService.queryOwnerById(1);
        System.out.println(ownerInfo.toString());
    }

    @Test
    public void queryAllOwnerTest(){
        List<OwnerInfo> list =  ownerInfoService.queryAllOwner();
        for (OwnerInfo o : list){
            System.out.println(o);
        }
    }
    @Test
    public void updataTest(){
        int num = ownerInfoService.updataOwnerById(new OwnerInfo(2,"小仙女",13756875,"锦南7幢","123456",2,"租客"));
        System.out.println("返回值为：" + num);
    }

    @Test
    public void deleteTest(){
        int num = ownerInfoService.deleteOwnerById(2);
        System.out.println("返回值为：" + num);
    }


}
