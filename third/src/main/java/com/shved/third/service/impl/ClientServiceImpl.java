package com.shved.third.service.impl;

import com.shved.third.ClientRepository;
import com.shved.third.dto.ClientDto;
import com.shved.third.entity.ClientEntity;
import com.shved.third.mapper.ClientMapper;
import com.shved.third.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    @Override
    public ClientDto getClient(String id) {
        ClientEntity clientEntity = clientRepository.getById(id);
        return clientMapper.map(clientEntity);
    }
}
