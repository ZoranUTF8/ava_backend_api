package com.zoranjanjic.demorest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;

/**
 * Servlet Filter implementation class CorsFilter
 */
public class CorsFilter extends HttpFilter implements Filter {
       
   
	
	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		
		try {
			HttpServletResponse resp = (HttpServletResponse) response;
			
			resp.addHeader("Access-Control-Allow-Origin","*");
			resp.addHeader("Access-Control-Allow-Headers","*");
			resp.addHeader("Access-Control-Allow-Methods","*");
			
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
