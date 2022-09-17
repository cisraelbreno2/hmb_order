package br.com.hmb_order.service;

import br.com.hmb_order.dto.RouteDto;
import br.com.hmb_order.model.RouteModel;
import br.com.hmb_order.repository.RouteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Transactional
    public RouteModel save(RouteDto routeDto){
        RouteModel route = new RouteModel();
        BeanUtils.copyProperties(routeDto, route);
        return routeRepository.save(route);
    }

    public Optional<RouteModel> findById(Long id){
        return routeRepository.findById(id);
    }

    //public List<RouteModel> findAllByState(Long idState){        return routeRepository.getAllByState(idState);   }

    public List<RouteModel> findAll(){
        return routeRepository.findAll();
    }

    @Transactional
    public void delete(Long id) throws Exception{
        Optional<RouteModel> route = findById(id);
        if(route.get().getId() != null){
            routeRepository.delete(route.get());
        }else{
            throw new Exception("Rota não existe!");
        }
    }
}
