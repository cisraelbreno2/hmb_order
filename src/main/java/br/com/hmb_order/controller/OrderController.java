package br.com.hmb_order.controller;

import br.com.hmb_order.dto.OrderDto;
import br.com.hmb_order.model.OrderModel;
import br.com.hmb_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto){

        OrderModel order = orderService.save(orderDto);

        return new ResponseEntity(order, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return new ResponseEntity(orderService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/orderComplete/{id}")
    public ResponseEntity findOrderComplete(@PathVariable("id") Long id){
        return new ResponseEntity(orderService.findOrderComplete(id),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity findAll(){
        return new ResponseEntity(orderService.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws Exception {
        orderService.delete(id);
        return new ResponseEntity("Ordem " + id + " excluido com sucesso", HttpStatus.OK);
    }
}
