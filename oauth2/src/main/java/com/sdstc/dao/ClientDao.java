package com.sdstc.dao;

import org.apache.ibatis.annotations.Param;
import com.sdstc.model.Client;

/**
 * 
 * @author cheng
 *
 */
public interface ClientDao {
  Client getClientById(@Param("clientId")String clientId);
}
