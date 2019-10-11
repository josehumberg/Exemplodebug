package br.edu.fasam.mobile.exemplodebug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AlunoActivity extends DebugActivity {
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_aluno);

         Intent nteste = getIntent();
String teste2 = nteste.getStringExtra("dados");
        Toast.makeText(getApplicationContext(),teste2,Toast.LENGTH_SHORT).show();
    }
      EditText txtnomealuno;
      EditText txtnota1 ;
      EditText txtnota2;
      EditText txtnota3;
      ListView listView;


    public void Adicionaraluno(View view) {
        //Entrada

        txtnomealuno.findViewById(R.id.txtnomealuno);
        txtnota1.findViewById(R.id.txtnota1);
        txtnota2.findViewById(R.id.txtnota2);
        txtnota3.findViewById(R.id.txtnota3);



        String nomealuno,nota1,nota2,nota3;
        nomealuno = txtnomealuno.getText().toString();
        nota1=txtnota1.getText().toString();
        nota2=txtnota2.getText().toString();
        nota3=txtnota3.getText().toString();

        float media, nota01,nota02,nota03;

        nota01 = Float.parseFloat(nota1);
        nota02 = Float.parseFloat(nota2);
        nota03 = Float.parseFloat(nota3);
        media=(nota01+nota02+nota03)/3;

        String m = Float.toString(media);
        String dados = String.format("Os dados digitados foram %s %s %s %s",nomealuno,nota1,nota2,nota3,"Media dos alunos foi %s ", media);


        List<HashMap<String, String>> Listadedados = new ArrayList<>();
        HashMap<String, String> lst = new HashMap<>();

        lst.put("nome do aluno", nomealuno);
        lst.put("Nota 1",nota1);
        lst.put("Nota 2",nota2);
        lst.put("Nota 3",nota3);
        lst.put("media de nota do aluno",m);

        Listadedados.add(lst);

        String[] de = {"nomealuno","nota1","nota2","nota3","m"};
        int[] para= {R.id.lt1nome,R.id.lt2nota1,R.id.lt3nota2,R.id.lt4nota3,R.id.lt5media};

        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                Listadedados,
                R.layout.lealtlista,
                de,
                para
        );
        listView = findViewById(R.id.listViewAluno);
        listView.setAdapter(adapter);







    }


}
