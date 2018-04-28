package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String _token = (String)request.getParameter("_token");
	    if(_token != null && _token.equals(request.getSession().getId())) {
	        EntityManager em = DBUtil.createEntityManager();

	        Tasks m = new Tasks();

	        String title = request.getParameter("title");
	        m.setTitle(title);

	        String content = request.getParameter("content");
	        m.setContent(content);

	        String content_2 = request.getParameter("content_2");
	        m.setContent_2(content_2);


	        String startdate = request.getParameter("startdate");
	        m.setStartdate(startdate);

	        String finishdate = request.getParameter("finishdate");
	        m.setFinishdate(finishdate);

	        String priority=request.getParameter("priority");
	        m.setPriority(priority);

	        Integer finish_flag=0;
	        m.setFinish_flag(finish_flag);

	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	        m.setCreated_at(currentTime);
	        m.setUpdated_at(currentTime);

	        em.getTransaction().begin();
	        em.persist(m);
	        em.getTransaction().commit();
	        em.close();

	        response.sendRedirect(request.getContextPath() + "/index");


	}

}}
