package ali.firat.elvin.tr.portal.intern.web.naah;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
    }

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream input = request.getInputStream();

		final byte [] buff = new byte[512];

		int sum = 0, ret = 0;
		while((ret = input.read(buff)) != -1) {
			sum += ret;
		}

		System.out.format("Received %d bytes. \n", sum);
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream input = request.getInputStream();
		
		final byte [] buff = new byte[512];
		
		int sum = 0, ret = 0;
		while((ret = input.read(buff)) != -1) {
			sum += ret;
		}
		
		input.close();
		
		System.out.format("Post Received %d bytes. \n", sum);
	}

}
