package com.shved.third.controller;

import com.shved.third.dto.ClientDto;
import com.shved.third.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/client")
    public ClientDto getClient(@PathVariable String id) {
        return clientService.getClient(id);
    }

}
