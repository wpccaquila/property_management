package com.property_management;

import com.property_management.pojo.HouseInfo;
import com.property_management.service.HouseInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class HouseTests {
    @Resource
    HouseInfoService houseInfoService;

    @Test
    public void A(){
        List<HouseInfo> list=houseInfoService.queryAllHouseInfo();
        list.forEach(houseInfo1 -> System.out.println(houseInfo1));
    }

    @Test
    public void B(){
        int num = houseInfoService.insertHouseInfo(new HouseInfo("5幢","安置房",152.1, 301,1));
        System.out.println(num);
    }

    @Test
    public void B1(){
        houseInfoService.updateHouseInfo(
                new HouseInfo(1,"5幢","高端房",152.1, 301,1));
    }

}
