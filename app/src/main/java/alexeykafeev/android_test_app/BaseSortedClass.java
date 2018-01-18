package alexeykafeev.android_test_app;

import java.util.ArrayList;
import java.util.concurrent.Callable;


/**
 * Created by jeam999 on 12.01.2018.
 */

abstract public class BaseSortedClass implements Callable<ArrayList<? extends Mechanizm>> {
    ArrayList<? extends Mechanizm> arrayList;

    public BaseSortedClass(ArrayList<? extends Mechanizm> arrayList){
        this.arrayList=arrayList;
    }

    abstract public ArrayList Sort();

}
