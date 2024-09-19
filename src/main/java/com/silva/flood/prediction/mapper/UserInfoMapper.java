package com.silva.flood.prediction.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.silva.flood.prediction.model.Shelter;
import com.silva.flood.prediction.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends MPJBaseMapper<UserInfo> {
}
