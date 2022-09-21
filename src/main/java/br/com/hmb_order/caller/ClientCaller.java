package br.com.hmb_order.caller;

import br.com.hmb_order.dto.ClientDto;
import br.com.hmb_order.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "clientCaller", url = "localhost:8081/client")
public interface ClientCaller {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ClientDto getClientById(@PathVariable("id") Long id);
}
