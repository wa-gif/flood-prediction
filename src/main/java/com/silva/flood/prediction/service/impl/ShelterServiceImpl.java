package com.silva.flood.prediction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.silva.flood.prediction.enums.StateEnum;
import com.silva.flood.prediction.mapper.ShelterMapper;
import com.silva.flood.prediction.model.Shelter;
import com.silva.flood.prediction.model.resp.ShelterResp;
import com.silva.flood.prediction.service.ShelterService;
import jakarta.annotation.Resource;
import org.geotools.referencing.GeodeticCalculator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterServiceImpl extends MPJBaseServiceImpl<ShelterMapper, Shelter> implements ShelterService {
    @Resource
    private ShelterMapper shelterMapper;

    @Override
    public List<ShelterResp> list(String shelterName, double startLat, double startLon) {
        LambdaQueryWrapper<Shelter> wrapper = new LambdaQueryWrapper<Shelter>()
                .eq(!ObjectUtils.isEmpty(shelterName), Shelter::getShelterName, shelterName)
                .eq(Shelter::getState, StateEnum.STATE_NORMAL.getCode());
        List<Shelter> sheltersList = shelterMapper.selectList(wrapper);
        List<ShelterResp> sheltersResps = sheltersList.stream().map(shelters -> new ShelterResp().setId(shelters.getId())
                .setAddress(shelters.getAddress())
                .setState(shelters.getState())
                .setShelterName(shelters.getShelterName())
                .setCall(shelters.getCall())
                .setDistance(calculateDistance(startLat, startLon, shelters.getLat(), shelters.getLon()))
        ).toList();
        return sheltersResps;
    }

    private double calculateDistance(double startLat, double startLon, double destinationLat, double destinationLon) {
        GeodeticCalculator calculator = new GeodeticCalculator();
        calculator.setStartingGeographicPoint(startLon, startLat);
        calculator.setDestinationGeographicPoint(destinationLon, destinationLat);
        return calculator.getOrthodromicDistance() / 1000;
    }

}
