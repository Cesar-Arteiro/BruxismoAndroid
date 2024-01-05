package com.example.bruxismo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.bruxismo.model.ConecAPI;
import com.example.bruxismo.model.RestService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Spinner fidged; View rootView;
    String[] array_spinner_items = {"Megasena" , "Quina" , "Lotofacil" , "Lotomania" ,  "Timemania" , "Diadesorte"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = getWindow().getDecorView().getRootView();

        fidged = findViewById(R.id.sp_show);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array_spinner_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fidged.setAdapter(adapter);

        fidged.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = array_spinner_items[position].toLowerCase();
                changeBackgroundBasedOnLottery(selectedItem);
                sortear(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                changeBackgroundBasedOnLottery("nenhum");
            }
        });

    }

    public void sortear(String nome) {
        RestService rs = ConecAPI.conectarAPI();
        Call<ResponseBody> chamada = rs.Buscar(nome);

        chamada.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> chamada, Response<ResponseBody> resposta) {
                if (resposta.isSuccessful()) {
                    try {

                        String respostaDados = resposta.body().string();

                        Log.d("API", respostaDados);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    protected void changeBackgroundBasedOnLottery(String tipoSorteio) {
        String color = " ";

        switch (tipoSorteio) {
            case "lotomania":
                color = "#ffab64";
                break;
            case "megasena":
                color = "#6befa3";
                break;
            case "quina":
                color = "#8666ef";
                break;
            case "lotofacil":
                color = "#dd7ac6";
                break;
            case "timemania":
                color = "#5aad7d";
                break;
            case "diadesorte":
                color = "#bfaf83";
                break;
            default:
                color = "#ffffff";
                break;
        }

        rootView.setBackgroundColor(Color.parseColor(color));
    }
}