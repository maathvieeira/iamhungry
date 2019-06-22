package br.com.matheusdelgado.iamhungry;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetalhesActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth auth;
    FirebaseUser user;

    private ImageView imgGandeDois;
    private TextView txtPaisDetalhe;
    private TextView txtNomeDetalhe;
    private TextView txtIngrdientesUm;
    private TextView txtIngrdientesDois;
    private TextView txtIngrdientesTres;
    private TextView txtIngrdientesQua;
    private TextView txtIngrdientesCinc;
    private TextView txtIngrdientesSeis;
    private TextView txtIngrdientesSete;
    private TextView txtIngrdientesOito;
    private TextView txtIngrdientesNove;
    private TextView txtIngrdientesDez;
    private TextView txtPrepUm;
    private TextView txtPrepDois;
    private TextView txtPrepTres;
    private TextView txtPrepQua;
    private TextView txtPrepCinc;
    private TextView txtPrepSeis;
    private TextView txtPrepSete;
    private TextView txtPrepOito;
    private TextView txtPrepNove;
    private TextView txtPrepDez;
    private TextView txtSite;
    private Button btnSite;
    private Button btnYoutube;
    private ImageButton imgButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        imgGandeDois = findViewById(R.id.imgGrandeDois);
        txtPaisDetalhe = findViewById(R.id.txtPaisDetalhe);
        txtNomeDetalhe = findViewById(R.id.txtNomeDetalhe);
        txtIngrdientesUm = findViewById(R.id.ingredientesUm);
        txtIngrdientesDois = findViewById(R.id.ingredientesdois);
        txtIngrdientesTres = findViewById(R.id.ingredientesTres);
        txtIngrdientesQua = findViewById(R.id.ingredientesQua);
        txtIngrdientesCinc = findViewById(R.id.ingredientesCin);
        txtIngrdientesSeis = findViewById(R.id.ingredientesSeis);
        txtIngrdientesSete = findViewById(R.id.ingredientesSete);
        txtIngrdientesOito = findViewById(R.id.ingredientesOito);
        txtIngrdientesNove = findViewById(R.id.ingredientesNove);
        txtIngrdientesDez = findViewById(R.id.ingredientesDez);
        txtPrepUm = findViewById(R.id.prepUm);
        txtPrepDois = findViewById(R.id.prepDois);
        txtPrepTres = findViewById(R.id.prepTres);
        txtPrepQua = findViewById(R.id.prepQua);
        txtPrepCinc = findViewById(R.id.prepCin);
        txtPrepSeis = findViewById(R.id.prepSeis);
        txtPrepSete = findViewById(R.id.prepSete);
        txtPrepOito = findViewById(R.id.prepOito);
        txtPrepNove = findViewById(R.id.prepNove);
        txtPrepDez = findViewById(R.id.prepDez);
        txtSite = findViewById(R.id.btnSite);
        btnSite = findViewById(R.id.btnSite);
        btnYoutube = findViewById(R.id.btnYoutube);
        imgButtonBack = findViewById(R.id.imgButtonBack);

        btnSite.setOnClickListener(this);
        btnYoutube.setOnClickListener(this);
        imgButtonBack.setOnClickListener(this);

        Intent intent = getIntent();
        String nomeDetalhe = intent.getStringExtra("nomeReceita");
        String paisDetalhe = intent.getStringExtra("pais");
        String foto = intent.getStringExtra("imagem");
        String ingredientesUm = intent.getStringExtra("ingrediente1");
        String ingredientesDois = intent.getStringExtra("ingrediente2");
        String ingredientesTres = intent.getStringExtra("ingrediente3");
        String ingredientesQua = intent.getStringExtra("ingrediente4");
        String ingredientesCinc = intent.getStringExtra("ingrediente5");
        String ingredientesSeis = intent.getStringExtra("ingrediente6");
        String ingredientesSete = intent.getStringExtra("ingrediente7");
        String ingredientesOito = intent.getStringExtra("ingrediente8");
        String ingredientesNove = intent.getStringExtra("ingrediente9");
        String ingredientesDez = intent.getStringExtra("ingrediente10");

        String propUm = intent.getStringExtra("preparo1");
        String propDois = intent.getStringExtra("preparo2");
        String propTres = intent.getStringExtra("preparo3");
        String propQua = intent.getStringExtra("preparo4");
        String propCinco = intent.getStringExtra("preparo5");
        String propSeis = intent.getStringExtra("preparo6");
        String propSete = intent.getStringExtra("preparo7");
        String propOito = intent.getStringExtra("preparo8");
        String propNove = intent.getStringExtra("preparo9");
        String propDez = intent.getStringExtra("preparo10");

        txtNomeDetalhe.setText(nomeDetalhe);
        txtPaisDetalhe.setText(paisDetalhe);
        Picasso.get().load("https://www.themealdb.com/images/media/meals/"+foto).into(imgGandeDois);
        txtIngrdientesUm.setText(ingredientesUm);
        txtIngrdientesDois.setText(ingredientesDois);
        txtIngrdientesTres.setText(ingredientesTres);
        txtIngrdientesQua.setText(ingredientesQua);
        txtIngrdientesCinc.setText(ingredientesCinc);
        txtIngrdientesSeis.setText(ingredientesSeis);
        txtIngrdientesSete.setText(ingredientesSete);
        txtIngrdientesOito.setText(ingredientesOito);
        txtIngrdientesNove.setText(ingredientesNove);
        txtIngrdientesDez.setText(ingredientesDez);

        txtPrepUm.setText(propUm);
        txtPrepDois.setText(propDois);
        txtPrepTres.setText(propTres);
        txtPrepQua.setText(propQua);
        txtPrepCinc.setText(propCinco);
        txtPrepSeis.setText(propSeis);
        txtPrepSete.setText(propSete);
        txtPrepOito.setText(propOito);
        txtPrepNove.setText(propNove);
        txtPrepDez.setText(propDez);

    }

    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        String site = intent.getStringExtra("site");
        String youtube = intent.getStringExtra("youtube");
        Intent i = new Intent(Intent.ACTION_VIEW);

        if(view.getId() == R.id.btnSite) {

            i.setData(Uri.parse(site));
            startActivity(i);

        } else if(view.getId() == R.id.btnYoutube){

            i.setData(Uri.parse(youtube));
            startActivity(i);

        } else if (view.getId() == R.id.imgButtonBack) {

            Intent inte = new Intent(this, ReceitasActivity.class);
            startActivity(inte);

        }
    }
}
