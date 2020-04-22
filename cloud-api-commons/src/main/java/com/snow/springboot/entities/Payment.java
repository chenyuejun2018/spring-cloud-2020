package com.snow.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/************
 *  @function com.snow.springboot.entities
 *  @author chenyuejun
 *  @createDate 2020-03-14 1:50
 *
 ******/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
