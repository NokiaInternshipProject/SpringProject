package ali.firat.elvin.tr.portal.intern.web.naah;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class UploadReport
 */

/*@WebServlet("/uploadServer")*/
public class UploadReport extends HttpServlet{
    private static final long serialVersionUID = 1L;


    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public UploadReport() {
        super();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        System.out.println("uploadServer worked!!!");
        final File reportBase = new File(getServletContext().getRealPath("/FestReports"));
        if (!reportBase.exists()) {
            reportBase.mkdirs();
        }

        File reportFile = null;
        String line = input.readLine();
        if (line != null && line.startsWith("Femto Id:")) {
            String[] vals = line.split(":");
            reportFile = new File(reportBase, vals[1] + ".txt");
        }
        // Else Return error
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        PrintWriter output = new PrintWriter(reportFile);
        while ((line = input.readLine()) != null) {
            output.println(line);
        }

        input.close();
        output.close();
    }

}
