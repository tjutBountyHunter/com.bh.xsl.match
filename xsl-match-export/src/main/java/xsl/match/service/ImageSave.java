package xsl.match.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 照片处理
 *
 * @author 11432_000
 */
public interface ImageSave {
    /**
     * 照片储存
     *
     * @param uploadFile
     * @return
     */
    Map<String,Object> uploadPicture(MultipartFile uploadFile);
}
