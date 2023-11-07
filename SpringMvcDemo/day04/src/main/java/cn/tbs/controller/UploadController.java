package cn.tbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@ResponseBody
public class UploadController {
    @RequestMapping(value = "/upload")
    public String upload(String username, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
        System.out.println(username);
//        String Path = "d://test";
        String Path = request.getServletContext().getRealPath("/upload");
        System.out.println(Path);
        String originalFilename = multipartFile.getOriginalFilename();
        File file = new File(Path);
        System.out.println(Path);
        if(!file.exists()){
            System.out.println("创建了目录");
            file.mkdirs();
        }

        try {
            multipartFile.transferTo(new File(Path,originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "file upload success!";
    }

    @RequestMapping(value = "/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取服务器文件的真实路径
        String realPath = request.getServletContext().getRealPath("/upload");
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(realPath,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int len=0;
        //4、执行 写出操作
        while((len= input.read(buff))!= -1){
            out.write(buff, 0, len);
            out.flush();
        }
        out.close();
        input.close();
    }
}
