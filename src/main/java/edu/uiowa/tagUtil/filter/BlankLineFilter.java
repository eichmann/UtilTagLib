package edu.uiowa.tagUtil.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * This filter class removes any blank lines from the response.
 * <p>
 * This filter should be configured in the web.xml as follows:
 * 
 * <pre>
 * <filter>
 *     <description>
 *         This filter class removes any blank lines from the response.
 *     </description>
 *     <filter-name>blankLineFilter</filter-name>
 *     <filter-class>edu.uiowa.tagUtil.filter.BlankLineFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *     <filter-name>blankLineFilter</filter-name>
 *     <url-pattern>/*</url-pattern>
 * </filter-mapping>
 * </pre>
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2007/12/whitespacefilter.html
 */
public class BlankLineFilter implements Filter {

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
	//
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	if (response instanceof HttpServletResponse) {
	    HttpServletResponse httpres = (HttpServletResponse) response;
	    chain.doFilter(request, wrapResponse(httpres, createTrimWriter(httpres)));
	} else {
	    chain.doFilter(request, response);
	}
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
	//
    }

    /**
     * Create a new PrintWriter for the given HttpServletResponse which trims
     * all whitespace.
     * 
     * @param response
     *            The involved HttpServletResponse.
     * @return A PrintWriter which trims all whitespace.
     * @throws IOException
     *             If something fails at I/O level.
     */
    private static PrintWriter createTrimWriter(final HttpServletResponse response) throws IOException {
	return new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true) {
	    private StringBuilder builder = new StringBuilder();

	    public void write(int c) {
		builder.append((char) c); // It is actually a char, not an int.
	    }

	    public void write(char[] chars, int offset, int length) {
		builder.append(chars, offset, length);
		if (builder.charAt(builder.length() - 1) == '\n')
		    this.flush(); // Preflush it.
	    }

	    public void write(String string, int offset, int length) {
		builder.append(string, offset, length);
		if (builder.charAt(builder.length() - 1) == '\n')
		    this.flush(); // Preflush it.
	    }

	    // Finally override the flush method so that it trims whitespace.
	    public void flush() {
		synchronized (builder) {
		    BufferedReader reader = new BufferedReader(new StringReader(builder.toString()));
		    String line = null;

		    try {
			while ((line = reader.readLine()) != null) {
			    String temp = line.trim();
			    if (temp.length() > 0) {
				out.write(line);
				println();
			    }
			}
		    } catch (IOException e) {
			setError();
			// Log e or do e.printStackTrace() if necessary.
		    }

		    // Reset the local StringBuilder and issue real flush.
		    builder = new StringBuilder();
		    super.flush();
		}
	    }

	};
    }

    /**
     * Wrap the given HttpServletResponse with the given PrintWriter.
     * 
     * @param response
     *            The HttpServletResponse of which the given PrintWriter have to
     *            be wrapped in.
     * @param writer
     *            The PrintWriter to be wrapped in the given
     *            HttpServletResponse.
     * @return The HttpServletResponse with the PrintWriter wrapped in.
     */
    private static HttpServletResponse wrapResponse(final HttpServletResponse response, final PrintWriter writer) {
	return new HttpServletResponseWrapper(response) {
	    public PrintWriter getWriter() throws IOException {
		return writer;
	    }
	};
    }

}