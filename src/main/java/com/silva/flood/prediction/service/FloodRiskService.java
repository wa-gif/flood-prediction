package com.silva.flood.prediction.service;

import com.silva.flood.prediction.model.resp.RiskLevelResp;

public interface FloodRiskService {
    RiskLevelResp getRiskLevel(String city);
}
