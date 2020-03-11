package com.sdstc.pub.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LoginUserInfo {
   private String userAccount;
   private Long customerId;
   private List<String> userAuths;
   
   public void addAuth(String auth) {
	   if(this.userAuths==null) {
		   this.userAuths=new ArrayList<String>();
	   }
       this.userAuths.add(auth);
   }
}
