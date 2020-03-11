package com.sdstc.system.dao;

import com.sdstc.system.dao.base.PubFileRelationBaseDao;
import com.sdstc.system.model.PubFileRelation;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface PubFileRelationDao extends PubFileRelationBaseDao{
   List<PubFileRelation> selectByDto(PubFileRelation dto);
   Integer selectCountByDto(PubFileRelation dto);
   List<PubFileRelation> selectPageByDto(@Param("dto")PubFileRelation dto,@Param("pageDto")PageDto pageDto);
}
