package xsl.match.service.impl;

import com.xsl.Utils.FtpUtil;
import com.xsl.Utils.IdUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import xsl.match.service.ImageSave;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传服务
 */
@Service
public class ImageSaveImpl implements ImageSave {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageSaveImpl.class);

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private int FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map<String,Object> uploadPicture(MultipartFile uploadFile) {
        Map<String,Object> resultMap = new HashMap<>();

        try {
            byte[] bs = uploadFile.getBytes();
            if (StringUtils.isEmpty(bs)) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传为空");
                return resultMap;
            }
            // 生成一个新的文件名
            // 取原始文件名
            String oldName = uploadFile.getOriginalFilename();
            // 生成新的文件名
            // UUID.randomUUID();
            String newName = IdUtils.genImageName();
            newName = newName + oldName.substring(oldName.indexOf("."));
            // 图片上传
            String imagePath = new DateTime().toString("/yyyy/MM/dd");
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
                    FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
            // 返回结果
            if (!result) {
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
                return resultMap;
            }

            resultMap.put("error", 0);
            resultMap.put("url", IMAGE_BASE_URL + imagePath + "/" + newName);
            return resultMap;

        } catch (IOException e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传失败");
            LOGGER.error(e.getMessage());
            return resultMap;
        }
    }
}
