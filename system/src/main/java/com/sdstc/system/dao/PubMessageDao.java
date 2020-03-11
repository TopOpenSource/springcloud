package com.sdstc.system.dao;

import com.sdstc.system.dao.base.PubMessageBaseDao;
import com.sdstc.system.model.PubMessage;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface PubMessageDao extends PubMessageBaseDao{
   List<PubMessage> selectByDto(PubMessage dto);
   Integer selectCountByDto(PubMessage dto);
   List<PubMessage> selectPageByDto(@Param("dto")PubMessage dto,@Param("pageDto")PageDto pageDto);
}
