package com.sdstc.file.dao;

import com.sdstc.file.dao.base.SysFileBaseDao;
import com.sdstc.file.model.SysFile;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sdstc.pub.dto.PageDto;

public interface SysFileDao extends SysFileBaseDao{
   List<SysFile> selectByDto(SysFile dto);
   Integer selectCountByDto(SysFile dto);
   List<SysFile> selectPageByDto(@Param("dto")SysFile dto,@Param("pageDto")PageDto pageDto);
}
