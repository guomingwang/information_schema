package com.example.columns.controller;


import com.example.columns.service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wgm
 * @since 2020-08-06
 */
@RestController
@RequestMapping("columns")
public class ColumnsController {

    @Autowired
    private ColumnsService columnsService;

    @GetMapping("xlsx/{db}")
    public void xlsx(@PathVariable String db) throws IOException {
        columnsService.xlsx(db);
    }

}

