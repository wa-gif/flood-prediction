package com.silva.flood.prediction.model.req;

import com.silva.flood.prediction.model.resp.EmergencyContactResp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class EmergencyContactReq {
    List<EmergencyContactResp> emergencyContacts;
}
