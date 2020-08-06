package com.example.columns.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.columns.entity.Columns;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wgm
 * @since 2020-08-06
 */
public interface ColumnsService extends IService<Columns> {

    void xlsx(String db) throws IOException;
}
