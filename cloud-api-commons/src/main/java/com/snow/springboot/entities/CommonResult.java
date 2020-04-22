package com.snow.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/************
 *  @function com.snow.springboot.entities
 *  @author chenyuejun
 *  @createDate 2020-03-13 21:48
 *
 ******/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
