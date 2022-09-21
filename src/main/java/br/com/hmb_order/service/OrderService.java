package br.com.hmb_order.service;

import br.com.hmb_order.caller.ClientCaller;
import br.com.hmb_order.caller.UserCaller;
import br.com.hmb_order.dto.OrderCompleteDto;
import br.com.hmb_order.dto.OrderDto;
import br.com.hmb_order.dto.OrderProductDto;
import br.com.hmb_order.dto.ProductDto;
import br.com.hmb_order.model.OrderModel;
import br.com.hmb_order.model.OrderProductModel;
import br.com.hmb_order.repository.OrderRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    UserCaller userCaller;

    @Autowired
    ClientCaller clientCaller;

    @Autowired
    RouteService routeService;

    @Transactional
    public OrderModel save(OrderDto orderDto){
        OrderModel order = new OrderModel();
        BeanUtils.copyProperties(orderDto, order);
        Double total = 0.0;

        for (OrderProductDto dto :  orderDto.getOrderProductDtoList()) {
            total += dto.getProduct().getPrice() * dto.getQuantity();
        }
        order.setTotal(total);
        order.setOrderDate(new Date());
        order.setRoute(routeService.findById(orderDto.getRouteId()).get());
        orderRepository.save(order);

        for (OrderProductDto dto :  orderDto.getOrderProductDtoList()) {
            orderProductService.save(dto, order);
        }

        return order;
    }

    public Optional<OrderModel> findById(Long id){
        return orderRepository.findById(id);
    }

    public Optional<OrderCompleteDto> findOrderComplete(Long orderId){
        OrderModel order = orderRepository.findById(orderId).orElseThrow();
        List<OrderProductModel> orderProductModelList = orderProductService.findAllByOrderId(orderId);
        OrderCompleteDto orderComplete = new OrderCompleteDto();

        orderComplete.setId(order.getId());
        orderComplete.setOrderDate(order.getOrderDate());

        //CRIAR DENTRO DO MICROSSERVIÇO DE CLIENTE E DE USUARIO UM GET PARA RETORNAR OS DTOS
        orderComplete.setClient(clientCaller.getClientById(order.getClientId()));
        orderComplete.setUser(userCaller.getUserById(order.getUserId()));
        orderComplete.setRoute(order.getRoute());
        orderComplete.setOrderNumber(order.getOrderNumber());

        for (OrderProductModel orderProduct :  orderProductModelList) {
            OrderProductDto dto = new OrderProductDto();
            dto.setNote(orderProduct.getNote());
            dto.setQuantity(orderProduct.getQuantity());

            //ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(orderProduct.getProduct(), dto.getProduct());
            //dto.setProduct(productDto);
            orderComplete.getOrderProductDtoList().add(dto);
        }

        return Optional.of(orderComplete);
    }

    public List<OrderModel> findAll(){
        return orderRepository.findAll();
    }

    @Transactional
    public void delete(Long id) throws Exception{
        Optional<OrderModel> order = findById(id);
        if(order.get().getId() != null){
            order.get().setRemove(true);
            orderRepository.delete(order.get());
        }else{
            throw new Exception("Produto não existe!");
        }
    }

}
