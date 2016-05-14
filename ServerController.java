package com.hydra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hydra.dao.ServerDao;
import com.hydra.model.Server;

/**
 * Servlet implementation class ServerController
 */
@WebServlet("/ServerController")
public class ServerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_DELETE_UPDATE = "/insert.jsp";
	private ServerDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServerController() {
		super();
		dao = new ServerDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward = "";
		String action = request.getParameter("action");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		if (action.equals("insert")) {
			// int
			// ServerId=(Integer.parseInt(request.getParameter("serverid")));
			Server sbean = new Server();
			sbean.setServerId((Integer.parseInt(request.getParameter("serverid"))));
			sbean.setServerName(request.getParameter("servername"));
			int i = dao.addServer(sbean);
			if (i > 0) {
				pw.println("<center>Insertion successfullly </center>");
				rd = request.getRequestDispatcher("insert.jsp");
				rd.include(request, response);
			} else {
				pw.println("<center>Insertion Failed </center>");
				rd = request.getRequestDispatcher("insert.jsp");
				rd.include(request, response);
			}

		} else if (action.equalsIgnoreCase("mainform")) {
			ArrayList<Server> slist = new ArrayList<Server>();
			slist = dao.findall();
			session.setAttribute("viewserver", slist);
			rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);

		}

		else if (action.equalsIgnoreCase("delete")) {
			int ServerId = (Integer.parseInt(request.getParameter("serverid")));
			Server sbean = new Server();
			sbean.setServerId(ServerId);

			dao.deleteServer(sbean);

			/// forward = LIST_USER;
			/// request.setAttribute(Server,dao.getallServers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_DELETE_UPDATE;
			int ServerId = (Integer.parseInt(request.getParameter("serverid")));
			Server sbean = new Server();
			// sbean.setServer_Id(server_Id);

		}
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
