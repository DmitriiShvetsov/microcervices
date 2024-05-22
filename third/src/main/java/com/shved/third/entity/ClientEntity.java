package com.shved.third.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ClientEntity {

    @Id
    private String id;

    private String fullName;

}
