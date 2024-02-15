package com.jony;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jony.Dto.Dto;

import Dao.Dao;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		

		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String asal = request.getParameter("sal");
		int sal = Integer.parseInt(asal);
		String add = request.getParameter("add");
		
		
		Dto dto=new Dto();
		dto.setName(name);
		dto.setPass(pass);
		dto.setSal(sal);
		dto.setAdd(add);
		
		Dao dao= new Dao();
		dao.add(dto);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		writer.print("<h1>Record Save Successful</h1>");
		
		
		
		
		
	}
}
