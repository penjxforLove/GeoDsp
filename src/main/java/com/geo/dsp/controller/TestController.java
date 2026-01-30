package com.geo.dsp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试接口，用来验证前后端连通性
 * ✅ 必须加 @RestController 注解 → 前后端分离必加，返回JSON数据
 * ✅ @RequestMapping("/test") → 接口的一级路径
 */
@RestController
@RequestMapping("/test")
public class TestController {

    // ✅ 测试GET请求接口 → 地址：http://localhost:9966/test/hello
    @GetMapping("/hello")
    public String hello() {
        // 返回字符串，前端能收到就代表连通成功
        return "前后端打通成功！Hello World！";
    }

    // ✅ 测试POST请求接口 → 地址：http://localhost:9966/test/getData
    // 返回JSON格式数据（开发中最常用）
    @PostMapping("/getData")
    public Map<String, Object> getData() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "请求成功");
        result.put("data", "这是后端返回的JSON数据");
        return result;
    }
}