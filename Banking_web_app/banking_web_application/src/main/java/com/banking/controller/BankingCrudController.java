package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.service.BankCrudService;
import com.banking.serviceImpl.BankCrudServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class BankingCrudController
 */
public class BankingCrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BankingCrudController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BankCrudService bankCrudService =null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson=new Gson();
		Bank user=null;
		user=gson.fromJson(request.getReader(), Bank.class); // JSON to POJO
		
		bankCrudService = new BankCrudServiceImpl();
		try {
			user=bankCrudService.registerCustomer(user);
			System.out.println(user);
		} catch (BankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print(gson.toJson(user));
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
