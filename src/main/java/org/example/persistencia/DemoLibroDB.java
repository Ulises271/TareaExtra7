package main.java.org.example.persistencia;

import org.example.persistencia.ConexionSingleton;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoLibroDB {
    public DemoLibroDB() {
    }
    public void insertarStatement(){
        String elTitulo = "Arrancame la vida";
        String elAutor = "Angeles Matreta";
        try{
            Statement stm = ConexionSingleton.getinstance("librosDB.db").getConnection().createStatement();
            String sqlInsert = "INSERT INTO libros(titulo,autor) VALUES('"+elTitulo+"','"+ elAutor+"')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("Se insertaron "+ rowCount+ " registros");
        }catch (SQLException sqle){
            System.out.println("Error al conectar"+sqle.getMessage());
        }

    }
    public void insertarPreparedStatement(){
        String elTitulo = "El principito";
        String elAutor = "No me acuerdo";
        String sqlInsert="INSERT INTO libros(titulo, autor) VALUES (?,?)";
        try{
            PreparedStatement pstm = ConexionSingleton.getinstance("librosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1, elTitulo);
            pstm.setString(1, elAutor);
            int rowCount = pstm.executeUpdate();
            System.out.println("Se insertaron "+rowCount+"registro");


        }catch (SQLException sqle){
            System.out.println("error "+sqle.getMessage());
        }

    }

}
