package com.example.columns.mapper;

import com.example.columns.entity.Columns;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wgm
 * @since 2020-08-06
 */
@Repository
@Mapper
public interface ColumnsMapper extends BaseMapper<Columns> {

}
