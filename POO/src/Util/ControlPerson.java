
package Util;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControlPerson {
    
    ConectaBanco conecta = new ConectaBanco();
    public void Inserir(ModelPerson mod){
        try{
            conecta.conexao();
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO person (id, first_name, last_name, office, entrada ) values (?, ?, ?, ?, ?)");
            pst.setInt(1,mod.getId());
            pst.setString(2, mod.getFirst_name());
            pst.setString(3, mod.getLast_name());
            pst.setString(4, mod.getOffice());
            pst.setString(5, mod.getEntrada());
            pst.executeUpdate();
            System.out.println("Dados do(a): "+mod.getFirst_name() + " cadastrados");
            conecta.desconecta();
        }catch(SQLException ex){
            System.out.println("Error " + ex);
          
        }
    }
    
}
