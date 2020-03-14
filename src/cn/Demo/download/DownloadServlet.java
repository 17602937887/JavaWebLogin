package cn.Demo.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数， 文件名称
        String fileName = request.getParameter("fileName");
        // 2.使用字节输入流加载文件进内存

        // 2.1 找到文件的真实路劲
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + fileName);

        // 2.2 使用字节流关联
        FileInputStream fileIn = new FileInputStream(realPath);

        // 2.3 设置response响应头
        response.setHeader("content-type", servletContext.getMimeType(fileName));
        response.setHeader("content-disposition", "attachment; filename=" + fileName);


        // 3 将输入流的数据写出到输出流中
        ServletOutputStream outStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fileIn.read(buff)) != -1){
            outStream.write(buff, 0, len);
        }

        fileIn.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
