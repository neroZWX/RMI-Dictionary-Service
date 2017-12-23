package ie.gmit.sw;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QueryResultServlet implements Servlet{

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
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		String jobId = req.getParameter("jobId");
		Map map = QueryQueue.getOutQueueElement();
		if(map!=null && map.get("jobId").equals(jobId)){
			QueryQueue.getOutQueuePoll();
			out.println(map.get("key"));
		}else{
			out.println("");
		}
		
	}

}
