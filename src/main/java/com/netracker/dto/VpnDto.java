package com.netracker.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class VpnDto {
    private long vpnServiceId;
    private String title;
    private Timestamp expirationDate;
    private String password;
}
