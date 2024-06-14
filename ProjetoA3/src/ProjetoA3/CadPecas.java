package ProjetoA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CadPecas {

	private JFrame CadPecas;
	private JTextField Descricao;
	private JTextField Valor;
	private JButton btCancelar;
	private int cod_peca;
	private String desc_peca;
	private int valor_peca;
	private JTable tabela_pecas;

	/**
	 * Launch the application.
	 */
	public void AbrirCadPecas(int codPeca, String desc, int valor, JTable tabela) {

		cod_peca = codPeca;
		desc_peca = desc;
		valor_peca = valor;
		tabela_pecas = tabela;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPecas window = new CadPecas();
	                window.initialize(cod_peca, desc_peca, valor_peca, tabela_pecas); 
					window.CadPecas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 
	*/
	public CadPecas() {
		initialize(0, "", 0, null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int codPeca, String desc, int valor, JTable tabela) {
		cod_peca = codPeca;
		desc_peca = desc;
		valor_peca = valor;
		tabela_pecas = tabela;
		CadPecas = new JFrame();
		CadPecas.setTitle("Cadastro de Peças");
		CadPecas.setBounds(100, 100, 398, 287);
		CadPecas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CadPecas.getContentPane().setLayout(null);
		
		JButton Gravar = new JButton("Gravar");
		Gravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor_peca = (Valor.getText().length() > 0) ? Integer.parseInt(Valor.getText()) : 0;
				OperacoesDB.gravaPecas(cod_peca, Descricao.getText(), valor_peca, tabela_pecas);
	            CadPecas.setVisible(false);
			}
		});
		Gravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Gravar.setBounds(215, 196, 125, 36);
		CadPecas.getContentPane().add(Gravar);
		
		Descricao = new JTextField();
		Descricao.setBounds(106, 50, 268, 34);
		CadPecas.getContentPane().add(Descricao);
		Descricao.setColumns(10);
		
		Valor = new JTextField();
		Valor.setBounds(106, 122, 268, 34);
		CadPecas.getContentPane().add(Valor);
		Valor.setColumns(10);

		if(desc_peca != "") {
			Descricao.setText(desc_peca);
		}
		if(valor_peca > 0) {
			String valor_peca_str = Integer.toString(valor_peca);

			Valor.setText(valor_peca_str);
		}
		
		JLabel lbDesc = new JLabel("Descrição:");
		lbDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDesc.setBounds(10, 50, 86, 34);
		CadPecas.getContentPane().add(lbDesc);
		
		JLabel lbValor = new JLabel("Valor:");
		lbValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbValor.setBounds(10, 122, 86, 34);
		CadPecas.getContentPane().add(lbValor);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadPecas.setVisible(false);
			}
		});
		btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCancelar.setBounds(48, 196, 125, 36);
		CadPecas.getContentPane().add(btCancelar);
	}
}
