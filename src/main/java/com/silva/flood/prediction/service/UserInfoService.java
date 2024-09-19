package com.silva.flood.prediction.service;

import com.github.yulichang.base.MPJBaseService;
import com.silva.flood.prediction.model.UserInfo;
import com.silva.flood.prediction.model.req.EmergencyContactReq;
import com.silva.flood.prediction.model.req.MedicalCardReq;
import com.silva.flood.prediction.model.resp.AccountResp;
import com.silva.flood.prediction.model.resp.EmergencyContactResp;
import com.silva.flood.prediction.model.resp.MedicalCardResp;

import java.util.List;

public interface UserInfoService extends MPJBaseService<UserInfo> {
    MedicalCardResp getMedicalCardByUserId(Long userId);

    void editMedicalCard(Long userId, MedicalCardReq medicalCardReq);

    List<EmergencyContactResp> emergencyContactList(Long userId);

    void editEmergencyContact(Long userId, EmergencyContactReq emergencyContactReq);

    AccountResp getAccountByUserId(Long userId);
}
