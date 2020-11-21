package com.netracker.dto;


import java.sql.Timestamp;

public class VpnDto {
    private long vpnServiceId;
    private String title;
    private Timestamp expirationDate;
    private String password;


    public long getVpnServiceId() {
        return vpnServiceId;
    }

    public void setVpnServiceId(long vpnServiceId) {
        this.vpnServiceId = vpnServiceId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
