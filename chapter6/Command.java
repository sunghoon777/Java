package chapter6;

//명령어 클래스
public class Command {

    //명령어 메소드 이름을 담는 변수
    private String method;
    //첫 번째 인자, 두 번쨰 인자를 담는 변수
    private String firstParameter;
    private String secondParameter;

    public Command(String method, String firstParameter, String secondParameter) {
        this.method = method;
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public Command() {
        this("","","");
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFirstParameter() {
        return firstParameter;
    }

    public void setFirstParameter(String firstParameter) {
        this.firstParameter = firstParameter;
    }

    public String getSecondParameter() {
        return secondParameter;
    }

    public void setSecondParameter(String secondParameter) {
        this.secondParameter = secondParameter;
    }
}
