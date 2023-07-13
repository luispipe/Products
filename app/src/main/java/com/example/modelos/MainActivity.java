package com.example.modelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelos.Models.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Date date;

    EditText id;
    EditText name;
    EditText brand;
    EditText provider;
    EditText price;
    EditText expirit;
    Button create;
    Button search;
    EditText idQuery;
    TextView show;

    Product showPro;

    HashMap<String,Product> listProduct= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id= findViewById(R.id.etIdProduct);
        name= findViewById(R.id.etNameProduct);
        brand= findViewById(R.id.etBrandProduct);
        provider= findViewById(R.id.etProviderProduct);
        price= findViewById(R.id.etPriceProduct);
        expirit= findViewById(R.id.etExpiritProduct);
        create= findViewById(R.id.btCreateProduct);
        idQuery= findViewById(R.id.etQueryIdProduct);
        search= findViewById(R.id.btSearchProduct);
        show= findViewById(R.id.tvShowProduct);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    modelSave();
                    Toast.makeText(getApplicationContext(),"The product was created",Toast.LENGTH_LONG).show();
                    reset();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPro= listProduct.get(idQuery.getText().toString());
                show.setText("Nombre: "+showPro.getName()+", Marca: "+showPro.getBrand()
                + "Proveedor: "+showPro.getProvider()+", Price: "+showPro.getPrice()
                +"Fecha de Vencimiento: "+showPro.getExpiritProduct());
            }
        });
        //  Product yogurt= new Product("L23","yogurt Fernando","Celema","Lacteos SA",8500.0,"01/08/2023");
    }
    public void modelSave() throws IOException {
       SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
        try {
            date= format.parse(expirit.getText().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        double pricePro= Double.parseDouble(price.getText().toString());


       String save= "{\"Id\":\""+id.getText().toString()+"\"\n\"Name\":\""+
                name.getText().toString()+"\"\n\"Brand\":\""+brand.getText().toString()+
                "\"\nProvider\":\""+provider.getText().toString()+"\"\nPrice\":\""+
                pricePro+"\"\n\"Date\":\""+date+"\"}";

        try {
            //Crear archivo
            File file= new File(getFilesDir(),"Producto.json");
            if (!file.exists()){
                file.createNewFile();
                FileWriter writer= new FileWriter(file,true);
                writer.write(save);
                writer.close();
            }
            //Se sobreescribe el archivo en vez de almacenarse el nuevo producto
            else{
                FileWriter writer= new FileWriter(file,false);
                writer.write(save);
                writer.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void reset(){
        id.setText("");
        name.setText("");
        brand.setText("");
        provider.setText("");
        price.setText("");
        expirit.setText("");
    }

    public void validateData(){
        if (id.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Id is required, please enter one data",Toast.LENGTH_LONG).show();
        }
        if (name.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Name is required, please enter one data",Toast.LENGTH_LONG).show();
        }
        if (brand.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Brand is required, please enter one data",Toast.LENGTH_LONG).show();
        }
        if (provider.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Provider is required, please enter one data",Toast.LENGTH_LONG).show();
        }
        if (price.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Price is required, please enter one data",Toast.LENGTH_LONG).show();
        }
        if (expirit.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Expirit is required, please enter one data",Toast.LENGTH_LONG).show();
        }
        if (Double.parseDouble(price.getText().toString())<0){
            Toast.makeText(MainActivity.this,"The price must be a positive number",Toast.LENGTH_LONG).show();
        }
        if (expirit.getText().toString().equals("%/%/%/")){
            String [] dateNumber= expirit.getText().toString().split("/",3);
            if(Integer.parseInt(dateNumber[1])>12 ||Integer.parseInt(dateNumber[1])<0 ){
                Toast.makeText(MainActivity.this,"Incorrect Date",Toast.LENGTH_LONG).show();
            }

        }

    }
}