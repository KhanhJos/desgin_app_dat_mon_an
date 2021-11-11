package com.example.designapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.designapp.Adapter.CategoryAdapter;
import com.example.designapp.Adapter.FoodAdapter;
import com.example.designapp.Domain.CategoryDomain;
import com.example.designapp.Domain.FoodDomain;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView.Adapter adapterCategories, adapterFood;
    private RecyclerView rvCategories, rvFood;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.colse);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        recyclerViewCategories();
        recyclerViewFood();
    }

    private void recyclerViewCategories() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvCategories = findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Bia","bia"));
        categoryList.add(new CategoryDomain("kem","kem"));
        categoryList.add(new CategoryDomain("Kẹo mút","keomut"));
        categoryList.add(new CategoryDomain("Khoai tây chiên","khoaitaychien"));
        categoryList.add(new CategoryDomain("Ớt","ot"));
        categoryList.add(new CategoryDomain("Pizza","pizza"));
        categoryList.add(new CategoryDomain("Thịt nướng","thitnuongbbq"));

        adapterCategories = new CategoryAdapter(categoryList);
        rvCategories.setAdapter(adapterCategories);

    }

    private void recyclerViewFood() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        rvFood = findViewById(R.id.rvFood);
        rvFood.setLayoutManager(linearLayoutManager);



        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Kem", "kem", "", 10000));
        foodlist.add(new FoodDomain("Kẹo mút", "keomut", "", 5000));
        foodlist.add(new FoodDomain("Pizza", "pizza", "", 25000));
        foodlist.add(new FoodDomain("Bia", "bia", "", 15000));
        foodlist.add(new FoodDomain("Thịt nướng", "thitnuongbbq", "", 20000));
        foodlist.add(new FoodDomain("Ớt", "ot", "", 5000));

        adapterFood = new FoodAdapter(foodlist);
        rvFood.setAdapter(adapterFood);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        drawerLayout.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.food:
                Toast.makeText(this,"Món ăn",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart:
                Toast.makeText(this,"Giỏ hàng",Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                Toast.makeText(this,"Liên hệ",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
}