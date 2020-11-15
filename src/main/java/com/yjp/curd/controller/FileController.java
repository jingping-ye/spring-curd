package com.yjp.curd.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;


@Api(tags = "文件管理")
@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {
    @ApiOperation("获取单张图片")
    @RequestMapping(value="/img", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[]  getImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/cicd_flow.png");
        return IOUtils.toByteArray(in);
    }

}
