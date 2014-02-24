<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="/struts-tags" prefix="s"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>文件上传</title>  
</head>  
<body>
    <!-- 为了完成文件上传,设置该表单的enctype属性为multipart/form-data -->  
    <form action="/upload/uploadfile" method="post" enctype="multipart/form-data">  
        选择文件:
        <input type="file" name="upload" />  
        <input type="submit" value="上传" />  
    </form>  
</body>  
</html>