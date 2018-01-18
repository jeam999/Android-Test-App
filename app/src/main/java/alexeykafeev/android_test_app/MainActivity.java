package alexeykafeev.android_test_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static ArrayList<Vehicle> vehicles = new ArrayList<>();
    public static ArrayList<Plane> planes = new ArrayList<>();
    public static ArrayList<Ship> ships = new ArrayList<>();

    public static ArrayList<LinearLayout> linearLayoutSortingList =new ArrayList<>();

    public static TextView textArrayNamePOne;
    public static LinearLayout layoutArrayPOne;

    public static TextView textArrayNamePTwo;
    public static LinearLayout layoutArrayPTwo;

    public static TextView textArrayNamePthree;
    public static LinearLayout layoutArrayPThree;

    public static Context context;

    public static final String SORTING_METHOD_INSERT="INSERT";
    public static final String SORTING_METHOD_BUBBLE="BUBBLE";
    public static final String SORTING_METHOD_SELECTION="SELECTION";

    public static final String TYPE_NAME_VEHICLE="Vehicle";
    public static final String TYPE_NAME_PLANE="Plane";
    public static final String TYPE_NAME_SHIP="Ship";

    public static final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    public static final LinearLayout.LayoutParams Weight = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textArrayNamePOne=(TextView)findViewById(R.id.textArrayNamePOne);
        layoutArrayPOne=(LinearLayout)findViewById(R.id.layoutArrayPOne);

        textArrayNamePTwo=(TextView)findViewById(R.id.textArrayNamePTwo);
        layoutArrayPTwo=(LinearLayout)findViewById(R.id.layoutArrayPTwo);

        textArrayNamePthree=(TextView)findViewById(R.id.textArrayNamePthree);
        layoutArrayPThree=(LinearLayout)findViewById(R.id.layoutArrayPThree);

        context=this;

        setData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startService(new Intent(this, ThreadInService.class));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    public static void DataTypeFind(String[] sortingTypes,ArrayList<ArrayList<? extends Mechanizm>> arrayLists){
        Log.d("NAME CASE",arrayLists.get(0).get(0).getClass().getSimpleName());
        switch (arrayLists.get(0).get(0).getClass().getSimpleName()){
            case TYPE_NAME_VEHICLE:{
                LinearLayout linearLayoutSorting=new LinearLayout(context);
                //linearLayoutSortingList.add(new LinearLayout(context));
                textArrayNamePOne.setText(arrayLists.get(0).get(0).getClass().getSimpleName());
                layoutArrayPOne.addView(putFirstArrayToTextViews(linearLayoutSorting,sortingTypes,arrayLists));
                break;
            }
            case TYPE_NAME_SHIP:{
                LinearLayout linearLayoutSorting=new LinearLayout(context);
                textArrayNamePTwo.setText(arrayLists.get(0).get(0).getClass().getSimpleName());
                layoutArrayPTwo.addView(putFirstArrayToTextViews(linearLayoutSorting,sortingTypes,arrayLists));
                break;
            }
            case TYPE_NAME_PLANE:{
                LinearLayout linearLayoutSorting=new LinearLayout(context);
                textArrayNamePthree.setText(arrayLists.get(0).get(0).getClass().getSimpleName());
                layoutArrayPThree.addView(putFirstArrayToTextViews(linearLayoutSorting,sortingTypes,arrayLists));
                break;
            }
        }
    }

    public static LinearLayout putFirstArrayToTextViews(LinearLayout linearLayoutSorting,String[] sortingTypes,ArrayList<ArrayList<? extends Mechanizm>> arrayLists){
        //LinearLayout linearLayoutSorting=new LinearLayout(context);

        linearLayoutSorting.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < arrayLists.size(); i++) {

            TextView textViewValues=new TextView(context,null,R.style.textValues);
            TextView textViewSortingName=new TextView(context,null,R.style.textSortingName);
            LinearLayout linearLayoutSortingMethod=new LinearLayout(context);
            linearLayoutSortingMethod.setOrientation(LinearLayout.VERTICAL);
            linearLayoutSorting.setLayoutParams(Weight);

            textViewSortingName.setText(sortingTypes[i]);
            ArrayList<? extends Mechanizm> arrayList=arrayLists.get(i);
            for (int j = 0; j < arrayList.size(); j++) {

                textViewValues.setText(textViewValues.getText()+arrayList.get(j).getName()+"\n\n");
            }
            linearLayoutSortingMethod.addView(textViewSortingName);
            textViewSortingName.setTextAppearance(context,R.style.textSortingName);
            linearLayoutSortingMethod.addView(textViewValues);
            textViewValues.setTextAppearance(context,R.style.textValues);
            linearLayoutSorting.addView(linearLayoutSortingMethod);
            linearLayoutSorting.setLayoutParams(Weight);
        }
        return linearLayoutSorting;



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inser_vech) {
            // Handle the camera action
        } else if (id == R.id.inser_planes) {

        } else if (id == R.id.insert_ships) {
        } else if (id == R.id.use_sandart_list) {
        } else if (id == R.id.sort_list) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void setData() {
        vehicles.addAll(Arrays.asList(
                new Vehicle("Dacia")
                , new Vehicle("Ssangyong")
                , new Vehicle("Nissan")
                , new Vehicle("Toyota")
                , new Vehicle("Mazda")
                , new Vehicle("Subaru")
                , new Vehicle("Suzuki")
                , new Vehicle("Hyundai")
                , new Vehicle("Volkswagen")
                , new Vehicle("Opel")
                , new Vehicle("Peugeot")
                , new Vehicle("Citroen")
                , new Vehicle("Fiat")
                , new Vehicle("Lexus")
                , new Vehicle("Acura")
                , new Vehicle("BMW")
                , new Vehicle("Mercedes-Benz")
                , new Vehicle("Audi")
                , new Vehicle("Aston Martin")
                , new Vehicle("Lamborghini")
                , new Vehicle("Porsche")
        ));

        planes.addAll(Arrays.asList(
                new Plane("Cessna 172")
                , new Plane("Ilyushin Il-2")
                , new Plane("Messerschmitt Bf 109")
                , new Plane("Piper PA-28 series")
                , new Plane("Cessna 150 / 152")
                , new Plane("Cessna 182")
                , new Plane("Focke-Wulf Fw 190")
                , new Plane("Douglas DC-3")
                , new Plane("Bell UH-1 \"Huey\" Iroquois")
                , new Plane("Republic P-47 Thunderbolt")
                , new Plane("North American P-51 Mustang")
                , new Plane("North American T-6 Texan")
                , new Plane("Junkers Ju 88")
                , new Plane("Waco CG-4")
                , new Plane("Avro Anson")
                , new Plane("Grumman F6F Hellcat")
                , new Plane("Mitsubishi A6M Zero")
                , new Plane("Mikoyan-Gurevich MiG-17")
                , new Plane("Lockheed P-38 Lightning")
                , new Plane("Piper PA-18")
                , new Plane("Beechcraft Model 18")
                , new Plane("Yakovlev Yak-18")
                , new Plane("Avro 504")
                , new Plane("Yakovlev Yak-1")
                , new Plane("SPAD S.XIII")
                , new Plane("de Havilland Mosquito")
                , new Plane("Heinkel He 111")
                , new Plane("Tupolev SB")
                , new Plane("Junkers Ju 87")
                , new Plane("Lavochkin La-7")
                , new Plane("Douglas SBD Dauntless")
        ));

        ships.addAll(Arrays.asList(
                new Ship("903 – Iranian")
                , new Ship("USS Abraham Lincoln")
                , new Ship("Academic Vladislav Volkov")
                , new Ship("MS Antonia Graza")
                , new Ship("SS Andes")
                , new Ship("USS Aspen")
                , new Ship("HMS Bedford")
                , new Ship("Argo")
                , new Ship("HMS Avenger")
                , new Ship("Brandenburg")
                , new Ship("Caledonia II")
                , new Ship("USS Charleston")
                , new Ship("Deep Quest")
                , new Ship("Dulcibella")
                , new Ship("Disco Volante")
                , new Ship("Empress")
                , new Ship("Elizabeth Dane")
                , new Ship("MS Ergenstrasse")
                , new Ship("Ghost")
                , new Ship("Gloria N")
                , new Ship("The Henrietta")
                , new Ship("Immer Essen")
                , new Ship("Jenny")
                , new Ship("Liparus")
                , new Ship("Mary Deare")
                , new Ship("Morning Star")
                , new Ship("Nathan Ross")
                , new Ship("Orca")
                , new Ship("Pequod")
                , new Ship("Proteus")
                , new Ship("Saracen")
                , new Ship("Tugboat Annie")
        ));
    }


}
