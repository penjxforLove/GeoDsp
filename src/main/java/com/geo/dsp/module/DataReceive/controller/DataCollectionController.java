package com.geo.dsp.module.DataReceive.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class DataCollectionController {

    /**
     * 数据接收接口
     * @param rawData 原始数据（由于格式未定，暂用 Object 占位）
     * @return 响应结果
     */
    @PostMapping("/receive")
    public String handleData(@RequestBody Object rawData) {
        // TODO:
        System.out.println("接收到数据：" + rawData);
        return "success";
    }
}

