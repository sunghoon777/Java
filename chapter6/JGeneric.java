package chapter6;

public class JGeneric<W> {

    private W x,y;

    public JGeneric(W x, W y) {
        this.x = x;
        this.y = y;
    }

    public W first(){
        return this.x;
    }

    public W second(){
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        JGeneric<W> value = (JGeneric<W>) obj;
        if(this.x.equals(value.first())&&this.y.equals(value.second())){
            return true;
        }
        return false;
    }
}
