package com.eboji.agent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eboji.agent.transfer.TransferProcessor;

public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 5706466033121934022L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    resp.setContentType("text/html;charset=utf-8");
	    ServletOutputStream out = resp.getOutputStream();
	    out.write(TransferProcessor.getServiceMap().toString().getBytes());
	    out.flush();
	    out.close();
	}
	
}
