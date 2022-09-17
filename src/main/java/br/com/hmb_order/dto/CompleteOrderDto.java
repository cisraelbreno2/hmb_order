package br.com.hmb_order.dto;

import br.com.hmb_order.model.RouteModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CompleteOrderDto {

    private Long id;
    private Integer orderNumber;
    private Date orderDate;
    private RouteModel route;
    private Long userId;
    private Long clientId;
    private List<OrderProductDto> orderProductDtoList;
}
