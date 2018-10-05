package test.min.com.mytest;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import test.min.com.mytest.util.ServiceHelper;
import test.min.com.mytest.view.Food;
import test.min.com.mytest.view.FoodAdapter;

import static test.min.com.mytest.util.ServiceHelper.getFoodDetl;

public class FoodActivity extends AppCompatActivity {
    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    protected static final int CLICKED = 3;
    private List<Food> list;
    private LinearLayout loading;
    private EditText keyword;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case SUCCESS:
                    loading.setVisibility(View.GONE);
                    FoodAdapter adapter = new FoodAdapter(FoodActivity.this, R.layout.food, list);
                    ListView listView = (ListView) findViewById(R.id.food_list_view);
                    listView.setAdapter(adapter);
                    break;


                case ERROR:
                    Toast.makeText(FoodActivity.this, "Failed to get content from server", Toast.LENGTH_SHORT).show();
                    break;

                case CLICKED:
                    loading.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Button btnSearch = (Button) findViewById(R.id.search_button);
        loading = (LinearLayout) findViewById(R.id.loading);
        keyword = (EditText) findViewById(R.id.editText);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try{
                            Message msg = new Message();
                            msg.what = CLICKED;
                            handler.sendMessage(msg);
                            String kw = keyword.getText().toString();
                            list = ServiceHelper.getFoodDetl(URLEncoder.encode(kw));
                            for(int i = 0; i < list.size(); i++) {
                                list.get(i).setImageId(R.mipmap.foodpic);
                            }
                            msg = new Message();
                            msg.what = SUCCESS;
                            handler.sendMessage(msg);
                        }catch(Exception e){
                            Message msg = new Message();
                            msg.what = ERROR;
                            handler.sendMessage(msg);
                        }


                    }
                }).start();
//                List<Food> list = ServiceHelper.getFoodDetl(URLEncoder.encode("徐汇"));
//                FoodAdapter adapter = new FoodAdapter(FoodActivity.this, R.layout.food, list);
//                ListView listView = (ListView) findViewById(R.id.food_list_view);
//                listView.setAdapter(adapter);
            }
        });
        getSupportActionBar().hide();
    }
}
