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


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String sid = request.getParameter("id");
		int id= Integer.parseInt(sid);
		
		Dao dao= new Dao();
		Dto edit1 = dao.edit(id);
		
		writer.print("<h1 align='center'>Welcome to EDIT operation</h1>"+
	"<hr>"+
	
	"<h2 align='center'>Update Employee</h2>"+
	"<form action='UpdateServlet'  method='post'> "+
	"<h3 align='center'>"+
	
	"<input type='hidden'  name='id' value='"+edit1.getId() +"'>"+
	"<input type='text'  name='name' value='"+edit1.getName() +"'>"+
	"<input type='password'  name='pass'  value='"+edit1.getPass() +"'>"+
	"<input type='text'  name='sal'  value= '"+edit1.getSal() +"'>"+
	"<input type='text'  name='add'  value= '"+edit1.getAdd() +"'><br>"+
	"<input type='submit' value='Update'>"+
	
	"</h3>"+
	"</form>"+
	"<h3 align='center'><a href='AllRecords'>Show all records</a></h3>");
		
		
		
		
		
		
	}

}
