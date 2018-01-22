package com.zmh.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * hello world
 * 创建一个springboot项目 选择web组件
 * 新建这个Controller即可访问
 * http://localhost:8080/hello
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Autowired
    private GirlPropertiey girlPropertiey;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String all(){
        return girlPropertiey.toString();
    }

    @RequestMapping(value = "/cupSize",method = RequestMethod.GET)
    public String cupSize(){
        return "cupSize : " + cupSize + " age:"+age;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot!";
    }

    //URL 参数 搭配 PathVariable 获取的 demo 访问方法 http://host:port/value/666
    @RequestMapping(value = "/value1/{id}",method = RequestMethod.GET)
    public String getValue1(@PathVariable("id") Integer id){
        return "id : " + id;
    }

    //URL 参数 搭配 PathVariable 获取的 demo 访问方法 http://host:port/value?id=666
    @RequestMapping(value = "/value2",method = RequestMethod.GET)
    public String getValue2(@RequestParam("id") Integer id){
        return "id : " + id;
    }

    // 上文方法进阶版 支持非必传参数和默认值设定
    // value 为传入的参数名 required 是否必传 defaultValue默认值（传入时必须是String）
    //@RequestMapping(value = "/value3",method = RequestMethod.GET)
    @GetMapping("value3")
    public String getValue3(@RequestParam(value="id",required = false,defaultValue = "0") Integer id){
        return "id : " + id;
    }
}
