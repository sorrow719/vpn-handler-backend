package com.netracker.repository;

import com.netracker.model.Vpn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VpnBaseRepository extends CrudRepository<Vpn, Long> {

}
