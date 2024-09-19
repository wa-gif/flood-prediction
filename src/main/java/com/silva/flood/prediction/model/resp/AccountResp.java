package com.silva.flood.prediction.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AccountResp {
    private Long id;
    private String userName;
    private String phone;
    private String email;
}
