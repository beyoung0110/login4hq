package com.login4hq.action.upload;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.util.Date;  
import org.apache.struts2.ServletActionContext;  
import com.opensymphony.xwork2.Action;  
  
public class UploadAction implements Action {  
    //封装上传文件域的属性  执行action前，upload已经指向了tmp临时文件。
    private File upload;  
    //封装上传文件类型的属性  
    private String uploadContentType;  
    //封装上传文件名的属性  
    private String uploadFileName;  
    //接受依赖注入的属性  
    private String savePathHq;  
      
    public void setSavePathHq(String savePathHq){  
        this.savePathHq = savePathHq;  
    }  
    public String getSavePathHq(){  
        return savePathHq;  
    }  
    public File getUpload() {  
        return upload;  
    }  
    public void setUpload(File upload) {  
        this.upload = upload;  
    }  
    public String getUploadContentType() {  
        return uploadContentType;  
    }  
    public void setUploadContentType(String uploadContentType) {  
        this.uploadContentType = uploadContentType;  
    }  
    public String getUploadFileName() {  
        return uploadFileName;  
    }  
    public void setUploadFileName(String uploadFileName) {  
        this.uploadFileName = uploadFileName;  
    }  
    public String execute() throws Exception {  
        String newFileName = null; // 新的文件名  
        long now = new Date().getTime(); // 得到当前时间自1970年1月1日0时0分0秒开始流逝的毫秒数,将这个毫秒数作为上传文件新的文件名  
        //得到保存上传文件的目录的真实路径  
        @SuppressWarnings("deprecation")
		File filePath = new File(ServletActionContext.getRequest().getRealPath(savePathHq));  
        //如果目录不存在就创建  
        if(!filePath.exists())  
            filePath.mkdir();  
        //判断文件是否有扩展名  
        int index = uploadFileName.lastIndexOf('.');  
        if(index != -1)  
            newFileName = now + uploadFileName.substring(index);  
        else  
            newFileName = Long.toString(now);  
  
        // 以服务器的文件保存地址加上新的文件名建立上传文件输出流  
        FileOutputStream fos = new FileOutputStream(new File(filePath,newFileName));  
        // 以上传文件建立一个上传文件流  
        FileInputStream fis = new FileInputStream(upload);  
        byte[] buffer = new byte[1024*10];  
        int len = 0;  
        while((len=fis.read(buffer)) > 0 ){  
            fos.write(buffer, 0, len);  
        }  
        fis.close();  
        fos.close();
        return SUCCESS;  
    }  
}  