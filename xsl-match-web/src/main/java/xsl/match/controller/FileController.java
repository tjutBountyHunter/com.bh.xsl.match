package xsl.match.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xsl.match.service.ImageSave;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：文件相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 17:38
 * @Description:
 */
@Controller
@RequestMapping("file")
public class FileController {

    @Autowired
    private ImageSave imageSave;


    @RequestMapping("/image/upload")
    @ResponseBody
    /** 单图片上传 成功：url+error:0 失败时 ：Error:1 + message */
    public Map<String, Object> oneImageUpload(@Param("uploadFile")MultipartFile uploadFile){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("url","http://47.93.200.190/images/xslerp.jpg");
//        map.put("error", 0);
        Map<String, Object> map = imageSave.uploadPicture(uploadFile);
        return map;
    }
}
