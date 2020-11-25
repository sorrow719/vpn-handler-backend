package com.netracker.model;


import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name = "vpn", schema = "public")
public class Vpn {
    private long vpnServiceId;
    private String title;
    private Timestamp expirationDate;
    private String password;

    @Id
    @Column(name = "vpn_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="VPN_SEQ")
    @SequenceGenerator(name="VPN_SEQ", sequenceName="VPN_SEQ",allocationSize=1)
    public long getVpnServiceId() {
        return vpnServiceId;
    }

    public void setVpnServiceId(long vpnServiceId) {
        this.vpnServiceId = vpnServiceId;
    }

    public void setVpnServiceId(int vpnServiceId) {
        this.vpnServiceId = vpnServiceId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "expiration_date")
    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

