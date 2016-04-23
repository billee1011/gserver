package com.eboji.commons.jetty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

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
		List<String> list = new ArrayList<String>();

	    list.add("Demo");
	    list.add("中文");

	    resp.setContentType("text/html;charset=utf-8");
	    ServletOutputStream out = resp.getOutputStream();
	    String json = JSON.toJSONString(list);
	    out.write(json.getBytes());
	    out.flush();
	    out.close();
	}
	
}
