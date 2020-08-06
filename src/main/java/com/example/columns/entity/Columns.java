package com.example.columns.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wgm
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Columns对象", description="")
public class Columns implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tableCatalog;

    private String tableSchema;

    private String tableName;

    @ExcelProperty(value = "字段名称", index = 1)
    private String columnName;

    @ExcelProperty(value = "序号", index = 0)
    private Long ordinalPosition;

    private String columnDefault;

    private String isNullable;

    @ExcelProperty(value = "字段类型", index = 2)
    private String dataType;

    @ExcelProperty(value = "字段长度", index = 3)
    private Long characterMaximumLength;

    private Long characterOctetLength;

    private Long numericPrecision;

    private Long numericScale;

    private Long datetimePrecision;

    private String characterSetName;

    private String collationName;

    private String columnType;

    private String columnKey;

    private String extra;

    private String privileges;

    @ExcelProperty(value = "备注", index = 4)
    private String columnComment;


}
