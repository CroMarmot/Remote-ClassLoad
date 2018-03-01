<%@ page import="java.io.*" %>
<%@ page import="org.jvm.*" %>
<%
    InputStream is = new FileInputStream("E:\\work\\Remote-ClassLoad\\out\\test\\Remote-ClassLoad\\TestClass.class");
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();

    out.println(JavaClassExecute.execute(b));
%>