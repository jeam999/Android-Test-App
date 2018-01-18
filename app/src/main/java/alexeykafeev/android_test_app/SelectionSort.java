package alexeykafeev.android_test_app;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jeam999 on 14.01.2018.
 */

public class SelectionSort extends BaseSortedClass {
    public SelectionSort(ArrayList<? extends Mechanizm> arrayList) {
        super(arrayList);
    }

    @Override
    public ArrayList<? extends Mechanizm> Sort() {
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d("Sorting","Selection: "+arrayList.get(i).getClass().getCanonicalName()+"  "+i);
            String min = arrayList.get(i).getName();
            int min_i = i;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(j).getName().charAt(0) < min.charAt(0)) {
                    min = arrayList.get(j).getName();
                    min_i = j;
                }
            }
            if (i != min_i) {
                String tmp = arrayList.get(i).getName();

                arrayList.get(i).setName(arrayList.get(min_i).getName());

                arrayList.get(min_i).setName(tmp);
            }
        }
        return arrayList;
    }

    @Override
    public ArrayList<? extends Mechanizm> call() throws Exception {
        return Sort();
    }
}
