package ProjetoA3;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ConsultaEstoque {

    private JFrame frame;
    private JTable tabelaPecas;
    private JTextField textFieldCodigo;

    /**
     * Launch the application.
     */
    public void AbrirConsultaEstoque() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConsultaEstoque window = new ConsultaEstoque();
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
    public ConsultaEstoque() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 544, 402);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 10, 70, 25);
        frame.getContentPane().add(lblCodigo);

        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(80, 10, 150, 25);
        frame.getContentPane().add(textFieldCodigo);
        textFieldCodigo.setColumns(10);

        JButton btnNewButton = new JButton("Consulta Estoque");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListarEstoque();
            }
        });
        btnNewButton.setBounds(353, 7, 159, 35);
        frame.getContentPane().add(btnNewButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 49, 514, 300);
        frame.getContentPane().add(scrollPane);

        tabelaPecas = new JTable();
        tabelaPecas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(tabelaPecas);

        JButton btnCarregar = new JButton("Voltar");
        btnCarregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
            }
        });
        btnCarregar.setBounds(240, 10, 102, 29);
        frame.getContentPane().add(btnCarregar);
    }

    public void ListarEstoque() {
        Connection conexao = null;
        Statement comando = null;
        ResultSet resultado = null;

        try {
            conexao = ClasseConexao.Conectar();
            comando = conexao.createStatement();

            String codigo = textFieldCodigo.getText();
            String sql = "SELECT CODIGO 'Código', DESCRICAO 'Descrição', QUANTIDADE 'Quantidade' FROM PECAS";
            if (!codigo.isEmpty()) {
                sql += " WHERE CODIGO = '" + codigo + "'";
            }
            resultado = comando.executeQuery(sql);
            tabelaPecas.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch(SQLException erro) {
            erro.printStackTrace();
        } finally {
            ClasseConexao.FecharConexao(conexao);
            try {
                if (comando != null) {
                    comando.close();
                }
            } catch(SQLException erro) {
                erro.printStackTrace();
            }
        }
    }
}
