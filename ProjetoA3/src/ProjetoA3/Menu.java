package ProjetoA3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;

import ProjetoA3.Pecas;
import ProjetoA3.ConsultaEstoque;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Connection conexao = null;
		PreparedStatement comando = null;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes nw=new Clientes();
				nw.AbrirClientes();
				
			}
		});
		btnNewButton.setBounds(57, 43, 159, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Peças");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pecas nw=new Pecas();
				nw.AbrirPecas();
			}
		});
		
		btnNewButton_1.setBounds(57, 120, 159, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Movimentação de Estoque");
		btnNewButton_2.setBounds(57, 196, 159, 35);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaEstoque nw=new ConsultaEstoque();
				nw.AbrirConsultaEstoque();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Pedido de Venda");
		btnNewButton_4.setBounds(355, 43, 148, 35);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ordem de Serviço");
		btnNewButton_5.setBounds(355, 120, 148, 35);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Faturamento");
		btnNewButton_6.setBounds(355, 196, 148, 35);
		frame.getContentPane().add(btnNewButton_6);
		
	}
}
