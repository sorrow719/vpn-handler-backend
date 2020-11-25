package com.netracker.services.implementation;

import com.google.common.collect.Lists;
import com.netracker.dto.VpnDto;
import com.netracker.mapstruct.VpnStruct;
import com.netracker.model.Vpn;
import com.netracker.repository.VpnBaseRepository;
import com.netracker.services.IVpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VpnService implements IVpnService {

    private final VpnBaseRepository vpnBaseRepository;
    private final VpnStruct vpnStruct;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public VpnService(VpnBaseRepository vpnBaseRepository, VpnStruct vpnStruct) {
        this.vpnBaseRepository = vpnBaseRepository;
        this.vpnStruct = vpnStruct;
    }

    @Override
    public VpnDto findById(long id){
        return vpnStruct.toDto(vpnBaseRepository.findById(id).get());
    }
    @Override
    public void deleteById(long id){
        vpnBaseRepository.deleteById(id);
    }

    @Override
    public VpnDto create(VpnDto vpnDto){
        return vpnStruct.toDto(vpnBaseRepository.save(vpnStruct.fromDto(vpnDto)));
    }
    @Override
    public List<VpnDto> getList(){
        return vpnStruct.toDto(Lists.newArrayList(vpnBaseRepository.findAll()));
    }

    @Override
    public VpnDto updateById(long id, VpnDto vpnDto) {
        Vpn newVpn = vpnBaseRepository.findById(id).get();
        newVpn.setExpirationDate(vpnDto.getExpirationDate());
        newVpn.setTitle(vpnDto.getTitle());
        newVpn.setPassword(vpnDto.getPassword());
        return vpnStruct.toDto(vpnBaseRepository.save(newVpn));
    }

    @Override
    public void deleteAll() {
        vpnBaseRepository.deleteAll();
    }

}
