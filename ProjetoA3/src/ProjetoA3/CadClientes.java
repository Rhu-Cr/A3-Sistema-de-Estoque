package ProjetoA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadClientes {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfFone;
	private JTextField tfCEP;
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfPais;
	private JLabel lbNome;
	private JLabel lbFone;
	private JLabel lbEndereco;
	private JLabel lbBairro;
	private JLabel lbPais;
	private JLabel lbCpf;
	private JLabel lbCep;
	private JLabel lbNumero;
	private JLabel lbCidade;
	private JButton btCancelar;
	private JButton gravar;

	/**
	 * Launch the application.
	 */
	public void AbrirCadClientes(int cod_cliente, String nome, String cpf, String fone, String cep, 
    		String endereco, int numero, String bairro, String cidade, String pais, JTable tabela) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadClientes window = new CadClientes();
					window.initialize(cod_cliente, nome, cpf, fone, cep, endereco, numero, bairro, cidade, pais, tabela);
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
	public CadClientes() {
		initialize(0, "", "", "", "", "", 0, "", "", "", null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int cod_cliente, String nome, String cpf, String fone, String cep, 
    		String endereco, int numero, String bairro, String cidade, String pais, JTable tabela) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(124, 65, 174, 35);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(469, 65, 174, 35);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);
		
		tfFone = new JTextField();
		tfFone.setBounds(124, 110, 174, 35);
		frame.getContentPane().add(tfFone);
		tfFone.setColumns(10);
		
		tfCEP = new JTextField();
		tfCEP.setBounds(469, 110, 174, 35);
		frame.getContentPane().add(tfCEP);
		tfCEP.setColumns(10);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(124, 155, 174, 34);
		frame.getContentPane().add(tfEndereco);
		tfEndereco.setColumns(10);
		
		tfNumero = new JTextField();
		tfNumero.setBounds(469, 155, 174, 34);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(124, 203, 174, 35);
		frame.getContentPane().add(tfBairro);
		tfBairro.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(469, 203, 174, 35);
		frame.getContentPane().add(tfCidade);
		tfCidade.setColumns(10);
		
		tfPais = new JTextField();
		tfPais.setBounds(124, 248, 174, 35);
		frame.getContentPane().add(tfPais);
		tfPais.setColumns(10);
		
		if(nome != "") {
			tfNome.setText(nome);
		}
		if(cpf != "") {
			tfCPF.setText(cpf);
		}
		if(fone != "") {
			tfFone.setText(fone);
		}
		if(cep != "") {
			tfCEP.setText(cep);
		}
		if(endereco != "") {
			tfEndereco.setText(endereco);
		}
		if(numero > 0) {
			String numero_str = Integer.toString(numero);

			tfNumero.setText(numero_str);
		}
		if(bairro != "") {
			tfBairro.setText(bairro);
		}
		if(cidade != "") {
			tfCidade.setText(cidade);
		}
		if(pais != "") {
			tfPais.setText(pais);
		}
		
		lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNome.setBounds(10, 76, 45, 13);
		frame.getContentPane().add(lbNome);
		
		lbFone = new JLabel("Telefone:");
		lbFone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFone.setBounds(10, 121, 84, 13);
		frame.getContentPane().add(lbFone);
		
		lbEndereco = new JLabel("Endereço:");
		lbEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbEndereco.setBounds(10, 165, 84, 13);
		frame.getContentPane().add(lbEndereco);
		
		lbBairro = new JLabel("Bairro:");
		lbBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbBairro.setBounds(10, 214, 45, 13);
		frame.getContentPane().add(lbBairro);
		
		lbPais = new JLabel("País:");
		lbPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPais.setBounds(10, 259, 45, 13);
		frame.getContentPane().add(lbPais);
		
		lbCpf = new JLabel("CPF:");
		lbCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCpf.setBounds(340, 76, 45, 13);
		frame.getContentPane().add(lbCpf);
		
		lbCep = new JLabel("CEP:");
		lbCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCep.setBounds(340, 121, 45, 13);
		frame.getContentPane().add(lbCep);
		
		lbNumero = new JLabel("Número:");
		lbNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNumero.setBounds(340, 165, 108, 13);
		frame.getContentPane().add(lbNumero);
		
		lbCidade = new JLabel("Cidade:");
		lbCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCidade.setBounds(340, 214, 84, 13);
		frame.getContentPane().add(lbCidade);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCancelar.setBounds(157, 334, 174, 51);
		frame.getContentPane().add(btCancelar);
		
		gravar = new JButton("Gravar");
		gravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNome.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "É necessário preencher o campo Nome.");
				}else {
					String cpf = (tfCPF.getText().length() > 0) ? tfCPF.getText() : "";
					String fone = (tfFone.getText().length() > 0) ? tfFone.getText() : "";
					String cep = (tfCEP.getText().length() > 0) ? tfCEP.getText() : "";
					String endereco = (tfEndereco.getText().length() > 0) ? tfEndereco.getText() : "";
					int numero = (tfNumero.getText().length() > 0) ? Integer.parseInt(tfNumero.getText()) : 0;
					String bairro = (tfBairro.getText().length() > 0) ? tfBairro.getText() : "";
					String cidade = (tfCidade.getText().length() > 0) ? tfCidade.getText() : "";
					String pais = (tfPais.getText().length() > 0) ? tfPais.getText() : "";

					OperacoesDB.gravaClientes(cod_cliente, tfNome.getText(), cpf, fone, cep, endereco, numero, bairro, cidade, pais, tabela);
					frame.setVisible(false);
				}
			}
		});
		gravar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gravar.setBounds(401, 334, 174, 51);
		frame.getContentPane().add(gravar);
	}

}
