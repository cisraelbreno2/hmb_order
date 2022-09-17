package br.com.hmb_order.repository;

import br.com.hmb_order.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    public List<ProductModel> findAllByRemoveFalse();
}
