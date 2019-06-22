package br.com.matheusdelgado.iamhungry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ReceitasAdapter extends BaseAdapter {

    private Context ctx;
    private List<Receitas> receitas;
    private String pathFotos;


    public ReceitasAdapter(Context ctx, List<Receitas> receitas, String pathFotos) {
        this.ctx = ctx;
        this.receitas = receitas;
        this.pathFotos = pathFotos;
    }

    @Override
    public int getCount() {
        return receitas.size();
    }

    @Override
    public Object getItem(int i) {
        return receitas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Receitas receita = receitas.get(i);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_receitas, null);

        ImageView imgReceita = linha.findViewById(R.id.imgGradeUm);
        TextView txtTitulo = linha.findViewById(R.id.txtNome);
        TextView txtPais = linha.findViewById(R.id.txtPais);

        Picasso.get().load(pathFotos+receita.getImagem()).into(imgReceita);
        txtTitulo.setText(receita.getNomeReceita());
        txtPais.setText(receita.getPais());

        return linha;
    }
}
