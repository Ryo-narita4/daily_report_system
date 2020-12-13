package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "company")
@NamedQueries({
    @NamedQuery(
            name = "getAllCompanies",
            query = "SELECT c FROM Company AS c ORDER BY c.name"
            ),
    @NamedQuery(
            name = "getCompaniesCount",
            query = "SELECT COUNT(c) FROM Company AS c"
            ),
})
@Entity
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;     //主キー、自動生成

    @Column(name = "name")
    private String name;    //企業名

    @Column(name = "address")
    private String address;  //住所

    @Column(name = "charge") //担当者または代表者
    private String charge;

    @Column(name = "tell")  //電話番号
    private String tell;

    @Column(name = "mail") //メールアドレス
    private String mail;

    //getter.setter
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }




}
