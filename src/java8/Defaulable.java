package java8;

public interface Defaulable {
    default String notRequired(){
        return "default test start!";
    }

    static String create(){
        System.out.println("static test start!");
        return null;
    }
}

class  DefaulableImpl implements Defaulable{

}

class  OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "override it";
    }

    public static void main(String[] args) {
        String ss=Defaulable.create();
    }
}

