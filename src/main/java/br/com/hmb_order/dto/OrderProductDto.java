package br.com.hmb_order.dto;

import br.com.hmb_order.model.OrderModel;
import br.com.hmb_order.model.ProductModel;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class OrderProductDto {

    private Long id;
    private ProductDto product;
    private String note;
    private Integer quantity;

    public OrderProductDto(){
        product = new ProductDto();
    }
}
