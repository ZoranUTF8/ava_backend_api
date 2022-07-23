package com.zoranjanjic.demorest;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CorsFilter
 */
public class ApiFilter extends HttpFilter implements Filter {

	HistoryService historyService = new HistoryService();

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

		try {

			HttpServletResponse resp = (HttpServletResponse) response;

			HttpServletRequest req = (HttpServletRequest) request;

			// Save request info to db
			java.util.Date currentDate = new java.util.Date();

			Date queryDate = new Date(currentDate.getTime());
			Time queryTime = new Time(currentDate.getTime());

			String queryPath = req.getRequestURL().toString();
			String queryParams = req.getQueryString();
			String[] arrOfStr1 = queryParams.split("=");
			String queryParam = arrOfStr1[1];

			historyService.saveHistoryToDb(queryDate, queryPath, queryTime, queryParam);

			resp.addHeader("Access-Control-Allow-Origin", "*");
			resp.addHeader("Access-Control-Allow-Headers", "*");
			resp.addHeader("Access-Control-Allow-Methods", "*");

			chain.doFilter(request, response);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (jakarta.servlet.ServletException e) {

			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) {

	}

}
