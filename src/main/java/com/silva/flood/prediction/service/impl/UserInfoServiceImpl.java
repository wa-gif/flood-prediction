package com.silva.flood.prediction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.silva.flood.prediction.enums.StateEnum;
import com.silva.flood.prediction.mapper.EmergencyContactMapper;
import com.silva.flood.prediction.mapper.UserInfoMapper;
import com.silva.flood.prediction.model.EmergencyContact;
import com.silva.flood.prediction.model.UserInfo;
import com.silva.flood.prediction.model.req.EmergencyContactReq;
import com.silva.flood.prediction.model.req.MedicalCardReq;
import com.silva.flood.prediction.model.resp.AccountResp;
import com.silva.flood.prediction.model.resp.EmergencyContactResp;
import com.silva.flood.prediction.model.resp.MedicalCardResp;
import com.silva.flood.prediction.service.EmergencyContactService;
import com.silva.flood.prediction.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl extends MPJBaseServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private EmergencyContactMapper emergencyContactMapper;

    @Resource
    private EmergencyContactService emergencyContactService;

    public MedicalCardResp getMedicalCardByUserId(Long userId) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getId, userId)
                .eq(UserInfo::getState, StateEnum.STATE_NORMAL.getCode());
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        return new MedicalCardResp().setId(userInfo.getId())
                .setFirstName(userInfo.getFirstName())
                .setLastName(userInfo.getLastName())
                .setBirthday(userInfo.getBirthday())
                .setBloodType(userInfo.getBloodType())
                .setWheelchair(userInfo.getWheelchair());
    }

    @Override
    public void editMedicalCard(Long userId, MedicalCardReq medicalCardReq) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getId, userId)
                .eq(UserInfo::getState, StateEnum.STATE_NORMAL.getCode());
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        userInfo.setFirstName(medicalCardReq.getFirstName())
                .setLastName(medicalCardReq.getLastName())
                .setBirthday(medicalCardReq.getBirthday())
                .setBloodType(medicalCardReq.getBloodType())
                .setWheelchair(medicalCardReq.getWheelchair());
        userInfoMapper.updateById(userInfo);
    }

    @Override
    public List<EmergencyContactResp> emergencyContactList(Long userId) {
        LambdaQueryWrapper<EmergencyContact> wrapper = new LambdaQueryWrapper<EmergencyContact>()
                .eq(EmergencyContact::getUserId, userId);
        List<EmergencyContact> emergencyContacts = emergencyContactMapper.selectList(wrapper);
        List<EmergencyContactResp> emergencyContactResps = emergencyContacts.stream().map(emergencyContact
                        -> new EmergencyContactResp().setFriend(emergencyContact.getFriend())
                        .setCall(emergencyContact.getCall()))
                .toList();
        return emergencyContactResps;
    }

    @Override
    public void editEmergencyContact(Long userId, EmergencyContactReq emergencyContactReq) {
        LambdaQueryWrapper<EmergencyContact> wrapper = new LambdaQueryWrapper<EmergencyContact>()
                .eq(EmergencyContact::getUserId, userId);
        emergencyContactMapper.delete(wrapper);
        List<EmergencyContact> emergencyContactList = emergencyContactReq.getEmergencyContacts().stream()
                .map(emergencyContact -> new EmergencyContact().setUserId(userId)
                        .setCall(emergencyContact.getCall())
                        .setFriend(emergencyContact.getFriend()))
                .toList();
        emergencyContactService.saveBatch(emergencyContactList);
    }

    @Override
    public AccountResp getAccountByUserId(Long userId) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getId, userId)
                .eq(UserInfo::getState, StateEnum.STATE_NORMAL.getCode());
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        return new AccountResp().setId(userInfo.getId())
                .setUserName(userInfo.getUserName())
                .setEmail(userInfo.getEmail())
                .setPhone(userInfo.getPhone());
    }


}
