package com.netracker.services.implementation;

import com.google.common.collect.Lists;
import com.netracker.dto.VpnDto;
import com.netracker.mapstruct.VpnStruct;
import com.netracker.model.Vpn;
import com.netracker.repository.VpnBaseRepository;
import com.netracker.services.IVpnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j //TODO Пример использования ломбука
@Service
public class VpnService implements IVpnService {

    private final VpnBaseRepository vpnBaseRepository;
    private final VpnStruct vpnStruct = VpnStruct.INSTANCE;

    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public VpnService(VpnBaseRepository vpnBaseRepository/*, VpnStruct vpnStruct*/) {
        this.vpnBaseRepository = vpnBaseRepository;
        /*this.vpnStruct = vpnStruct;*/
    }

    /*
    * TODO Что будет если попробовать гетнуть несущестующий id?
    *
    *  */
    @Override
    public VpnDto findById(long id){
        //TODO Пример использования ломбука
        log.info("Somebody want note with id = {}", id);
        return vpnStruct.toDto(vpnBaseRepository.findById(id).get());
    }

    //TODO А если удалить по несуществующему id?
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

    //TODO А нужно ли гетать объект перед его обновлением?
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
