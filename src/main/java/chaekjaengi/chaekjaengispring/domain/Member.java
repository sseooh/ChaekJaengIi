package chaekjaengi.chaekjaengispring.domain;

import javax.persistence.Entity;

@Entity
public class Member {

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
