package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class relatoriosDados extends JFrame {

	private JPanel contentPane;
	private JTable tabDados;
	private LinkedList<LinkedList<String>> relatorio = new LinkedList<LinkedList<String>>(); 
	private DefaultTableModel dados = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relatoriosDados frame = new relatoriosDados();
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
	public relatoriosDados() {
		setTitle("LMS - Mostrar dados - Relat\u00F3rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tabDados = new JTable(dados);
		scrollPane.setViewportView(tabDados);
	}
	
	// Mostrar Dados do Relatório
	public void listar(LinkedList<LinkedList<String>> relatorio) {
		try {
			dados.setColumnCount(0);
			dados.setRowCount(0);
			
			this.relatorio = relatorio;
			
			LinkedList<String> col = relatorio.get(0);
			int qntCol = col.size();
		
			// Criar Colunas
			for(String c : col) {
				dados.addColumn(c);
			}
			
			// Setar Dados na JTable
			if(relatorio.size() > 1) {
				for(int i = 1; i < relatorio.size(); i++) {
					LinkedList<String> row = relatorio.get(i);
					String[] vet = new String[qntCol];
					for(int x = 0;x < row.size();x++) {
							vet[x] = row.get(x);
					}
					dados.addRow(vet);
				}
			}
			
			this.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Erro ao Gerar Relatório", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
	}

}
