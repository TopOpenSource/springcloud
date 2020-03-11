package com.sdstc.system.dao;

import com.sdstc.system.dao.base.PubFileBaseDao;
import com.sdstc.system.model.PubFile;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface PubFileDao extends PubFileBaseDao{
   List<PubFile> selectByDto(PubFile dto);
   Integer selectCountByDto(PubFile dto);
   List<PubFile> selectPageByDto(@Param("dto")PubFile dto,@Param("pageDto")PageDto pageDto);
}
