package ProjetoA3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class OperacoesDB {

    public static void gravaPecas(int cod_peca, String descricao, int valor, JTable tabela) {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = ClasseConexao.Conectar();
            String msg = "";
            if (cod_peca > 0) {
                String sql = "UPDATE PECAS SET DESCRICAO = ?, VALOR = ? WHERE CODIGO = ?";
                comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                comando.setString(1, descricao);
                comando.setInt(2, valor);
                comando.setInt(3, cod_peca);
                msg = "Dados alterados!";
            } else {
                String sql = "INSERT INTO `pecas`(`DESCRICAO`, `VALOR`) VALUES (?,?)";
                comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                comando.setString(1, descricao);
                comando.setInt(2, valor);
                msg = "Dados cadastrados!";
            }

            if (comando.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            ClasseConexao.FecharConexao(conexao);
            try {
                if (comando != null) {
                    comando.close();
                }
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
    }
    
//    private static void reloadTable(JTable tabela) {
//		// TODO Auto-generated method stub
//		
//	}

	public static void excluiRegistro(String tabela, int cod_peca) {
		Connection conexao = null;
		PreparedStatement comando = null;
		try
		{
			String table = tabela;
			conexao = ClasseConexao.Conectar();
			String sql = "DELETE FROM " + table + " WHERE CODIGO = ?";
			comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			comando.setInt(1, cod_peca);				
			comando.executeUpdate();

		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}finally {
			ClasseConexao.FecharConexao(conexao);
			try
			{
				comando.close();
			}catch(SQLException erro)
			{
				erro.printStackTrace();
			}
		}
    }
	
    public static void gravaClientes(int cod_cliente, String nome, String cpf, String fone, String cep, 
    		String endereco, int numero, String bairro, String cidade, String pais, JTable tabela) {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = ClasseConexao.Conectar();
            String msg = "";
            if (cod_cliente > 0) {
                String sql = "UPDATE CLIENTES SET NOME = ?, CPF = ?, TELEFONE = ?, CEP = ?,  "
                		+ "ENDERECO = ?, NUM_ENDERECO = ?, BAIRRO = ?, CIDADE = ?, PAIS = ? WHERE CODIGO = ?";
                comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                comando.setString(1, nome);
                comando.setString(2, cpf);
                comando.setString(3, fone);
                comando.setString(4, cep);
                comando.setString(5, endereco);
                comando.setInt(6, numero);
                comando.setString(7, bairro);
                comando.setString(8, cidade);
                comando.setString(9, pais);
                comando.setInt(10, cod_cliente);
                msg = "Dados alterados!";
            } else {
                String sql = "INSERT INTO `CLIENTES`(`NOME`, `CPF`, `TELEFONE`, `CEP`, `ENDERECO`, `NUM_ENDERECO`, `BAIRRO`, `CIDADE`, `PAIS`) VALUES (?,?,?,?,?,?,?,?,?)";
                comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                comando.setString(1, nome);
                comando.setString(2, cpf);
                comando.setString(3, fone);
                comando.setString(4, cep);
                comando.setString(5, endereco);
                comando.setInt(6, numero);
                comando.setString(7, bairro);
                comando.setString(8, cidade);
                comando.setString(9, pais);
                msg = "Dados cadastrados!";
            }
            if (comando.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, msg);
//                reloadTable(tabela);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            ClasseConexao.FecharConexao(conexao);
            try {
                if (comando != null) {
                    comando.close();
                }
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
    }
}
