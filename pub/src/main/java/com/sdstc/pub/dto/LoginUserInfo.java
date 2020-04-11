package com.sdstc.pub.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 登陆者信息
 * @author cheng
 *
 */
@Data
public class LoginUserInfo {
   private String userAccount;
   private String userName;
   private Long tenantId;
   private String tenantName;
   private List<String> userAuths;
   
   public void addAuth(String auth) {
	   if(this.userAuths==null) {
		   this.userAuths=new ArrayList<String>();
	   }
       this.userAuths.add(auth);
   }
}
