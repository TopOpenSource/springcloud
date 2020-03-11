package com.sdstc.system.dao;

import com.sdstc.system.dao.base.PubDictBaseDao;
import com.sdstc.system.model.PubDict;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface PubDictDao extends PubDictBaseDao{
   List<PubDict> selectByDto(PubDict dto);
   Integer selectCountByDto(PubDict dto);
   List<PubDict> selectPageByDto(@Param("dto")PubDict dto,@Param("pageDto")PageDto pageDto);
}
