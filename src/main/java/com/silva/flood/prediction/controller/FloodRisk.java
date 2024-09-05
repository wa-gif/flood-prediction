package com.silva.flood.prediction.controller;

import com.silva.flood.prediction.model.resp.RiskLevelResp;
import com.silva.flood.prediction.service.FloodRiskService;
import com.silva.flood.prediction.utils.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
@RequestMapping("/flood-risk")
public class FloodRisk {
    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @Resource
    private FloodRiskService floodRiskService;

    @GetMapping("/risk-level")
    public Result<RiskLevelResp> getRiskLevel(@RequestParam(value = "city") String city) {



        return Result.ok();
    }
}
