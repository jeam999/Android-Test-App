package alexeykafeev.android_test_app;

/**
 * Created by jeam999 on 11.01.2018.
 */

public class Mechanizm {
    String name;

    public Mechanizm(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Vehicle extends Mechanizm {
    public Vehicle(String name) {
        super(name);
    }
}

class Plane extends Mechanizm {
    public Plane(String name) {
        super(name);
    }
}

class Ship extends Mechanizm {
    public Ship(String name) {
        super(name);
    }
}

