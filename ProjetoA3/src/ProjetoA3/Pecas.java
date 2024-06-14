package ProjetoA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Pecas {

	private JFrame frame;
	private JTable listaPecas;
	private JScrollPane scrollPane;
	private JButton btCarregar;

	/**
	 * Launch the application.
	 */
	public void AbrirPecas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pecas window = new Pecas();
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
	public Pecas() {
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
		
		listaPecas = new JTable();
		listaPecas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaPecas);
		
		CadPecas nw=new CadPecas();
		
		ListarPecas();
		
		JButton btNovo = new JButton("Novo");
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nw.AbrirCadPecas(0, "", 0, listaPecas);
			}
		});

		
		btNovo.setBounds(145, 10, 102, 29);
		frame.getContentPane().add(btNovo);
		
		JButton btEditar = new JButton("Editar");
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = listaPecas.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para editar.");
				}else {
					int codPeca = Integer.parseInt(listaPecas.getModel().getValueAt(row, 0).toString());
					String desc = listaPecas.getModel().getValueAt(row, 1).toString();
					int valor = Integer.parseInt(listaPecas.getModel().getValueAt(row, 2).toString());

					nw.AbrirCadPecas(codPeca, desc, valor, listaPecas);
				}
			}
		});
		btEditar.setBounds(279, 10, 102, 29);
		frame.getContentPane().add(btEditar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = listaPecas.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para excluir.");
				}else {
					int codPeca = Integer.parseInt(listaPecas.getModel().getValueAt(row, 0).toString());
					String tabela = "PECAS";
					
					int action=JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
					if(action == 0) {
						OperacoesDB.excluiRegistro(tabela, codPeca);
						ListarPecas();
					}
				}
			}
		});
		btExcluir.setBounds(412, 10, 102, 29);
		frame.getContentPane().add(btExcluir);
		
		btCarregar = new JButton("Carregar");
		btCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPecas();
			}
		});
		btCarregar.setBounds(10, 10, 102, 29);
		frame.getContentPane().add(btCarregar);
		
		

	}
	
	public void ListarPecas() {
		Connection conexao = null;
		Statement comando = null;
		ResultSet resultado = null;
				
		try
		{
			conexao = ClasseConexao.Conectar();
			comando = conexao.createStatement();
					
			String sql = "SELECT CODIGO 'Código', DESCRICAO 'Descrição', VALOR 'Valor' FROM PECAS";
			resultado = comando.executeQuery(sql);
			listaPecas.setModel(DbUtils.resultSetToTableModel(resultado));
	
					
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
