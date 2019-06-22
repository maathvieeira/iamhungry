package br.com.matheusdelgado.iamhungry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CateAdapter extends BaseAdapter {

    private Context ctx;
    private List<Receitas> categories;
    private String pathFotos;

    public CateAdapter(Context ctx, List<Receitas> categories, String pathFotos) {
        this.ctx = ctx;
        this.categories = categories;
        this.pathFotos = pathFotos;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Receitas category = categories.get(i);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_lista, null);

        TextView txtTitulo = linha.findViewById(R.id.txtCatego);

        txtTitulo.setText(category.getNomeReceita());

        return linha;
    }
}
