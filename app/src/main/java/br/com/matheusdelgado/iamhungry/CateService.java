package br.com.matheusdelgado.iamhungry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CateService {
    @GET("lista_comida.php")
    Call<List<Receitas>> getReceitas();
}
