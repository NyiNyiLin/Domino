package com.nyi.domino.domino;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_phyaw_yay,btn_a_thee,btn_milk,btn_other;
    Button btn_item_1,btn_item_2,btn_item_3,btn_item_4,btn_item_5,btn_item_6,btn_item_7,btn_item_8,btn_item_9,btn_item_10;
    Button btn_quantity_1,btn_quantity_2,btn_quantity_3,btn_quantity_4,btn_quantity_5,btn_quantity_other;
    Button btn_OK;
    TextView total_quant,total_amount;
    FloatingActionButton fab;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    int item_num=99; //99 is only for checking that the item is selected or not
    int quantity_num=0; //0 is only for checking quantiy is seleccted or not
    int type_num=9; //9 is only for checking that the type is pressed once or not
    Boolean isMore=false;

    ArrayList<Cold_Drink> cold_drinks_list=new ArrayList<Cold_Drink>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final String phayw_yay_array1[][]={  {"သဘူး","200"},
                                            {"ဇီး","200"},
                                            {"သစ်ခ","200"}};

        final String phayw_yay_array[][]={  {"ေက်ာက္ေက်ာ / ဇီး / သစ္ခြ / သံဘူး / ဘာလီ / သရက္ / လိေမၼာ္ / နာနတ္ / မန္းက်ည္း","200"},
                                            {"သံပရာေက်ာက္ေက်ာ / ဇီးသံပရာ / သစ္ခြေက်ာက္ေက်ာ / ဇီးေက်ာက္ေက်ာ / မန္းက်ည္းေက်ာက္ေက်ာ","300"},
                                            {"ႏို႔ေက်ာက္ေက်ာ / ႏို႔သစ္ခြ  / ႏို႔ဇီး ","400"}};

        final String fruit_array[][]={  {"ေထာပတ္သီး ေဖ်ာ္ရည္","600"},
                                        {"စေတာ္ဘယ္ရီသီး ေဖ်ာ္ရည္","500"},
                                        {"ပန္းသီး ေဖ်ာ္ရည္","500"},
                                        {"ငွက္ေပ်ာသီး ေဖ်ာ္ရည္","400"},
                                        {"သေဘၤာသီး ေဖ်ာ္ရည္","400"},
                                        {"နာနတ္သီး ေဖ်ာ္ရည္","400"},
                                        {"  ၾကက္ဥေထာပတ္","800"},
                                        {" ၾကက္ဥငွက္ေပ်ာ","600"},
                                        {" ၾကက္ဥသံပရာ","500"},
                                        {"သံပရာသီး ေဖ်ာ္ရည္","200"}};

        final String milk_array[][]={   {"ဖာလူဒါ","1000"},
                                        {"ဒိုမီႏို","1000"},
                                        {"ဒူးမလိုင္","1000"},
                                        {"သီးစံု","800"},
                                        {"Milk Shake","400"},
                                        {"Jelly Shake","500"},
                                        {"Coffee Float","700"},
                                        {"Coffee Shake","500"},
                                        {"ႏို႔ပုလဲ","500"},
                                        {"ဒိန္ခ်ဥ္","500"}};

        final String other_array[][]={
                {"Birthday ေရခဲမုန္႔","1200"},
                {"ေရခဲမုန္႔" ,"400"},
                {"ေရခဲသုပ္","500"},
                {"ပူတင္း","400"}
        };


        btn_phyaw_yay=(Button) findViewById(R.id.phyaw_yay);
        btn_a_thee=(Button) findViewById(R.id.a_tee);
        btn_milk=(Button) findViewById(R.id.milk);
        btn_other=(Button) findViewById(R.id.other);

        btn_item_1=(Button) findViewById(R.id.item_1);
        btn_item_2=(Button) findViewById(R.id.item_2);
        btn_item_3=(Button) findViewById(R.id.item_3);
        btn_item_4=(Button) findViewById(R.id.item_4);
        btn_item_5=(Button) findViewById(R.id.item_5);
        btn_item_6=(Button) findViewById(R.id.item_6);
        btn_item_7=(Button) findViewById(R.id.item_7);
        btn_item_8=(Button) findViewById(R.id.item_8);
        btn_item_9=(Button) findViewById(R.id.item_9);
        btn_item_10=(Button) findViewById(R.id.item_10);

        btn_quantity_1=(Button) findViewById(R.id.quantity_1);
        btn_quantity_2=(Button) findViewById(R.id.quantity_2);
        btn_quantity_3=(Button) findViewById(R.id.quantity_3);
        btn_quantity_4=(Button) findViewById(R.id.quantity_4);
        btn_quantity_5=(Button) findViewById(R.id.quantity_5);
        btn_quantity_other=(Button) findViewById(R.id.quantity_other);

        btn_OK=(Button) findViewById(R.id.ok);
        //btn_total=(Button) findViewById(R.id.btn_total);

        total_quant=(TextView) findViewById(R.id.textview_total_quantity_in_cardview);
        total_amount=(TextView) findViewById(R.id.textview_total_amount_in_cardview);

        fab=(FloatingActionButton) findViewById(R.id.fab);

        final Button btn_item_array[]={btn_item_1,btn_item_2,btn_item_3,btn_item_4,btn_item_5,btn_item_6,btn_item_7,btn_item_8,btn_item_9,btn_item_10};
        final Button btn_cold_drink_array[]={btn_phyaw_yay,btn_a_thee,btn_milk,btn_other};
        final Button btn_quantity_array[]={btn_quantity_1,btn_quantity_2,btn_quantity_3,btn_quantity_4,btn_quantity_5,btn_quantity_other};
        final int color_array[]={Color.BLUE,Color.RED,Color.MAGENTA ,Color.CYAN};

        //This is for card view
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CardViewAdapter(cold_drinks_list);
        mRecyclerView.setAdapter(mAdapter);

/*

        //This is for setting color
        btn_phyaw_yay.setTextColor(Color.BLUE);
        btn_a_thee.setTextColor(Color.RED);
        btn_milk.setTextColor(Color.YELLOW);
        btn_other.setTextColor(Color.GRAY);
*/


        btn_phyaw_yay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_Item_In_Button(phayw_yay_array, btn_item_array);
                setColor_In_Buttons(0, btn_cold_drink_array);
                type_num=0;
                item_num=99;


            }
        });
        btn_a_thee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_Item_In_Button(fruit_array,btn_item_array);
                setColor_In_Buttons(1, btn_cold_drink_array);
                type_num=1;
                item_num=99;
            }
        });

        btn_milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_Item_In_Button(milk_array, btn_item_array);
                setColor_In_Buttons(2, btn_cold_drink_array);
                type_num=2;
                item_num=99;

            }
        });

        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_Item_In_Button(other_array,btn_item_array);
                setColor_In_Buttons(3, btn_cold_drink_array);
                type_num=3;
                item_num=99;
            }
        });

        for(int a=0; a<btn_quantity_array.length; a++){
            final Button btn_quantity=btn_quantity_array[a];
            final int finalA = a+1;
            final int finalA1 = a;
            btn_quantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quantity_num= finalA;
                    setColor_In_Buttons(finalA1,btn_quantity_array);
                    btn_quantity_other.setText("More");
                }
            });
        }
        btn_quantity_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_input_quantity_DialogBox();
            }
        });

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isSelected()){
                    switch (type_num) {
                        case 0:
                            assign_drinklist_to_adapter(phayw_yay_array);
                            break;
                        case 1:
                            assign_drinklist_to_adapter(fruit_array);
                            break;
                        case 2:
                            assign_drinklist_to_adapter(milk_array);
                            break;
                        case 3:
                            assign_drinklist_to_adapter(other_array);
                            break;
                    }
                    if(isMore){
                        quantity_num= 1;
                        setColor_In_Buttons(quantity_num-1,btn_quantity_array);
                        btn_quantity_other.setText("More");
                        isMore=false;
                    }
                }
            }
        });

        //To clear all of data
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cold_drinks_list.clear();
                mAdapter=new CardViewAdapter(cold_drinks_list);
                mRecyclerView.setAdapter(mAdapter);
                cal_total();
                /*item_num=99;
                quantity_num=0;
                type_num=9;*/
            }
        });


    }
    @Override
    public void onResume() {
        super.onResume();
        ((CardViewAdapter) mAdapter).setOnItemClickListener(new CardViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i("Adapter Clicked", " Clicked on Item " + position);
                ((CardViewAdapter) mAdapter).deleteKey(position);
                //cold_drinks_list.remove(position);

                cal_total();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent in=new Intent(this,Developer_Activity.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*
        This is the testing method to test the adapter with fake data
         */
    private ArrayList<Cold_Drink> getDataSet() {
        ArrayList<Cold_Drink> cold_drinks_list=new ArrayList<Cold_Drink>();
        cold_drinks_list.add(new Cold_Drink("Domino", 1000, 5, 5000));
        cold_drinks_list.add(new Cold_Drink("Faludar", 1000, 3, 3000));

        return cold_drinks_list;
    }

    /*
    This is the helper function to set the text in item button
     */
    private void set_Item_In_Button(String item_name_array[][], final Button button_item_array[]){
        int count=0;
        for(int a=0; a<item_name_array.length; a++){
            Button button=button_item_array[a];
            button.setText(item_name_array[a][0]);
            button.setTextColor(Color.BLUE);
            button.setEnabled(true);
            button.setBackgroundResource(R.drawable.custom_button);
            count++;

            final int finalA = a;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item_num = finalA;
                    setColor_In_Buttons(finalA, button_item_array);

                }
            });
        }
        for(int b=count; b<button_item_array.length; b++){
            Button button=button_item_array[b];
            button.setEnabled(false);
            button.setText("");
            button.setBackgroundResource(R.drawable.custom_pressed);
        }
    }
    /*
    This is helper function to set Color in cold drink

     */
    private void setColor_In_Buttons(int position, Button buttons_array[]){
        Button pressed_button=buttons_array[position];
        pressed_button.setTextColor(Color.WHITE);
        pressed_button.setBackgroundResource(R.drawable.custom_button_pressed);

        for(int a=0; a<position;a++){
            Button buttons=buttons_array[a];
            if(buttons.isEnabled()) {
                buttons.setTextColor(Color.BLUE);
                buttons.setBackgroundResource(R.drawable.custom_button);
            }
        }
        for(int b=buttons_array.length-1; b>position; b--){
            Button buttons=buttons_array[b];
            if(buttons.isEnabled()) {
                buttons.setTextColor(Color.BLUE);
                buttons.setBackgroundResource(R.drawable.custom_button);
            }
        }
    }

    /*
    This is the helper function to set coldrink to coldrink arraylist and then to the adapter
     */
    private void assign_drinklist_to_adapter(String items_array[][]){
        Cold_Drink cold_drink=new Cold_Drink(items_array[item_num][0],Integer.parseInt(items_array[item_num][1]),quantity_num,Integer.parseInt(items_array[item_num][1])*quantity_num);
        cold_drinks_list=CardViewAdapter.getOrder_List();
        cold_drinks_list.add(cold_drink);
        mAdapter = new CardViewAdapter(cold_drinks_list);
        mRecyclerView.setAdapter(mAdapter);

        cal_total();
    }

    /*
    This is the helper function to check the type, item, and quantity is selected or not
     */
    private Boolean isSelected(){
        Boolean isSelect=false;
        if(type_num==9) {
            Toast.makeText(getApplication(),"Please Select Type",Toast.LENGTH_SHORT).show();
        }
        else if(item_num==99) {
            Toast.makeText(getApplication(),"Pleace Select item",Toast.LENGTH_SHORT).show();
        }
        else if(quantity_num==0) {
            Toast.makeText(getApplication(),"Pleace Select Quantity",Toast.LENGTH_SHORT).show();
        }
        else isSelect=true;
        return  isSelect;
    }

    /*
    This is the helper function to calculate total quantity and amount
     */
    private void cal_total(){
        cold_drinks_list=CardViewAdapter.getOrder_List();
        int total_price=0;
        int total_quantity=0;
        for(int a=0; a<cold_drinks_list.size(); a++){
            total_price=total_price+cold_drinks_list.get(a).getPrice();
            total_quantity=total_quantity+cold_drinks_list.get(a).getQuantity();
        }
        Log.i("Quantity","total quantity "+total_quantity);
        total_amount.setText(total_price+"");
        total_quant.setText(total_quantity+"");
    }
    /*
    This is the helper function to input custom quantity
     */

    private void Open_input_quantity_DialogBox() {
        final Button btn_quantity_array[]={btn_quantity_1,btn_quantity_2,btn_quantity_3,btn_quantity_4,btn_quantity_5,btn_quantity_other};


        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View promptView = layoutInflater.inflate(R.layout.pop_up_input_quantity_layout, null);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Custon input");
        alert.setView(promptView);

        final TextView input_quantity=(TextView)promptView.findViewById(R.id.pop_up_edit_test);
        input_quantity.requestFocus();
        input_quantity.setTextColor(Color.BLACK);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String input_word=input_quantity.getText().toString();

                if(input_word.compareTo("")==0){
                    Open_input_quantity_DialogBox();
                }
                else{
                    quantity_num = Integer.parseInt(input_word);
                    btn_quantity_other.setText("x" + quantity_num + "");
                    setColor_In_Buttons(5, btn_quantity_array);
                    isMore = true;
                }

            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // create an alert dialog
        AlertDialog alert1 = alert.create();

        alert1.show();

    }

}
