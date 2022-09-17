package br.com.hmb_order.repository;

import br.com.hmb_order.model.RouteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteModel, Long > {
}
