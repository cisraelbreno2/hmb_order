package br.com.hmb_order.dto;

import br.com.hmb_order.model.RouteModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class OrderCompleteDto {

    private Long id;
    private Integer orderNumber;
    private Date orderDate;
    private RouteModel route;
    private UserDto user;
    private ClientDto client;
    private List<OrderProductDto> orderProductDtoList;

    public OrderCompleteDto(){
        orderProductDtoList = new ArrayList<>();
    }
}
