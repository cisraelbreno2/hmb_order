package br.com.hmb_order.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String road;
    private String district;
    private String number;
    private Long city;
}
