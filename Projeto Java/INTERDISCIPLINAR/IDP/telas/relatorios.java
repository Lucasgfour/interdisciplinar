package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import banco.Comando;
import banco.Comandos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class relatorios extends JFrame {

	private JPanel contentPane;
	private JTable tabRelatorios;
	private JTextField txtTitulo;
	private Comandos relatorios = new Comandos();
	private DefaultTableModel dados = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private JTextPane txtDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatorios frame = new relatorios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public relatorios() {
		setTitle("LMS - Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 859, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 310, 244);
		contentPane.add(scrollPane);
		
		tabRelatorios = new JTable(dados);
		scrollPane.setViewportView(tabRelatorios);
		tabRelatorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // Quando Usuário Selecionar Registro na JTable
				try {
					showDados(relatorios.getComands().get(tabRelatorios.getSelectedRow()));
				} catch (Exception e2) { }
			}
			@Override
			public void mouseReleased(MouseEvent e) { // Quando Usuário Selecionar Registro na JTable
				try {
					showDados(relatorios.getComands().get(tabRelatorios.getSelectedRow()));
				} catch (Exception e2) { }
			}
		});
		tabRelatorios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel labTitulo = new JLabel("Titulo : ");
		labTitulo.setBounds(330, 11, 140, 22);
		contentPane.add(labTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(330, 34, 491, 20);
		contentPane.add(txtTitulo);
		
		JLabel labDescricao = new JLabel("Descri\u00E7\u00E3o do Relat\u00F3rio : ");
		labDescricao.setBounds(330, 65, 140, 22);
		contentPane.add(labDescricao);
		
		JButton btnGerar = new JButton("Gerar Relat\u00F3rio");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gerarRelatorio(relatorios.getComands().get(tabRelatorios.getSelectedRow()));
				} catch(Exception ex) {}
				
			}
		});
		btnGerar.setBounds(688, 232, 133, 23);
		contentPane.add(btnGerar);
		
		txtDescricao = new JTextPane();
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(330, 98, 491, 123);
		contentPane.add(txtDescricao);
		Listar();
	}
	
	// Pega os Dados do Objeto Comandos e exibe na Interface
	public void Listar() {
		dados.setColumnCount(0);
		dados.setRowCount(0);
		
		dados.addColumn("NOME");
		
		LinkedList<Comando> a = relatorios.getComands();
		for(Comando b:a) {
			String[] vet = new String[1];
			vet[0] = b.getNome();
			dados.addRow(vet);
		}
	}
	
	// Listar Dados do Relatório
	public void showDados(Comando a) {
		txtTitulo.setText(a.getNome());
		txtDescricao.setText(a.getDescricao());
	}
	
	// Gera o relatório e envia para tela relatoriosDados para exibir o resultado ao usuário
	public void gerarRelatorio(Comando a) {
		relatoriosDados b = new relatoriosDados();
		a.inputCall();
		b.listar(a.gerarRelatorio());
	}
}
