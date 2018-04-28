package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import models.validators.TasksValidator;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlrt
 */
@WebServlet("/update")
public class UpdateServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlrt() {
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

	            Tasks m = em.find(Tasks.class, (Integer)(request.getSession().getAttribute("tasks_id")));

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
	            m.setUpdated_at(currentTime);

	            List<String> errors = TasksValidator.validate(m);
	            if(errors.size() > 0) {
	                em.close();

	                request.setAttribute("_token", request.getSession().getId());
	                request.setAttribute("tasks", m);
	                request.setAttribute("errors", errors);

	                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
	                rd.forward(request, response);
	            } else {
	                em.getTransaction().begin();
	                em.getTransaction().commit();
	                request.getSession().setAttribute("flush", "更新が完了しました。");
	                em.close();

	                request.getSession().removeAttribute("tasks_id");

	                response.sendRedirect(request.getContextPath() + "/index");
	            }
	}

}}
