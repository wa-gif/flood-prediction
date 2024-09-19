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
import com.silva.flood.prediction.model.resp.EmergencyContactResp;
import com.silva.flood.prediction.model.resp.MedicalCardResp;
import com.silva.flood.prediction.service.EmergencyContactService;
import com.silva.flood.prediction.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyContactServiceImpl extends MPJBaseServiceImpl<EmergencyContactMapper, EmergencyContact> implements EmergencyContactService {

}
