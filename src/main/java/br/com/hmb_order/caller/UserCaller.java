package br.com.hmb_order.caller;

import br.com.hmb_order.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "userCaller", url = "localhost:8083/user")
public interface UserCaller {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserDto getUserById(@PathVariable("id") Long id);
}
