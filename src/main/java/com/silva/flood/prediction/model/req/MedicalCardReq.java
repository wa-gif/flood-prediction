package com.silva.flood.prediction.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MedicalCardReq {
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private Integer bloodType;
    private Integer wheelchair;
}
