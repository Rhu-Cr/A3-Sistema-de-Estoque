package ProjetoA3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;

public class Clientes {

	private JFrame frame;
	private JTable ListarClientes;
	private JScrollPane scrollPane;
	private JButton btCarregar;
	/**
	 * Launch the application.
	 */
	public void AbrirClientes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes window = new Clientes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Clientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 514, 252);
		frame.getContentPane().add(scrollPane);
		
		ListarClientes = new JTable();
		ListarClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ListarClientes);
		
		CadClientes nw=new CadClientes();
		
		ListarClientes();
		
		JButton btNovo = new JButton("Novo");
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nw.AbrirCadClientes(0, "", "", "", "", "", 0, "", "", "", ListarClientes);
			}
		});

		
		btNovo.setBounds(145, 10, 102, 29);
		frame.getContentPane().add(btNovo);
		
		JButton btEditar = new JButton("Editar");
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = ListarClientes.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para editar.");
				}else {
					int codCliente = Integer.parseInt(ListarClientes.getModel().getValueAt(row, 0).toString());
					String nome = ListarClientes.getModel().getValueAt(row, 1).toString();
					String cpf = ListarClientes.getModel().getValueAt(row, 2).toString();
					String fone = ListarClientes.getModel().getValueAt(row, 3).toString();
					String cep = ListarClientes.getModel().getValueAt(row, 4).toString();
					String endereco = ListarClientes.getModel().getValueAt(row, 5).toString();
					int numero = Integer.parseInt(ListarClientes.getModel().getValueAt(row, 6).toString());
					String bairro = ListarClientes.getModel().getValueAt(row, 7).toString();
					String cidade = ListarClientes.getModel().getValueAt(row, 8).toString();
					String pais = ListarClientes.getModel().getValueAt(row, 9).toString();


					nw.AbrirCadClientes(codCliente, nome, cpf, fone, cep, endereco, numero, bairro, cidade, pais, ListarClientes);
				}
			}
		});
		btEditar.setBounds(279, 10, 102, 29);
		frame.getContentPane().add(btEditar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = ListarClientes.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para excluir.");
				}else {
					int codCliente = Integer.parseInt(ListarClientes.getModel().getValueAt(row, 0).toString());
					String tabela = "CLIENTES";

					int action=JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
					if(action == 0) {
						OperacoesDB.excluiRegistro(tabela, codCliente);
						ListarClientes();
					}
				}
			}
		});
		btExcluir.setBounds(412, 10, 102, 29);
		frame.getContentPane().add(btExcluir);
		
		btCarregar = new JButton("Carregar");
		btCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes();
			}
		});
		btCarregar.setBounds(10, 10, 102, 29);
		frame.getContentPane().add(btCarregar);
		
		

	}
	
	public void ListarClientes() {
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
				
		try
		{
			conexao = ClasseConexao.Conectar();
			comando = conexao.createStatement();
					
			String sql = "SELECT CODIGO 'Código', NOME 'Nome', CPF, TELEFONE 'Telefone', CEP, ENDERECO 'Endereço', "
					+ "NUM_ENDERECO 'Nº', BAIRRO Bairro, CIDADE Cidade, PAIS 'País' FROM CLIENTES";
			resultado = comando.executeQuery(sql);
			ListarClientes.setModel(DbUtils.resultSetToTableModel(resultado));
	
					
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}finally
		{
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
}
