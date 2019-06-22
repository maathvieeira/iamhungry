package br.com.matheusdelgado.iamhungry;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReceitasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lvReceitas;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);

        lvReceitas = (ListView) findViewById(R.id.lvReceitas);

        lvReceitas.setOnItemClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://iamusic.tech/comida/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CateService service = retrofit.create(CateService.class);

        Call<List<Receitas>> receitas = service.getReceitas();

        receitas.enqueue(new Callback<List<Receitas>>() {
            @Override
            public void onResponse(Call<List<Receitas>> call, Response<List<Receitas>> response) {
                if(response.isSuccessful()){
                    List<Receitas> listaCate = response.body();

                    ReceitasAdapter adapter = new ReceitasAdapter(getApplicationContext(),
                            listaCate, "https://www.themealdb.com/images/media/meals/");

                    lvReceitas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Receitas>> call, Throwable t) {

            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Receitas receita = (Receitas) adapterView.getItemAtPosition(i);

        Intent intent = new Intent(this, DetalhesActivity.class);
        intent.putExtra("nomeReceita", receita.getNomeReceita());
        intent.putExtra("pais", receita.getPais());
        intent.putExtra("imagem", receita.getImagem());
        intent.putExtra("youtube", receita.getYoutube());
        intent.putExtra("ingrediente1", receita.getIngrediente1());
        intent.putExtra("ingrediente2", receita.getIngrediente2());
        intent.putExtra("ingrediente3", receita.getIngrediente3());
        intent.putExtra("ingrediente4", receita.getIngrediente4());
        intent.putExtra("ingrediente5", receita.getIngrediente5());
        intent.putExtra("ingrediente6", receita.getIngrediente6());
        intent.putExtra("ingrediente7", receita.getIngrediente7());
        intent.putExtra("ingrediente8", receita.getIngrediente8());
        intent.putExtra("ingrediente9", receita.getIngrediente9());
        intent.putExtra("ingrediente10", receita.getIngrediente10());
        intent.putExtra("preparo1", receita.getPreparo1());
        intent.putExtra("preparo2", receita.getPreparo2());
        intent.putExtra("preparo3", receita.getPreparo3());
        intent.putExtra("preparo4", receita.getPreparo4());
        intent.putExtra("preparo5", receita.getPreparo5());
        intent.putExtra("preparo6", receita.getPreparo6());
        intent.putExtra("preparo7", receita.getPreparo7());
        intent.putExtra("preparo8", receita.getPreparo8());
        intent.putExtra("preparo9", receita.getPreparo9());
        intent.putExtra("preparo10", receita.getPreparo10());
        intent.putExtra("site", receita.getSite());

        startActivity(intent);
    }

}
