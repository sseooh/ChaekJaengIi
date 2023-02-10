package chaekjaengi.chaekjaengispring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String pwd;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }
}
