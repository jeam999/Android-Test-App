package alexeykafeev.android_test_app;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jeam999 on 12.01.2018.
 */

public class BubbleSort extends BaseSortedClass {


    public BubbleSort(ArrayList<? extends Mechanizm> arrayList) {
        super(arrayList);
    }

    @Override
    public ArrayList<? extends Mechanizm> Sort() {
        for (int i = arrayList.size() - 1; i > 0; i--) {
            Log.d("Sorting","Bubble "+arrayList.get(i).getClass().getCanonicalName()+"  "+i);
            for (int j = 0; j < i; j++) {
                if( arrayList.get(j).getName().charAt(0) > arrayList.get(j+1).getName().charAt(0) ){
                    String tmp = arrayList.get(j).getName();
                    arrayList.get(j).setName(arrayList.get(j+1).getName());
                    arrayList.get(j+1).setName(tmp);
                }
            }
        }
        return arrayList;
    }

    @Override
    public ArrayList<? extends Mechanizm> call() throws Exception {
        return Sort();
    }
}

