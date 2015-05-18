package ee.alekseizagorovski.foodlistfromxml;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

public class FoodInfo extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_info);
        String foodSendID = getIntent().getStringExtra("foodSendID");
        Log.v(TAG, "id" + foodSendID);
        TextView foodInfoName = (TextView) findViewById(R.id.foodInfoName);
        TextView foodInfoPrice = (TextView) findViewById(R.id.foodInfoPrice);
        TextView foodInfoCalories = (TextView) findViewById(R.id.foodInfoCalories);
        TextView foodInfoDesc = (TextView) findViewById(R.id.foodInfoDesc);
        XmlPullParser foodsParser = getResources().getXml(R.xml.foods);
        HandleFoodXML handleFoodXML = new HandleFoodXML();
        Food food = handleFoodXML.getFoodDetails(foodsParser, foodSendID);
        foodInfoName.setText(food.getName());
        foodInfoPrice.setText(food.getPrice());
        foodInfoCalories.setText(food.getCalories());
        foodInfoDesc.setText(food.getDescription());
    }
}