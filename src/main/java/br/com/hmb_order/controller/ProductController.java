package br.com.hmb_order.controller;

import br.com.hmb_order.dto.ProductDto;
import br.com.hmb_order.model.ProductModel;
import br.com.hmb_order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("")
    public ResponseEntity createProduct(@RequestBody ProductDto productDto){

        ProductModel product = productService.save(productDto);

        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return new ResponseEntity(productService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity findAll(){
        return new ResponseEntity(productService.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws Exception {
        productService.delete(id);
        return new ResponseEntity("Produto " + id + " excluido com sucesso", HttpStatus.OK);
    }
}
