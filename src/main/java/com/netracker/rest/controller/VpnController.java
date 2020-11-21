package com.netracker.rest.controller;

import com.netracker.dto.VpnDto;
import com.netracker.services.IVpnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vpn-services")
public class VpnController {
    private final IVpnService iVpnService;

    @Autowired
    public VpnController(IVpnService iVpnService) {
        this.iVpnService = iVpnService;
    }

    @GetMapping
    List<VpnDto> getList() {
        return iVpnService.getList();
    }

    @GetMapping("/{id}")
    VpnDto getById(@PathVariable("id") int id) {
        return iVpnService.findById(id);
    }

    @PostMapping
    VpnDto create(@RequestBody VpnDto vpnDto) {
        return iVpnService.create(vpnDto);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") int id) {
        iVpnService.deleteById(id);
    }

    @PutMapping("/{id}")
    VpnDto updateById(@PathVariable("id") int id, @RequestBody VpnDto vpnDto) {
        return iVpnService.updateById(id,vpnDto);
    }
}
