package com.shved.third.mapper;


import com.shved.third.dto.ClientDto;
import com.shved.third.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {

    ClientEntity map(ClientDto clientDto);
    ClientDto map(ClientEntity clientDto);

}
