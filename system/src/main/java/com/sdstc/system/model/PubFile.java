package com.sdstc.system.model;

import com.sdstc.pub.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PubFile extends BaseModel {
    private Long id;
    private String name;
    private BigDecimal size;
    private String path;
    private String type;
    private Long customerId;
}
