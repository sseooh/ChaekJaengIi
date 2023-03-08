package chaekjaengi.chaekjaengispring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //이거 무조건 지워야 함!!!!! 이 놈 때문에 시간 엄청 버림....

    private String id;
    private String pwd;

    Long num;

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
