package com.swei.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-11-29 14:04
 */
@RestController
@Slf4j
public class AnnoController {
    @RequestMapping("/anno1")
    @SentinelResource(value = "anno1",
            // 当限流或者被降级会触发该方法
            blockHandler="anno1BlockHandler",
            // 当出现异常会触发该方法
            fallback = "anno1Fallback"
    )
    public String anno1(String name){
        if("wolfcode".equals(name)){
            throw new RuntimeException();
        }
        return "anno1";
    }
    public String anno1BlockHandler(String name, BlockException ex){
        log.error("{}", ex);
        return "接⼝被限流或者降级了";
    }
    //Throwable时进⼊的⽅法
    public String anno1Fallback(String name,Throwable throwable) {
        log.error("{}", throwable);
        return "接⼝发⽣异常了";
    }
}
