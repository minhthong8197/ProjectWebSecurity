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


@WebServlet("/NewAcount")
public class NewAcount extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public NewAcount() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf8");    
	    PrintWriter out = response.getWriter();  
	    String UserName = request.getParameter("userName");    
	    String Userpass = request.getParameter("userPass");
	    String FullName = request.getParameter("FullName");
	    String PhoneNumber = request.getParameter("PhoneNumber");
	    String Quyen = request.getParameter("check1");
	    String Gender = request.getParameter("check");
	    String date = request.getParameter("DateOfBirth");
	    

	       	
	    try{
	    	if(DBConnection.Newacount(UserName, Userpass,FullName,Gender,PhoneNumber,Quyen,date)>0){ 
	    		out.print("<script>");
	    		out.print("alert(\"Tạo Tài Khoản Thành Công!!!\");");  
	    		out.print("</script>");
	    		RequestDispatcher rd=request.getRequestDispatcher("Admin_Account_Manager.jsp");    
				    rd.include(request,response); 
	    	   }
	    	else
	    	{
	    		RequestDispatcher rd=request.getRequestDispatcher("Admin_Account_Manager.jsp");    
				    rd.include(request,response); 
	    	}
	    		   
	       }
	    catch (Exception e) {
	    	e.printStackTrace();
		}   
		doGet(request, response);
	}
}
