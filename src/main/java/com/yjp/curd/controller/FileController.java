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
public class FileController {
    @ApiOperation("获取单张图片")
    @RequestMapping(value="/img", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[]  getImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/cicd_flow.png");
        return IOUtils.toByteArray(in);
    }

    @ApiOperation("获取doc文件")
    @RequestMapping(value="/doc", method = RequestMethod.GET, produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public @ResponseBody byte[]  getDoc() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/warm.docx");
        return IOUtils.toByteArray(in);
    }

    @ApiOperation("获取EXE文件")
    @RequestMapping(value="/exe", method = RequestMethod.GET, produces = "application/vnd.microsoft.portable-executable")
    public @ResponseBody byte[]  getExe() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/wx.exe");
        return IOUtils.toByteArray(in);
    }

    @ApiOperation("获取压缩包文件")
    @RequestMapping(value="/zip", method = RequestMethod.GET, produces = "application/x-7z-compressed")
    public @ResponseBody byte[]  getZip() throws IOException {
        InputStream in = getClass().getResourceAsStream("/static/book.7z");
        return IOUtils.toByteArray(in);
    }

}
