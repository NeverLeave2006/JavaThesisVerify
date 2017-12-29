package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FileUpload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		File tmp=new File(request.getSession().getServletContext().getRealPath("")+"/tmp");
		if(!tmp.exists()) {  
            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼  
            System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");  
            if(!tmp.mkdirs()) {  
                System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");  
            }  
        }  
		
		DiskFileItemFactory factory=new DiskFileItemFactory(40*1024,tmp);
		ServletFileUpload sfu=new ServletFileUpload(factory);
		try {
			List<FileItem> fileitemList=sfu.parseRequest(request);
			FileItem fi1=fileitemList.get(0);
//			FileItem fi2=fileitemList.get(1);
//			String fieldName=fi1.getFieldName();
//			String value=fi1.getString("UTF-8");
//			out.print(fieldName);
//			out.println(value+"<br/>");
			HttpSession session=request.getSession();
			
			String fileType=fi1.getContentType();
			long size=fi1.getSize();
			String name=fi1.getName();
			String postfix=name.substring(name.lastIndexOf('.'));
			out.println("�ļ����ͣ�"+fileType+"<br/>");
			out.println("�ļ���С��"+size+"<br/>");
			out.println("�ļ�����"+name+"<br/>");
			
			//out.println("D:\\Workspaces\\MyEclipse 10\\Test1\\WebRoot\\WEB-INF\\"+session.getAttribute("stuNum")+session.getAttribute("stuName")+postfix);
			
			File destFile=new File(request.getSession().getServletContext().getRealPath("")+"/WEB-INF/homework/"+session.getAttribute("stuNum")+session.getAttribute("stuName")+postfix);
			
			if(!destFile.getParentFile().exists()) {  
	            //���Ŀ���ļ����ڵ�Ŀ¼�����ڣ��򴴽���Ŀ¼  
	            System.out.println("Ŀ���ļ�����Ŀ¼�����ڣ�׼����������");  
	            if(!destFile.getParentFile().mkdirs()) {  
	                System.out.println("����Ŀ���ļ�����Ŀ¼ʧ�ܣ�");  
	            }  
	        }  
			
			String filePath=request.getSession().getServletContext().getRealPath("");
			//out.println("���ԣ�������������"+filePath);
			fi1.write(destFile);
			out.println("�ϴ��ɹ�");
			out.println("<a href='checkUser'>����</a>");			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
