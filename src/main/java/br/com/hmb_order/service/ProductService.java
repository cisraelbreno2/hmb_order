package br.com.hmb_order.service;

import br.com.hmb_order.dto.ProductDto;
import br.com.hmb_order.model.ProductModel;
import br.com.hmb_order.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ProductModel save(ProductDto productDto){
        ProductModel product = new ProductModel();
        BeanUtils.copyProperties(productDto, product);
        return productRepository.save(product);
    }

    public Optional<ProductModel> findById(Long id){
        return productRepository.findById(id);
    }

    public List<ProductModel> findAll(){
        return productRepository.findAllByRemoveFalse();
    }

    @Transactional
    public void delete(Long id) throws Exception{
        Optional<ProductModel> product = findById(id);
        if(product.get().getId() != null){
            product.get().setRemove(true);
            productRepository.save(product.get());
        }else{
            throw new Exception("Produto não existe!");
        }
    }
}
