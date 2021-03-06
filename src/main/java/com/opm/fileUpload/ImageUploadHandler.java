package com.opm.fileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUploadHandler extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:\\Users\\HEMANT\\Documents\\OnlineProjectManagement\\src\\main\\webapp\\resources\\images";
   
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
            	
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               String name = request.getParameter("username")+".png";
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
  
               request.setAttribute("message", "File Uploaded successfully");
            } catch (Exception ex) {
            	ex.printStackTrace();
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
        System.out.println("Image uploaded");
        request.getRequestDispatcher("/profile?update=image").forward(request, response);
      
    }
   
}