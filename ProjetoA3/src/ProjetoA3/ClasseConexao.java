package ProjetoA3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClasseConexao {


private static Connection conexao = null;
public static Connection Conectar()
	{
		try
		{
			if(conexao==null)
			{
				String url = "jdbc:mysql://localhost/a3";
				conexao = DriverManager.getConnection(url,"root","");
				
			}
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}
		return conexao;
	}
	
	public static void FecharConexao(Connection c)
	{
		try
		{
			if(c != null)
			{
				c.close();
				conexao = null;
			}
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}
	}
}
