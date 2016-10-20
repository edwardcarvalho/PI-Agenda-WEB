import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class DaoContato extends Conn {

	public int adicionarContato(Contato contato){
		
		Date data = new Date();
		String sql = String.format("INSERT INTO CONTATO (NOME, DATANASCIMENTO, TELEFONE, EMAIL, DATACADASTRO) VALUES ('%s','%s','%s','%s','%s')", contato.getNome(),contato.getDataNascimento(), contato.getTelefone(), contato.getEmail(),data);
		
		try {
			conectaBanco();
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			pst.close();
			desconectaBanco();
			return 1;
			
		} catch (SQLException e) {
			System.out.println("ERRO INSERIR CLIENTE " + e);
			return 0;
		}
	}
	
	public ArrayList<Contato> listarContatos(){
		
		ArrayList<Contato> agenda = new ArrayList<>();
		
		String sql = "Select * from contato";
		
		try {
			conectaBanco();
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				agenda.add(new Contato(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
			st.close();
			desconectaBanco();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return agenda;
	}
}
