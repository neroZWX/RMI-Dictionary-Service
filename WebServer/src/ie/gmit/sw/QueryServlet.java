package ie.gmit.sw;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QueryServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String key = req.getParameter("key");
		System.out.println(key);
		//write inqueue
		String jobId = UUID.randomUUID().toString();
		Map map = new HashMap();
		map.put("jobId", jobId);
		map.put("key", key);
		QueryQueue.addRequestQueue(map);
		
		//return jobId
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.println(jobId);
		
	}

}
