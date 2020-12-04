package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "business")
@NamedQueries({
    @NamedQuery(
            name = "getAllBusinesses",
            query = "SELECT b FROM Business As b ORDER BY b.id DESC "
            ),
    @NamedQuery(
            name = "getBusinessesCount",
            query = "SELECT COUNT(b) FROM Business As b"
            ),
})
@Entity
public class Business {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "title" , length = 50 , nullable = false)
    private String title;

    @Column(name = "company_name" , nullable = false)
    private String company_name;

    @Lob
    @Column(name = "content" , nullable = false)
    private String content;

    @Column(name = "plan" , nullable = false) //次の対応日
    private Date plan;

    @Column(name = "created_at" , nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at" , nullable = false)
    private Timestamp updated_at;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPlan() {
        return plan;
    }

    public void setPlan(Date plan) {
        this.plan = plan;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }





}
