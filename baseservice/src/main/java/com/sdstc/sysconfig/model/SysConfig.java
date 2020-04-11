package com.sdstc.sysconfig.model;

import lombok.Data;

@Data
public class SysConfig {
    private Long id;
    private char type;
    private String key;
    private String value;
    private Integer a;
}
