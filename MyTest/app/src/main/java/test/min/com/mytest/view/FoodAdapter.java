package test.min.com.mytest.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import test.min.com.mytest.R;

public class FoodAdapter extends ArrayAdapter {
    private final int resourceId;

    public FoodAdapter(Context context, int textViewResourceId, List<Food> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView,  ViewGroup parent) {
        Food food = (Food) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView foodView = (ImageView) view.findViewById(R.id.food_image);
        TextView foodName = (TextView) view.findViewById(R.id.food_name);
        TextView foodPrice = (TextView) view.findViewById(R.id.food_price);
        TextView foodAddress = (TextView) view.findViewById(R.id.food_address);
        foodView.setImageResource(food.getImageId());
        foodName.setText(food.getName());
        foodName.getPaint().setFakeBoldText(true);
        foodPrice.setText(food.getPrice());
        foodAddress.setText(food.getAddress());
        return view;
    }
}
