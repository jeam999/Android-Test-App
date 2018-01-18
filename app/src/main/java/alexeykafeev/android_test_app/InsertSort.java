package alexeykafeev.android_test_app;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jeam999 on 14.01.2018.
 */

public class InsertSort extends BaseSortedClass {


    public InsertSort(ArrayList<? extends Mechanizm> arrayList) {
        super(arrayList);
    }

    @Override
    public ArrayList<? extends Mechanizm> Sort() {
        {
            int j;
            String tmp;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                Log.d("Sorting","Insert "+arrayList.get(i).getClass().getCanonicalName()+"  "+i);
                if (arrayList.get(i).getName().charAt(0) > arrayList.get(i + 1).getName().charAt(0)) {
                    tmp = arrayList.get(i + 1).getName();
                    arrayList.get(i + 1).setName(arrayList.get(i).getName());
                    j = i;
                    while (j > 0 && tmp.charAt(0) < arrayList.get(j - 1).getName().charAt(0)) {
                        arrayList.get(j).setName(arrayList.get(j - 1).getName());
                        j--;
                    }
                    arrayList.get(j).setName(tmp);
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
