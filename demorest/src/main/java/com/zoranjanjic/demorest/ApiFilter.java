package com.zoranjanjic.demorest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			Date d = new Date();
			SimpleDateFormat sDf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String currentDate = sDf.format(d);
			String[] arrOfStr = currentDate.split(" ");
			String queryDate = arrOfStr[0];
			String queryTime = arrOfStr[1];

			String queryPath = req.getRequestURL().toString();
			String personName = req.getQueryString();
			String reqString = queryPath + "?" + personName;
			String idH = "200";

			historyService.saveHistoryToDb(personName, "123456789", queryDate, queryPath, queryTime, personName);

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
