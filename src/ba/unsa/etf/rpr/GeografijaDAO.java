package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private Connection conn;
    private static void initialize(){
        instance = new GeografijaDAO();
    }
    private GeografijaDAO(){
        String url = "jdbc:sqlite:resources/baza.db";
        String upit = "";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static GeografijaDAO getInstance() {
        if(instance == null) initialize();
        return instance;
    }
    public static void removeInstance() {instance = null;}
    Grad glavniGrad(String drzava){
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT glavni_grad FROM drzava WHERE naziv=?");
            ps.setString(1, drzava);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    void obrisiDrzavu(String drzava){

    }
    ArrayList<Grad> gradovi(){

    }
    void dodajGrad(Grad grad) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO grad (naziv, broj_stanovnika, drzava)" +
                    " VALUES (?, ?, ?)");
            ps.setString(1, grad.getNaziv());
            ps.setInt(2, grad.getBroj_stanovnika());
            //ps.set
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    void dodajDrzavu(Drzava drzava){
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO drzava (naziv, glavni_grad)" +
                    " VALUES (?, ?, ?)");
            ps.setString(1, );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    void izmijeniGrad(Grad grad) {

    }
    Drzava nadjiDrzavu(String drzava) {

    }
}
