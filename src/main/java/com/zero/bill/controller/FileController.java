package com.zero.bill.controller;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Zengzhx
 * @date 2020/7/18 5:02 PM
 */
public class FileController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);



    /**
     * 处理文件上传
     */
    @PostMapping(value = "/upload")
    public String uploading(@RequestParam("file") MultipartFile file) {


        String tmpDir = System.getProperty("java.io.tmpdir");
        String filePath =  tmpDir + File.separator + file.getName();

        logger.info("上传文件路径:{}", filePath);
        Path path = Paths.get(filePath);

        try {
            Files.createFile(path);
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("文件上传失败!");
            return "uploading failure";
        }
        logger.info("文件上传成功!");

        try {
            csvReadOperation(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("读取CSV文件失败！");
        }


        return "uploading success";
    }

    private   void csvReadOperation(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        CsvReader csvReader = new CsvReader();
        csvReader.setContainsHeader(true);
        CsvContainer csv = csvReader.read(path, StandardCharsets.UTF_8);
        for (CsvRow row : csv.getRows()) {
            logger.info("row data:{}", row.toString());
        }
    }



}
