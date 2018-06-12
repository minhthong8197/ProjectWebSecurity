package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DB.DBConnection;


@WebServlet("/Newpost")
public class Newpost extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Newpost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");    
	    PrintWriter out = response.getWriter();  
	    String PostName = request.getParameter("P_name");    
	    String PostContent = request.getParameter("txtcontent");
	    String Pdate = request.getParameter("P_date");
	    String Ptl = request.getParameter("P_tl");

	       	
	    try{
	    	if(DBConnection.NewPost(PostName, PostContent,Ptl,Pdate)>0){ 
	    		out.print("<script>");
	    		out.print("alert(\"Gửi Bài Viết Thành Công!!!\");");  
	    		out.print("</script>");
	    		RequestDispatcher rd=request.getRequestDispatcher("Writer_Manager.jsp");    
				    rd.include(request,response); 
	    	   }
	    	else
	    	{
	    		RequestDispatcher rd=request.getRequestDispatcher("Writer_Manager.jsp");    
				    rd.include(request,response); 
	    	}
	    		   
	       }
	    catch (Exception e) {
	    	e.printStackTrace();
		}   
		doGet(request, response);
	}
}
