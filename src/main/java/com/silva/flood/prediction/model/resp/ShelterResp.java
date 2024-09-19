package com.silva.flood.prediction.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ShelterResp {
    private Long id;
    private String shelterName;
    private String call;
    private String address;
    private Double distance;
    private Integer state;
}
