package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import banco.AgendamentoDao;
import classes.Agendamento;
import classes.Consulta;

import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import java.beans.VetoableChangeListener;
import java.text.DecimalFormat;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class telaInicial extends JFrame {

	private JPanel contentPane;
	private JTable conTabela;
	private DefaultComboBoxModel dadosCombo = new DefaultComboBoxModel();
	private List<Agendamento> pacientes = new LinkedList<Agendamento>();
	private DefaultTableModel dados = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtData;
	private JTextField txtHorario;
	private JTextField txtCpf;
	private JTextField txtDuracao;
	private JTextField txtDataNascimento;
	private JTextField txtTelefone;
	private JTextField txtNomeProfissional;
	private JTextField txtValorConsulta;
	private JComboBox cbxProfissional;
	private JComboBox cbxTipoConsulta;
	private JComboBox cbxDesconto;
	private JComboBox cbxConvenio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaInicial frame = new telaInicial();
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
	public telaInicial() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Downloads\\Aha-Soft-Standard-City-Drugstore.ico"));
		setTitle("LMS - Gerenciador de Consultas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labProfissional = new JLabel("Profissional : ");
		labProfissional.setHorizontalAlignment(SwingConstants.RIGHT);
		labProfissional.setBounds(10, 15, 104, 20);
		contentPane.add(labProfissional);
		
		cbxProfissional = new JComboBox(dadosCombo);
		cbxProfissional.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				listaPacientes(cbxProfissional.getSelectedItem().toString());
			}
		});
		cbxProfissional.setBounds(116, 14, 252, 22);
		contentPane.add(cbxProfissional);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 358, 452);
		contentPane.add(scrollPane);
		
		conTabela = new JTable(dados);
		conTabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					showDados(pacientes.get(conTabela.getSelectedRow()));
				} catch (Exception e2) { }
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					showDados(pacientes.get(conTabela.getSelectedRow()));
				} catch (Exception e2) { }
			}
		});
		conTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(conTabela);
		
		JButton btnNovo = new JButton("Adicionar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendamentoCadastro cad = new agendamentoCadastro();
				cad.setVisible(true);
				telaInicial.this.dispose();
			}
		});
		btnNovo.setBounds(10, 38, 104, 23);
		contentPane.add(btnNovo);
		
		JButton btnEditar = new JButton("Alterar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					alterar(pacientes.get(conTabela.getSelectedRow()));
				} catch (Exception e2) { }
			}
		});
		btnEditar.setBounds(116, 38, 121, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deletar(pacientes.get(conTabela.getSelectedRow()));
				} catch (Exception e2) { }
			}
		});
		btnExcluir.setBounds(239, 38, 129, 23);
		contentPane.add(btnExcluir);
		
		JLabel labId = new JLabel("ID : ");
		labId.setHorizontalAlignment(SwingConstants.LEFT);
		labId.setBounds(378, 63, 59, 20);
		contentPane.add(labId);
		
		txtId = new JTextField();
		txtId.setBackground(Color.WHITE);
		labId.setLabelFor(txtId);
		txtId.setEditable(false);
		txtId.setBounds(378, 87, 97, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel labNomePaciente = new JLabel("Nome do paciente : ");
		labNomePaciente.setBounds(378, 219, 140, 20);
		contentPane.add(labNomePaciente);
		
		txtNome = new JTextField();
		txtNome.setBackground(Color.WHITE);
		labNomePaciente.setLabelFor(txtNome);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(378, 242, 333, 20);
		contentPane.add(txtNome);
		
		JLabel labData = new JLabel("Data da consulta : ");
		labData.setBounds(378, 111, 140, 22);
		contentPane.add(labData);
		
		txtData = new JTextField();
		txtData.setBackground(Color.WHITE);
		labData.setLabelFor(txtData);
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(378, 134, 159, 20);
		contentPane.add(txtData);
		
		txtHorario = new JTextField();
		txtHorario.setBackground(Color.WHITE);
		txtHorario.setEditable(false);
		txtHorario.setColumns(10);
		txtHorario.setBounds(552, 134, 159, 20);
		contentPane.add(txtHorario);
		
		JLabel labHorario = new JLabel("Hor\u00E1rio : ");
		labHorario.setLabelFor(txtHorario);
		labHorario.setBounds(552, 111, 140, 20);
		contentPane.add(labHorario);
		
		txtCpf = new JTextField();
		txtCpf.setBackground(Color.WHITE);
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(378, 188, 159, 20);
		contentPane.add(txtCpf);
		
		JLabel labCpf = new JLabel("CPF : ");
		labCpf.setLabelFor(txtCpf);
		labCpf.setBounds(378, 165, 140, 20);
		contentPane.add(labCpf);
		
		txtDuracao = new JTextField();
		txtDuracao.setBackground(Color.WHITE);
		txtDuracao.setEditable(false);
		txtDuracao.setColumns(10);
		txtDuracao.setBounds(552, 188, 159, 20);
		contentPane.add(txtDuracao);
		
		JLabel labDuracao = new JLabel("Dura\u00E7\u00E3o da consulta : ");
		labDuracao.setLabelFor(txtDuracao);
		labDuracao.setBounds(552, 165, 140, 20);
		contentPane.add(labDuracao);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBackground(Color.WHITE);
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(378, 292, 159, 20);
		contentPane.add(txtDataNascimento);
		
		JLabel labDataNascimento = new JLabel("Data de nascimento : ");
		labDataNascimento.setLabelFor(txtDataNascimento);
		labDataNascimento.setBounds(378, 269, 140, 20);
		contentPane.add(labDataNascimento);
		
		txtTelefone = new JTextField();
		txtTelefone.setBackground(Color.WHITE);
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(552, 292, 159, 20);
		contentPane.add(txtTelefone);
		
		JLabel labTelefone = new JLabel("Telefone : ");
		labTelefone.setLabelFor(txtTelefone);
		labTelefone.setBounds(552, 269, 140, 20);
		contentPane.add(labTelefone);
		
		txtNomeProfissional = new JTextField();
		txtNomeProfissional.setBackground(Color.WHITE);
		txtNomeProfissional.setEditable(false);
		txtNomeProfissional.setColumns(10);
		txtNomeProfissional.setBounds(378, 346, 333, 20);
		contentPane.add(txtNomeProfissional);
		
		JLabel labNomeProfissional = new JLabel("Nome do profissional : ");
		labNomeProfissional.setLabelFor(txtNomeProfissional);
		labNomeProfissional.setBounds(378, 323, 140, 20);
		contentPane.add(labNomeProfissional);
		
		JLabel labConsulta = new JLabel("Tipo de consulta : ");
		labConsulta.setBounds(378, 377, 140, 20);
		contentPane.add(labConsulta);
		
		txtValorConsulta = new JTextField();
		txtValorConsulta.setBackground(Color.WHITE);
		txtValorConsulta.setForeground(Color.BLACK);
		txtValorConsulta.setEditable(false);
		txtValorConsulta.setColumns(10);
		txtValorConsulta.setBounds(552, 400, 159, 20);
		contentPane.add(txtValorConsulta);
		
		JLabel labValorConsulta = new JLabel("Valor da consulta (R$) : ");
		labValorConsulta.setLabelFor(txtValorConsulta);
		labValorConsulta.setBounds(552, 377, 140, 20);
		contentPane.add(labValorConsulta);
		
		JLabel labDesconto = new JLabel("Desconto (%) : ");
		labDesconto.setBounds(378, 429, 140, 20);
		contentPane.add(labDesconto);
		
		JLabel labConvenio = new JLabel("Conv\u00EAnio : ");
		labConvenio.setBounds(552, 431, 140, 20);
		contentPane.add(labConvenio);
		
		cbxTipoConsulta = new JComboBox();
		cbxTipoConsulta.setForeground(Color.BLACK);
		cbxTipoConsulta.setEnabled(false);
		cbxTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"Cl\u00EDnico Geral", "Dentista", "Fisioterapeuta", "Cardiologista", "Dermatologista"}));
		cbxTipoConsulta.setSelectedIndex(0);
		cbxTipoConsulta.setBounds(378, 400, 159, 22);
		contentPane.add(cbxTipoConsulta);
		
		cbxDesconto = new JComboBox();
		cbxDesconto.setForeground(Color.BLACK);
		cbxDesconto.setEnabled(false);
		cbxDesconto.setModel(new DefaultComboBoxModel(new String[] {"0 %", "1 %", "2 %", "3 %", "4 %", "5 %", "6 %", "7 %", "8 %", "9 %", "10 %", "11 %", "12 %", "13 %", "14 %", "15 %", "16 %", "17 %", "18 %", "19 %", "20 %", "21 %", "22 %", "23 %", "24 %", "25 %", "26 %", "27 %", "28 %", "29 %", "30 %", "31 %", "32 %", "33 %", "34 %", "35 %", "36 %", "37 %", "38 %", "39 %", "40 %", "41 %", "42 %", "43 %", "44 %", "45 %", "46 %", "47 %", "48 %", "49 %", "50 %", "51 %", "52 %", "53 %", "54 %", "55 %", "56 %", "57 %", "58 %", "59 %", "60 %", "61 %", "62 %", "63 %", "64 %", "65 %", "66 %", "67 %", "68 %", "69 %", "70 %", "71 %", "72 %", "73 %", "74 %", "75 %", "76 %", "77 %", "78 %", "79 %", "80 %", "81 %", "82 %", "83 %", "84 %", "85 %", "86 %", "87 %", "88 %", "89 %", "90 %", "91 %", "92 %", "93 %", "94 %", "95 %", "96 %", "97 %", "98 %", "99 %", "100 %"}));
		cbxDesconto.setBounds(378, 452, 97, 22);
		contentPane.add(cbxDesconto);
		
		cbxConvenio = new JComboBox();
		cbxConvenio.setForeground(Color.BLACK);
		cbxConvenio.setEnabled(false);
		cbxConvenio.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cbxConvenio.setSelectedIndex(0);
		cbxConvenio.setBounds(552, 452, 159, 22);
		contentPane.add(cbxConvenio);
		
		JButton btnRelatorios = new JButton("Relat\u00F3rios");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorios relScreen = new relatorios();
				relScreen.setVisible(true);
			}
		});
		btnRelatorios.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRelatorios.setBounds(370, 13, 130, 49);
		contentPane.add(btnRelatorios);
		listar();
	}
		
		// Mostra os Profissionais encontrados no banco de dados
		public void listar() {		
			AgendamentoDao agend = new AgendamentoDao();
			List<Agendamento> lstAgend = agend.listar();
			for(Agendamento a : lstAgend) {
				String[] vet = new String[3];
				vet[0] = a.getNomePaciente();
				vet[1] = String.valueOf(a.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				vet[2] = String.valueOf(a.getHorario().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				dados.addRow(vet);
			}
			
			List<String> lstProfissional = agend.listarProfissionais();
			for(String b: lstProfissional) {
				dadosCombo.addElement(b);
			}
		}
		
		// Botão Deletar
		public void deletar(Agendamento a) {
			int resposta = JOptionPane.showConfirmDialog(null, "Confirma a exclusão ?", "Exclusão",JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				AgendamentoDao aDao = new AgendamentoDao();
				aDao.deletar(a);
				JOptionPane.showMessageDialog(null, "Deletado com sucesso.", "Deletado", JOptionPane.INFORMATION_MESSAGE);
				listaPacientes(cbxProfissional.getSelectedItem().toString());
			}
		}
		
		// Botão Alterar
		public void alterar(Agendamento a) {
			agendamentoCadastro cad = new agendamentoCadastro();
			cad.showDados(a);
			cad.setVisible(true);
			this.dispose();	
		}
		
		// Mostra os pacientes do Profissional selecionado
		public void listaPacientes(String nomeProfissional) {
			dados.setColumnCount(0);
			dados.setRowCount(0);
			
			dados.addColumn("ID");
			dados.addColumn("PACIENTE");
			dados.addColumn("DATA");
			dados.addColumn("HORARIO");
			
			Consulta agend = new Consulta();
			pacientes = agend.getPacientes(nomeProfissional);
			for(Agendamento a : pacientes) {
				String[] vet = new String[4];
				vet[0] = String.valueOf(a.getId());
				vet[1] = a.getNomePaciente();
				vet[2] = String.valueOf(a.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				vet[3] = String.valueOf(a.getHorario().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				dados.addRow(vet);
			}
		}
		
		// Mostrar Dados do Agendamento nos textField
		public void showDados(Agendamento a) {
			try {
				DecimalFormat df = new DecimalFormat("#,###.00");
				txtId.setText(String.valueOf(a.getId()));
				txtData.setText(String.valueOf(a.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
				txtHorario.setText(String.valueOf(a.getHorario().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
				txtDuracao.setText((String.valueOf(a.getDuracao())));
				txtCpf.setText(a.getCpf());
				txtValorConsulta.setText("R$ " + df.format(a.getValorConsulta()));
				txtNome.setText(a.getNomePaciente());
				txtTelefone.setText(a.getTelefone());
				txtDataNascimento.setText(String.valueOf(a.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));;
				txtNomeProfissional.setText(a.getNomeProfissional());
				cbxTipoConsulta.setSelectedItem(a.getTipo());
				cbxDesconto.setSelectedIndex(a.getPorcDesconto());
				cbxConvenio.setSelectedIndex(a.getConvenio());
			} catch(Exception e3) { }
		}
}
