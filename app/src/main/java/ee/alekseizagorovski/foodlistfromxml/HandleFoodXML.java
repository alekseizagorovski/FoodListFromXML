package ee.alekseizagorovski.foodlistfromxml;

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;

public class HandleFoodXML {
    private static final String TAG = "HandleFoodXML";


    public ArrayList<Food> getFoodList(XmlPullParser foodsParser) {
        ArrayList<Food> foodsList = new ArrayList<Food>();

        try {
            int eventType = foodsParser.getEventType();
            String name = "";
            String id = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name1 = foodsParser.getName();
                if (eventType == XmlPullParser.START_TAG && name1.equals("name")) {

                    id = foodsParser.getAttributeValue(null, "food_id");
                    foodsParser.next();
                    name = foodsParser.getText();

                }
                if (eventType == XmlPullParser.START_TAG && name1.equals("price")) {
                    foodsParser.next();
                    String price = foodsParser.getText();
                    foodsList.add(new Food(id, name, price));
                    Log.v(TAG, "id" + id + name + price);
                }
                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());
        }
        return foodsList;
    }

    public Food getFoodDetails(XmlPullParser foodsParser, String foodSendID) {
        Food food = new Food();
        try {
            int eventType = foodsParser.getEventType();
            String name = "";
            String id = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name1 = foodsParser.getName();
                if (eventType == XmlPullParser.START_TAG && name1.equals("name")) {

                    id = foodsParser.getAttributeValue(null, "food_id");
                    if (id.equals(foodSendID)) {
                        foodsParser.next();
                        name = foodsParser.getText();
                        food.setName(name);

                        foodsParser.next();
                        foodsParser.next();
                        foodsParser.next();
                        String price = foodsParser.getText();
                        food.setPrice(price);

                        foodsParser.next();
                        foodsParser.next();
                        foodsParser.next();
                        String description = foodsParser.getText();
                        food.setDescription(description);

                        foodsParser.next();
                        foodsParser.next();
                        foodsParser.next();
                        String calories = foodsParser.getText();

                        food.setCalories(calories);
                        break;
                    }
                }

                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());

        }
        return food;
    }

}
