package controllers.business;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Business;
import models.validators.BusinessValidator;
import utils.DBUtil;

/**
 * Servlet implementation class BusinessUpdate
 */
@WebServlet("/business/update")
public class BusinessUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Business b = em.find(Business.class, (Integer)(request.getSession().getAttribute("business_id")));

            b.setCompany_name(request.getParameter("company_name"));
            b.setTitle(request.getParameter("title"));
            b.setContent(request.getParameter("content"));
            Date plan = new Date(System.currentTimeMillis());   //仮に予定日が入力されていない場合、今日の日付が入る
            String pl_str = request.getParameter("plan");
            if(pl_str != null && !pl_str.equals("")){
                plan = Date.valueOf(pl_str);
            }
            b.setPlan(plan);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            b.setUpdated_at(currentTime);

            List<String> errors = BusinessValidator.validate(b);
            if(errors.size() > 0){

                em.close();
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("business", b);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/business/edit.jsp");
                rd.forward(request, response);

            }else{
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました");

                request.getSession().removeAttribute("business_id");

                response.sendRedirect(request.getContextPath() + "/business/index");
            }

        }
    }

}
