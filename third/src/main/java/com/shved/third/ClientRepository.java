package com.shved.third;

import com.shved.third.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository <ClientEntity, String>{

    ClientEntity getById(String id);

}
