package com.silva.flood.prediction.controller;

import com.silva.flood.prediction.model.resp.NewsResp;
import com.silva.flood.prediction.model.resp.ShelterResp;
import com.silva.flood.prediction.service.ShelterService;
import com.silva.flood.prediction.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/shelter")
public class ShelterController {
    @Resource
    private ShelterService shelterService;

    @GetMapping("/list")
    public Result<List<ShelterResp>> list(@RequestParam(value = "startLat") double startLat
            , @RequestParam(value = "startLon") double startLon
            , @RequestParam(value = "shelterName", required = false) String shelterName) {
        List<ShelterResp> shelterResps = shelterService.list(shelterName, startLat, startLon);
        return Result.ok(shelterResps);
    }

}
