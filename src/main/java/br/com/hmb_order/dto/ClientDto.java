package br.com.hmb_order.dto;

import lombok.Data;

@Data
public class ClientDto {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private AddressDto addressDto;
}
