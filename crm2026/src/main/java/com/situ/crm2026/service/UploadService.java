package com.situ.crm2026.service;

import com.situ.crm2026.util.Tuple;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    //上传图片
    String uploadImage(MultipartFile file, String type);
}
