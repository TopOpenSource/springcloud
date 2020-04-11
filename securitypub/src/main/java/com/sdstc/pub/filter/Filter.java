package com.sdstc.pub.filter;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Filter 与  核查对应
 * @author cheng
 *
 */
@Data
@AllArgsConstructor
public class Filter {
     private AntPathRequestMatcher matcher;
     private String checkerBeanName;
     private String failureHanderBeanName;
     
}
