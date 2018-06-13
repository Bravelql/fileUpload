package com.lql.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.jws.WebService;
import javax.servlet.ServletInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class fileUploadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("=====enter ok!");
        /*String username = request.getParameter("username");
        String filename = request.getParameter("filename");

        System.out.println(username+"::"+filename);

        ServletInputStream inputStream = request.getInputStream();
        System.out.println("is:"+inputStream);*/


        try {
            //1.创建磁盘文件项工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2.创建核心对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            //3.解析请求
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem file : fileItems) {
                //获取标签name属性
                String fieldName = file.getFieldName();
                System.out.println(fieldName);

                //判断是否为普通上传组件
                if(file.isFormField()){
                    //普通上传组件
                    String value = file.getString("utf-8");
                    System.out.println(value);
                }else{
                    //文件上传组件
                    //获取文件名称
                    String name = file.getName();
                    //获取文件内容
                    InputStream inputStream = file.getInputStream();
                    System.out.println(name+":"+inputStream);
                    //保存文件
                    //创建一个输出流
                    FileOutputStream outputStream = new FileOutputStream(new File("d://" + name));

                    //拷贝流
                    IOUtils.copy(inputStream,outputStream);

                    //释放资源
                    outputStream.close();
                    inputStream.close();

                    //删除临时文件
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
