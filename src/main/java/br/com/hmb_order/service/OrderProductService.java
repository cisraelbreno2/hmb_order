package br.com.hmb_order.service;

import br.com.hmb_order.dto.OrderProductDto;
import br.com.hmb_order.model.OrderModel;
import br.com.hmb_order.model.OrderProductModel;
import br.com.hmb_order.model.ProductModel;
import br.com.hmb_order.repository.OrderProductRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderProductService {
    
    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    ProductService productService;

    @Transactional
    public OrderProductModel save(OrderProductDto orderProductDto, OrderModel order) throws NoSuchElementException {

        try {
            OrderProductModel orderProduct;
            orderProduct = new OrderProductModel();

            ProductModel product = new ProductModel();

            BeanUtils.copyProperties(orderProductDto, orderProduct);
            orderProduct.setProduct(productService.findById(orderProductDto.getProduct().getId()).orElseThrow());
            orderProduct.setOrder(order);

            return orderProductRepository.save(orderProduct);

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(e.getMessage() + " : Produto inexistente na base de dados");
        }
    }

    public Optional<OrderProductModel> findById(Long id){
        return orderProductRepository.findById(id);
    }

    public List<OrderProductModel> findAllByOrderId(Long orderId){
        return orderProductRepository.findAllByOrderId(orderId);
    }

    @Transactional
    public void delete(Long id) throws Exception{
        Optional<OrderProductModel> orderProduct = findById(id);
        if(orderProduct.get().getId() != null){
            orderProductRepository.delete(orderProduct.get());
        }else{
            throw new Exception("Produto não existe!");
        }
    }
}
