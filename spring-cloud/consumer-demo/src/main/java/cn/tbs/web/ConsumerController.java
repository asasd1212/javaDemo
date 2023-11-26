package cn.tbs.web;

import cn.tbs.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallBack")
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable("id") String id){
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance serviceInstance = instances.get(0);
//        System.out.println(serviceInstance.getUri());
//        String url = serviceInstance.getUri()+"/user/"+id;
//        System.out.println(url);
//        User forObject = restTemplate.getForObject(url, User.class);
//        return forObject;
//    }


//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable("id") String id){
//        String url = "http://user-service/user/" + id;
//        return  restTemplate.getForObject(url, User.class);
//    }



    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "findUserById")
    @HystrixCommand
    public User getUserByIdPlus(@PathVariable("id") String id){
        if("1".equals(id)){
            throw new RuntimeException("访问频繁异常");
        }
        String url = "http://user-service/user/" + id;
        return  restTemplate.getForObject(url, User.class);
    }

    public User findUserById(@PathVariable("id") String id){
        User user = new User();
        user.setUsername("访问过于频繁");
        return user;
    }

    public User defaultFallBack(){
        User user = new User();
        user.setUsername("默认异常,降级处理");
        return user;
    }
}
