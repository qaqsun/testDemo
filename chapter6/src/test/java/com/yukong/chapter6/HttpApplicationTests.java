package com.yukong.chapter6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpApplicationTests {

    @Test
    public void IpAddress(){
        //获取request
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 方法返回发出请求的客户机的IP地址
        /*String ipAddress = request.getRemoteAddr();
        System.out.println(ipAddress);

        //浏览器版本
        String bb = request.getHeader("user-agent");
        System.out.println(bb);
        System.out.println(request.getRequestURI());*/


        //System.out.println(IPUntils.getIpAddr(request));
    }

}
