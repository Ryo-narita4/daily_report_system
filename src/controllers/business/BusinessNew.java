package controllers.business;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Business;
import models.Company;
import utils.DBUtil;

/**
 * Servlet implementation class BusinessNew
 */
@WebServlet("/business/new")
public class BusinessNew extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessNew() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Company c = em.find(Company.class , Integer.parseInt(request.getParameter("id")));

        em.close();

        Business b = new Business();

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("business", b);
        request.setAttribute("company", c);
        request.getSession().setAttribute("companyId", c.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/business/new.jsp");
        rd.forward(request, response);
    }

}
