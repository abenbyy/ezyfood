package com.example.ezyfood.util;

import com.example.ezyfood.R;
import com.example.ezyfood.database.Database;
import com.example.ezyfood.model.Item;

public class Seeder {
    public static Database db;
    public static void run(){
        db = Database.getInstance();

        db.items.add(new Item("Satisfying Salad", "Food", 20000, R.drawable.it_satisfying_salad));
        db.items.add(new Item("Almond Tofu", "Food", 25000, R.drawable.it_almond_tofu));
        db.items.add(new Item("Cold Cut Platter", "Food", 50000, R.drawable.it_cold_cut_platter));
        db.items.add(new Item("Sticky Honey Roast", "Food", 45000, R.drawable.it_sticky_honey_roast));
        db.items.add(new Item("Sweet Madame", "Food", 35000, R.drawable.it_sweet_madame));
        db.items.add(new Item("Stir Fried Fillet", "Food", 25000, R.drawable.it_stir_fried_fillet));
        db.items.add(new Item("Wanmin's Boiled Fish", "Food", 30000, R.drawable.it_wanmin_boiled_fish));
        db.items.add(new Item("Tevyat Fried Egg", "Food", 10000, R.drawable.it_tevyat_fried_egg));

        db.items.add(new Item("Apple Cider Vinegar", "Drink", 10000, R.drawable.it_apple_cider_vinegar));
        db.items.add(new Item("Berry Mint Burst", "Drink", 10000, R.drawable.it_berry_mint_burst));
        db.items.add(new Item("Wolfhook Juice", "Drink", 15000, R.drawable.it_wolfhook_juice));

        db.items.add(new Item("Chicken Mushroom Skewer", "Snack", 30000, R.drawable.it_chicken_mushroom_skewer));
        db.items.add(new Item("Fried Radish Balls", "Snack", 30000, R.drawable.it_fried_radish_balls));
        db.items.add(new Item("Grilled Tiger Fish", "Snack", 30000, R.drawable.it_grilled_tiger_fish));
        db.items.add(new Item("Mondstadt Grilled Fish", "Snack", 30000, R.drawable.it_mondstadt_grilled_fish));

    }

}
