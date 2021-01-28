package com.example.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "FileDownload", value = "/FileDownload")
public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //  - 获取下载文件的路径
//        // TODO 文件路径该怎么写比较好？？
//        String path = this.getServletContext().getRealPath("/a.txt");
//        System.out.println("要下载文件的路径" + path);
//        //  - 获取下载的文件名
//        String fileName = path.substring(path.lastIndexOf("\\") + 1);
//        //  - 设置让浏览器支持下载的东西
//        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
//        //  - 获取下载文件的输入流
//        FileInputStream fileInputStream = new FileInputStream(path);
//        //  - 创建缓冲区
//        int len = 0;
//        byte[] buffer = new byte[1024];
//        //  - 创建OutPutStream对象
//        ServletOutputStream outputStream = response.getOutputStream();
//        //  - 将FileOutputStream流写入Buffer缓冲区, 使用OutPutStream将缓冲区里的数据写入到客户端
//        while ((len = fileInputStream.read(buffer)) > 0){
//            outputStream.write(buffer,0,len);
//        }
//        fileInputStream.close();
//        outputStream.close();
    }
}
