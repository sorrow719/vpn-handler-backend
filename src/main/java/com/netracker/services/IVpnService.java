package com.netracker.services;


import com.netracker.dto.VpnDto;


import java.util.List;


public interface IVpnService {
    VpnDto findById(long id);

    void deleteById(long id);

    VpnDto create(VpnDto vpnDto);

    List<VpnDto> getList();

    VpnDto updateById(long id, VpnDto vpnDto);

    void deleteAll();
}
