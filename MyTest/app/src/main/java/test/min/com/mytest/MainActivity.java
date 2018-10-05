package test.min.com.mytest;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import test.min.com.mytest.view.Food;
import test.min.com.mytest.view.FoodAdapter;

public class MainActivity extends AppCompatActivity {
    private List<Food> foodList = new ArrayList<Food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
        initFood();
        FoodAdapter adapter = new FoodAdapter(MainActivity.this, R.layout.food, foodList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        ImageView imageView = (ImageView) findViewById(R.id.food_image_view);
        ImageView hotelView = (ImageView) findViewById(R.id.hotel_image_view);
        ImageView taxiView = (ImageView) findViewById(R.id.taxi_image_view);
        ImageView flightView = (ImageView) findViewById(R.id.flight_image_view);
        ImageView wealthView = (ImageView) findViewById(R.id.wealth_image_view);
        ImageView rewardView = (ImageView) findViewById(R.id.reward_image_view);
        ImageView healthView = (ImageView) findViewById(R.id.health_image_view);
        ImageView eduView = (ImageView) findViewById(R.id.edu_image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });
        
        hotelView.setOnClickListener(new myClickListener());
        taxiView.setOnClickListener(new myClickListener());
        flightView.setOnClickListener(new myClickListener());
        wealthView.setOnClickListener(new myClickListener());
        rewardView.setOnClickListener(new myClickListener());
        healthView.setOnClickListener(new myClickListener());
        eduView.setOnClickListener(new myClickListener());
        getSupportActionBar().hide();
    }

    class myClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Sorry, this functionality is not implemented!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initFood() {
        Food food = new Food(R.mipmap.foodpic, "星巴克", "上海张江", "45", "13916163592", "好吃的菜");
        foodList.add(food);
        food = new Food(R.mipmap.foodpic, "很高兴遇见你", "上海张江", "89", "13916163592", "好吃的菜");
        foodList.add(food);
    }
}
