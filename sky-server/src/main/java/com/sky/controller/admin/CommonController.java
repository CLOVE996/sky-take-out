package com.sky.controller.admin;
import com.sky.result.Result;
import com.sky.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping("/admin/common")
@RestController
public class CommonController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws  Exception {
        log.info("上传文件");
        if (!file.isEmpty()) {
            // 上传文件
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            return Result.success(url);
        }
        return Result.error("上传失败");
    }
}
