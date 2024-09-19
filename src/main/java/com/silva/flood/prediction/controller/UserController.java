package com.silva.flood.prediction.controller;

import com.silva.flood.prediction.model.req.EmergencyContactReq;
import com.silva.flood.prediction.model.req.MedicalCardReq;
import com.silva.flood.prediction.model.resp.AccountResp;
import com.silva.flood.prediction.model.resp.EmergencyContactResp;
import com.silva.flood.prediction.model.resp.MedicalCardResp;
import com.silva.flood.prediction.service.UserInfoService;
import com.silva.flood.prediction.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/medical-card/{userId}")
    public Result<MedicalCardResp> getMedicalCard(@PathVariable(value = "userId") Long userId) {
        MedicalCardResp medicalCard = userInfoService.getMedicalCardByUserId(userId);
        return Result.ok(medicalCard);
    }

    @PutMapping("/medical-card/{userId}")
    public Result<Void> editMedicalCard(@PathVariable(value = "userId") Long userId
            , @RequestBody MedicalCardReq medicalCardReq) {
        userInfoService.editMedicalCard(userId, medicalCardReq);
        return Result.ok();
    }

    @GetMapping("/emergency-contact/{userId}")
    public Result<List<EmergencyContactResp>> emergencyContactList(@PathVariable(value = "userId") Long userId) {
        List<EmergencyContactResp> emergencyContactResps = userInfoService.emergencyContactList(userId);
        return Result.ok(emergencyContactResps);
    }

    @PutMapping("/emergency-contact/{userId}")
    public Result<Void> editEmergencyContact(@PathVariable(value = "userId") Long userId
            , @RequestBody EmergencyContactReq emergencyContactReq) {
        userInfoService.editEmergencyContact(userId, emergencyContactReq);
        return Result.ok();
    }

    @GetMapping("/account/{userId}")
    public Result<AccountResp> getAccount(@PathVariable(value = "userId") Long userId) {
        AccountResp account = userInfoService.getAccountByUserId(userId);
        return Result.ok(account);
    }
}
