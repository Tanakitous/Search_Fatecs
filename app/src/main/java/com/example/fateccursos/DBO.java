package com.example.fateccursos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBO extends SQLiteOpenHelper {
    private static final String NOMEBD="fatec4";
    private static final int VERSAO = 1;

    public DBO(Context context) {
        super(context, NOMEBD, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        CriaBanco(bd);
        InsereDados(bd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void CriaBanco(SQLiteDatabase bd){
        String sql1 = "CREATE TABLE cursos (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome_c TEXT" +
                ")";
        bd.execSQL(sql1);

        String sql2 = "CREATE TABLE fatecs (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome_f TEXT, " +
                "email TEXT, " +
                "telefone TEXT, " +
                "endereco TEXT" +
                ")";

        bd.execSQL(sql2);
        String sql3 = "CREATE TABLE cursos_fatec (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fatecs_id INTEGER, " +
                "cursos_id INTEGER, " +
                "FOREIGN KEY(fatecs_id) references fatecs(_id), " +
                "FOREIGN KEY(cursos_id) references cursos(_id)" +
                ")";
        bd.execSQL(sql3);
    }
    public void InsereDados(SQLiteDatabase bd){
        InsereFatec(bd,"Americana","f004acad@cps.sp.gov.br","(19)3406-5776",
                "R. Emílio de Menezes - Vila Amorim");
        InsereFatec(bd,"Araçatuba","secretaria.fatec.aracatuba@gmail.com","(18)3625-9914",
                "Av. Prestes Maia,1764 - Jd.Ipanema");
        InsereFatec(bd,"Campinas","f276acad@cps.sp.gov.br","(19)3216-6474",
                "Av. Cônego Antônio Roccatto, 593 - Jd. Santa Mônica");
        InsereFatec(bd,"Carapicuíba","contato@fateccarapicuiba.edu.br","(11)4184-8404 ",
                "Av. Francisco Pignatari, 650 - Vila Gustavo Correia");
        InsereFatec(bd,"Cruzeiro","vestibular@fateccruzeiro.edu.br","(12)3143-6571",
                "Av. Rotary, 383 - Vila Paulista");
        InsereFatec(bd,"Ferraz de Vasconcelos","f292acad@cps.sp.gov.br","(11)4675-4545",
                "R. Carlos de Carvalho, 200 - Jardim São João");
        InsereFatec(bd,"Franca","fatecfranca@fatecfranca.edu.br","(16)3702-3204",
                "R. Irênio Grecco, 4580 - Vila Imperador");
        InsereFatec(bd,"Ipiranga","f204adm@cps.sp.gov.br","(11)5061-5462",
                "R. Frei João, 59 - Ipiranga");
        InsereFatec(bd,"Jales","fatecjales@fatecjales.edu.br","(17)3632-2239",
                "R. Vicente Leporace, 2630 - Jd. Trianon");
        InsereFatec(bd,"Jundiaí","f114.secretaria@fatec.sp.gov.br","(11)4523-0092",
                "Av. União dos Ferroviários, 1760 - Centro");
        InsereFatec(bd,"São Caetano do Sul","diretoria.saocaetano@fatec.sp.gov.br","(11)4238-2066",
                "R. Bell Aliance, 225 - Jd. São Caetano");
        InsereFatec(bd,"São Paulo","secaluno@fatecsp.br","(11)3322-2213",
                "Av. Tiradentes, 615 - Bom Retiro");
        InsereFatec(bd,"Carapicuíba","contato@fateccarapicuiba.edu.br","(11)4184-8404",
                "Av. Francisco Pignatari, 650 - Vila Gustavo Correia");
        InsereFatec(bd,"Ourinhos","secretaria@fatecourinhos.edu.br","(14)3512-2024",
                "Av. Vitalina Marcusso, 1400 - Campus Universitário");
        InsereFatec(bd,"Adamantina","secretaria@fatecAdamantina.edu.br","(18)3522-4181",
                "Rua Paraná, 400 - Jardim Brasil");
        InsereFatec(bd,"Araraquara","secretaria@fatecararaquara.edu.br","(16)3339-7841",
                "Rua Precide Scarpino Martim, 126 - Jd. Santa Clara");
        InsereFatec(bd,"Assis","secretaria@fatecassis.edu.br","(18)9965-72184",
                "Av. Dom Antônio, 2100 - Jardim Paraná");
        InsereFatec(bd,"Guaratinguetá","vestibular@fatecguaratingueta.edu.br","(12)3126-2643",
                "Av Prof. João Rodrigues Alckmin, 1501 - Jd. Esperança");
        InsereFatec(bd,"Itaquaquecetuba","dir.fatecitaqua@centropaulasouza.sp.gov.br","(11)4753-3221",
                "Av. Itaquaquecetuba, 711 - Vila Monte Belo");
        InsereFatec(bd,"Santana de Parnaíba","secretaria@fatecsantanaparnaiba.edu.br","(11)2424-2757",
                "Av. Tenente Marques, s/n - Fazendinha");
        InsereFatec(bd,"São Roque","secretaria@fatecsaoroque.edu.br","(11)4712-3229",
                "Rua Marechal Deodoro da Fonseca, 132 - Centro");
        InsereFatec(bd,"Barueri","vestibular.barueri@fatec.sp.gov.br","(11)4198-3121",
                "Av. Carlos Capriotti, 123 - Novo Centro Comercial");
        InsereFatec(bd,"Indaiatuba","vestibular@fatecindaiatuba.edu.br","(19)3885-1923",
                "R. D. Pedro I, 65 - Cidade Nova I");
        InsereFatec(bd,"Itapetininga","f131acad@cps.sp.gov.br","(15)3272-7916 ",
                "R. Dr. João Vieira de Camargo, 104 - Vila Barth");
        InsereFatec(bd,"Praia Grande","dir.fatecpraiagrande@centropaulasouza.sp.gov.br","(13)3591-6968",
                "Pça. 19 de Janeiro, 144 - Boqueirão");
        InsereFatec(bd,"Santo André","secretaria@fatecsantoandre.com.br","(11)4437-2215",
                "R. Prefeito Justino Paixão, 150 - Centro");

        InsereCursos(bd,"Análise e Desenvolvimento de Sistemas");
        InsereCursos(bd,"Jogos Digitais");
        InsereCursos(bd,"Segurança da Informação");
        InsereCursos(bd,"Gestão Comercial");
        InsereCursos(bd,"Comércio Exterior");
        InsereCursos(bd,"Secretariado");

        InsereCursosFatecs(bd,1,1);
        InsereCursosFatecs(bd,1,2);
        InsereCursosFatecs(bd,1,3);
        InsereCursosFatecs(bd,2,1);
        InsereCursosFatecs(bd,3,1);
        InsereCursosFatecs(bd,4,1);
        InsereCursosFatecs(bd,5,1);
        InsereCursosFatecs(bd,6,1);
        InsereCursosFatecs(bd,7,1);
        InsereCursosFatecs(bd,8,1);
        InsereCursosFatecs(bd,9,1);
        InsereCursosFatecs(bd,10,1);
        InsereCursosFatecs(bd,11,1);
        InsereCursosFatecs(bd,11,2);
        InsereCursosFatecs(bd,11,3);
        InsereCursosFatecs(bd,11,5);
        InsereCursosFatecs(bd,12,1);
        InsereCursosFatecs(bd,12,6);
        InsereCursosFatecs(bd,13,2);
        InsereCursosFatecs(bd,14,2);
        InsereCursosFatecs(bd,14,3);
        InsereCursosFatecs(bd,15,4);
        InsereCursosFatecs(bd,16,4);
        InsereCursosFatecs(bd,17,4);
        InsereCursosFatecs(bd,18,4);
        InsereCursosFatecs(bd,19,4);
        InsereCursosFatecs(bd,20,4);
        InsereCursosFatecs(bd,21,4);
        InsereCursosFatecs(bd,22,5);
        InsereCursosFatecs(bd,23,5);
        InsereCursosFatecs(bd,24,5);
        InsereCursosFatecs(bd,25,5);
        InsereCursosFatecs(bd,26,5);



    }
    public void InsereFatec(SQLiteDatabase bd, String nome, String email, String telefone, String endereco ){
        ContentValues cvFatec = new ContentValues();
        cvFatec.put("nome_f",nome);
        cvFatec.put("email",email);
        cvFatec.put("telefone",telefone);
        cvFatec.put("endereco",endereco);
        bd.insert("fatecs",null,cvFatec);
    }
    public void InsereCursos(SQLiteDatabase bd, String nome){
        ContentValues cvCursos = new ContentValues();
        cvCursos.put("nome_c",nome);
        bd.insert("cursos",null,cvCursos);
    }
    public void InsereCursosFatecs(SQLiteDatabase bd, int fatecs_id, int cursos_id){
        ContentValues cvCursosFatecs = new ContentValues();
        cvCursosFatecs.put("fatecs_id",fatecs_id);
        cvCursosFatecs.put("cursos_id",cursos_id);
        bd.insert("cursos_fatec",null,cvCursosFatecs);
    }
    @SuppressLint("Range")
    public ArrayList<String> BuscaCursos(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT nome_c FROM cursos ORDER BY nome_c;";
        ArrayList<String> spn = new ArrayList<>();
        Cursor c = db.rawQuery(sql,null);
        while (c.moveToNext()) {
            spn.add(c.getString(c.getColumnIndex("nome_c")));
        }
        return spn;
    }
    public Cursor getCursorFatecs(String curso){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT fatecs._id,fatecs.nome_f,fatecs.email,fatecs.endereco,fatecs.telefone FROM fatecs " +
                "INNER JOIN cursos_fatec " +
                "on fatecs._id = cursos_fatec.fatecs_id " +
                "INNER JOIN cursos " +
                "on cursos_fatec.cursos_id = cursos._id " +
                "WHERE cursos.nome_c = '"+curso+"' " +
                "ORDER BY fatecs.nome_f;";
        Cursor c = db.rawQuery(sql,null);
        return c;
    }

}
