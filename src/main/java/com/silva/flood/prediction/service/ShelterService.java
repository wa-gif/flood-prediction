package com.silva.flood.prediction.service;

import com.github.yulichang.base.MPJBaseService;
import com.silva.flood.prediction.model.News;
import com.silva.flood.prediction.model.Shelter;
import com.silva.flood.prediction.model.resp.NewsResp;
import com.silva.flood.prediction.model.resp.ShelterResp;

import java.util.List;

public interface ShelterService extends MPJBaseService<Shelter> {
    List<ShelterResp> list(String shelterName, double startLat, double startLon);
}
