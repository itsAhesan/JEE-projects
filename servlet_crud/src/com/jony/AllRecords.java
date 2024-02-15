package com.jony;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jony.Dto.Dto;

import Dao.Dao;


@WebServlet("/AllRecords")
public class AllRecords extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		Dao dao=new Dao();
		List<Dto> dtos = dao.show();
		
		
		writer.print("<table border='1' width='60%'>"+
	"<tr>"+
		"<th> Employee Name   </th>"+
		"<th> Employee Pass </th>"+
		"<th> Employee Salary </th>"+
		"<th> Employee Address </th>"+
		"<th> Edit </th>"+
		"<th> Delete </th>");
		
		for (Dto dto : dtos){
			writer.print("<tr>"+
		"<td>"+ dto.getName()+"</td>"+ 
		 "<td>"+ dto.getPass()+"</td>"+ 
		 "<td>"+ dto.getSal()+"</td>"+
		 "<td>"+ dto.getAdd()+"</td>"+
		 "<td><a href='EditServlet?id=" +dto.getId()+"' > Edit </a></td>"+
		 "<td><a href='DeleteServlet?id=" +dto.getId()+"' > Delete </a></td>"+
		 
					"</tr>");
			}
		writer.print("</table>");		
			
		
		
		
		
		
	}

}
