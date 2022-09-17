package br.com.hmb_order.repository;

import br.com.hmb_order.model.OrderProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductModel, Long> {

    @Query("SELECT op FROM OrderProductModel op WHERE op.order.id = :orderId")
    public List<OrderProductModel> findAllByOrderId(@Param("orderId") Long orderId);


}
