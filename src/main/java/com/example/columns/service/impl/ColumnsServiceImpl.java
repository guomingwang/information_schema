package com.example.columns.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.columns.entity.Columns;
import com.example.columns.mapper.ColumnsMapper;
import com.example.columns.service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wgm
 * @since 2020-08-06
 */
@Service
@Transactional
public class ColumnsServiceImpl extends ServiceImpl<ColumnsMapper, Columns> implements ColumnsService {

    @Autowired
    private ColumnsMapper columnsMapper;

    @Override
    public void xlsx(String db) throws IOException {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + db + ".xlsx");
        try (
                OutputStream outputStream = response.getOutputStream()
        ) {
            List<Columns> columns = showList(db);
            EasyExcel
                    .write()
                    .file(outputStream)
                    .excelType(ExcelTypeEnum.XLSX)
                    .autoCloseStream(true)
                    .sheet()
                    .head(Columns.class)
                    .includeColumnIndexes(Arrays.asList(0, 1, 2, 3, 4))
                    .autoTrim(true)
                    .useDefaultStyle(true)
                    .doWrite(columns);
        }
    }

    private List<Columns> showList(String db) {
        Columns columnsForQuery = new Columns();
        columnsForQuery.setTableSchema(db);
        return list(new QueryWrapper<>(columnsForQuery));
    }
}
