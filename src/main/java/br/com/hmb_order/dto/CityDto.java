package br.com.hmb_order.dto;

import lombok.Data;

@Data
public class CityDto {

    private Long id;
    private String name;
    private StateDto state;
}
