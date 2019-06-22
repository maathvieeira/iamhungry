package br.com.matheusdelgado.iamhungry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvCate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvCate = (ListView) findViewById(R.id.lvCate);

        lvCate.setOnItemClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.100/comida/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CateService service = retrofit.create(CateService.class);

        Call<List<Receitas>> categorias = service.getReceitas();

        categorias.enqueue(new Callback<List<Receitas>>() {
            @Override
            public void onResponse(Call<List<Receitas>> call, Response<List<Receitas>> response) {
                if(response.isSuccessful()){
                    List<Receitas> listaCate = response.body();

                    CateAdapter adapter = new CateAdapter(getApplicationContext(),
                            listaCate, "");

                    lvCate.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Receitas>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
