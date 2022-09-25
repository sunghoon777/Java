package chapter6;

//��ɾ� Ŭ����
public class Command {

    //��ɾ� �޼ҵ� �̸��� ��� ����
    private String method;
    //ù ��° ����, �� ���� ���ڸ� ��� ����
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
