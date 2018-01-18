package alexeykafeev.android_test_app;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by jeam999 on 17.01.2018.
 */

public class ThreadManager {
    ArrayList<ArrayList> arrayLists;

    ThreadManager(ArrayList<ArrayList> arrayLists){
        this.arrayLists=arrayLists;
    }

    public void Start(){

        for (ArrayList arrayList: arrayLists) {
            InsertSort insertSort=new InsertSort(arrayList);
            BubbleSort bubbleSort=new BubbleSort(arrayList);
            SelectionSort selectionSort=new SelectionSort(arrayList);
            ExecutorService executors = Executors.newFixedThreadPool(3);

            Future<ArrayList<? extends Mechanizm>> futureInsert=executors.submit(insertSort);
            Future<ArrayList<? extends Mechanizm>> futureBubble=executors.submit(bubbleSort);
            Future<ArrayList<? extends Mechanizm>> futureSelection=executors.submit(selectionSort);
            ArrayList<? extends Mechanizm> arrayListInsert = new ArrayList<>();
            ArrayList<? extends Mechanizm> arrayListBubble = new ArrayList<>();
            ArrayList<? extends Mechanizm> arrayListSelection = new ArrayList<>();
            ArrayList<ArrayList<? extends Mechanizm>> arrayListsSorted=new ArrayList<>();
            try {
                arrayListInsert=futureInsert.get();
                arrayListBubble=futureBubble.get();
                arrayListSelection=futureSelection.get();

                arrayListsSorted.add(arrayListInsert);
                arrayListsSorted.add(arrayListBubble);
                arrayListsSorted.add(arrayListSelection);
                executors.shutdown();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            PrintResultToLog(MainActivity.SORTING_METHOD_INSERT,arrayListInsert);
            PrintResultToLog(MainActivity.SORTING_METHOD_BUBBLE,arrayListBubble);
            PrintResultToLog(MainActivity.SORTING_METHOD_SELECTION,arrayListSelection);
            MainActivity.DataTypeFind(new String[]
                            {MainActivity.SORTING_METHOD_INSERT, MainActivity.SORTING_METHOD_BUBBLE,MainActivity.SORTING_METHOD_SELECTION}
                    ,arrayListsSorted);

        }

    }

    void PrintResultToLog(String sortType,ArrayList<? extends Mechanizm> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            Log.d("Result "+sortType+"  dataType:  "+arrayList.get(i).getClass().getSimpleName()+" :","\n "+arrayList.get(i).getName());
        }
    }

}
