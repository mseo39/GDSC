"""
다음을 읽고 member 클래스를 작성하세요
회원 클래스에는 id,name,point가 있고
각 필드의 접근자와 지정자를 남들어 준다
"""

public class Member{
    private String id;
    private String name;
    private int point;

    public void setName(String n){
        this.name=n;
    }
    public String getName(){
        return this.name;
    }
    public void setId(String I){
        this.id=I;
    }
    public String getName(){
        return this.id;
    }
    public void setName(int p){
        this.point=p;
    }
    public int getName(){
        return this.point;
    }
}