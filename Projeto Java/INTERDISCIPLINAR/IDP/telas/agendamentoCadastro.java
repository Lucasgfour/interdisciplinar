package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.AgendamentoDao;
import classes.Agendamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class agendamentoCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtData;
	private JTextField txtHorario;
	private JTextField txtDuracao;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtTelefone;
	private JTextField txtNomeProfissional;
	private JTextField txtValorConsulta;
	private JComboBox cbxConvenio;
	private JComboBox cbxTipoConsulta;
	private JComboBox cbxDesconto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agendamentoCadastro frame = new agendamentoCadastro();
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
	public agendamentoCadastro() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Downloads\\Aha-Soft-Standard-City-Drugstore.ico"));
		setTitle("Cadastro / Edi\u00E7\u00E3o de Agendamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labId = new JLabel("ID : ");
		labId.setHorizontalAlignment(SwingConstants.LEFT);
		labId.setBounds(10, 11, 59, 20);
		contentPane.add(labId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(10, 35, 97, 20);
		contentPane.add(txtId);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(10, 82, 159, 20);
		contentPane.add(txtData);
		
		JLabel labData = new JLabel("Data da consulta : ");
		labData.setBounds(10, 59, 140, 20);
		contentPane.add(labData);
		
		JLabel labHorario = new JLabel("Hor\u00E1rio : ");
		labHorario.setBounds(184, 59, 140, 20);
		contentPane.add(labHorario);
		
		txtHorario = new JTextField();
		txtHorario.setColumns(10);
		txtHorario.setBounds(184, 82, 159, 20);
		contentPane.add(txtHorario);
		
		JLabel labDuracao = new JLabel("Dura\u00E7\u00E3o da consulta : ");
		labDuracao.setBounds(184, 113, 140, 20);
		contentPane.add(labDuracao);
		
		txtDuracao = new JTextField();
		txtDuracao.setColumns(10);
		txtDuracao.setBounds(184, 136, 159, 20);
		contentPane.add(txtDuracao);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 136, 159, 20);
		contentPane.add(txtCpf);
		
		JLabel labCpf = new JLabel("CPF : ");
		labCpf.setBounds(10, 113, 140, 20);
		contentPane.add(labCpf);
		
		JLabel labNomePaciente = new JLabel("Nome do paciente : ");
		labNomePaciente.setBounds(10, 167, 140, 20);
		contentPane.add(labNomePaciente);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 190, 333, 20);
		contentPane.add(txtNome);
		
		JLabel labDataNascimento = new JLabel("Data de nascimento : ");
		labDataNascimento.setBounds(10, 217, 140, 20);
		contentPane.add(labDataNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(10, 240, 159, 20);
		contentPane.add(txtDataNascimento);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(184, 240, 159, 20);
		contentPane.add(txtTelefone);
		
		JLabel labTelefone = new JLabel("Telefone : ");
		labTelefone.setBounds(184, 217, 140, 20);
		contentPane.add(labTelefone);
		
		JLabel labNomeProfissional = new JLabel("Nome do profissional : ");
		labNomeProfissional.setBounds(10, 271, 140, 20);
		contentPane.add(labNomeProfissional);
		
		txtNomeProfissional = new JTextField();
		txtNomeProfissional.setColumns(10);
		txtNomeProfissional.setBounds(10, 294, 333, 20);
		contentPane.add(txtNomeProfissional);
		
		JLabel labValorConsulta = new JLabel("Valor da consulta (R$) : ");
		labValorConsulta.setBounds(184, 325, 140, 20);
		contentPane.add(labValorConsulta);
		
		JLabel labDesconto = new JLabel("Desconto (%) : ");
		labDesconto.setBounds(10, 377, 140, 20);
		contentPane.add(labDesconto);
		
		JLabel labConvenio = new JLabel("Conv\u00EAnio : ");
		labConvenio.setBounds(184, 379, 140, 20);
		contentPane.add(labConvenio);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salvar();
			}
		});
		btnNewButton.setBounds(254, 437, 89, 23);
		contentPane.add(btnNewButton);
		
		cbxConvenio = new JComboBox();
		cbxConvenio.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cbxConvenio.setSelectedIndex(0);
		cbxConvenio.setBounds(184, 399, 159, 22);
		contentPane.add(cbxConvenio);
		
		cbxTipoConsulta = new JComboBox();
		cbxTipoConsulta.setModel(new DefaultComboBoxModel(new String[] {"Cl\u00EDnico Geral", "Dentista", "Fisioterapeuta", "Cardiologista", "Dermatologista"}));
		cbxTipoConsulta.setSelectedIndex(0);
		cbxTipoConsulta.setBounds(10, 347, 159, 22);
		contentPane.add(cbxTipoConsulta);
		
		cbxDesconto = new JComboBox();
		cbxDesconto.setModel(new DefaultComboBoxModel(new String[] {"0 %", "1 %", "2 %", "3 %", "4 %", "5 %", "6 %", "7 %", "8 %", "9 %", "10 %", "11 %", "12 %", "13 %", "14 %", "15 %", "16 %", "17 %", "18 %", "19 %", "20 %", "21 %", "22 %", "23 %", "24 %", "25 %", "26 %", "27 %", "28 %", "29 %", "30 %", "31 %", "32 %", "33 %", "34 %", "35 %", "36 %", "37 %", "38 %", "39 %", "40 %", "41 %", "42 %", "43 %", "44 %", "45 %", "46 %", "47 %", "48 %", "49 %", "50 %", "51 %", "52 %", "53 %", "54 %", "55 %", "56 %", "57 %", "58 %", "59 %", "60 %", "61 %", "62 %", "63 %", "64 %", "65 %", "66 %", "67 %", "68 %", "69 %", "70 %", "71 %", "72 %", "73 %", "74 %", "75 %", "76 %", "77 %", "78 %", "79 %", "80 %", "81 %", "82 %", "83 %", "84 %", "85 %", "86 %", "87 %", "88 %", "89 %", "90 %", "91 %", "92 %", "93 %", "94 %", "95 %", "96 %", "97 %", "98 %", "99 %", "100 %"}));
		cbxDesconto.setBounds(10, 399, 97, 22);
		contentPane.add(cbxDesconto);
		
		JLabel labConsulta = new JLabel("Tipo de consulta : ");
		labConsulta.setBounds(10, 325, 140, 20);
		contentPane.add(labConsulta);
		
		txtValorConsulta = new JTextField();
		txtValorConsulta.setColumns(10);
		txtValorConsulta.setBounds(184, 348, 159, 20);
		contentPane.add(txtValorConsulta);
	}
	
	// Setar os dados nas TextField do Formulário
	public void showDados(Agendamento a) {
		try {
			DecimalFormat df = new DecimalFormat("#,###.00");
			txtId.setText(String.valueOf(a.getId()));
			txtData.setText(String.valueOf(a.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			txtHorario.setText(String.valueOf(a.getHorario().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
			txtDuracao.setText((String.valueOf(a.getDuracao())));
			txtCpf.setText(a.getCpf());
			txtValorConsulta.setText(String.valueOf(a.getValorConsulta()));
			txtNome.setText(a.getNomePaciente());
			txtTelefone.setText(a.getTelefone());
			txtDataNascimento.setText(String.valueOf(a.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));;
			txtNomeProfissional.setText(a.getNomeProfissional());
			cbxTipoConsulta.setSelectedItem(a.getTipo());
			cbxDesconto.setSelectedIndex(a.getPorcDesconto());
			cbxConvenio.setSelectedIndex(a.getConvenio());
			
		} catch(Exception e3) { }
	}
	
	// Botão Salvar
	public void Salvar() {
		try {
			// Transferir dados para objeto
			Agendamento a = new Agendamento();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			//DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			a.setData(LocalDate.parse(txtData.getText(), formatter));
			a.setHorario(LocalTime.parse(txtHorario.getText()));
			a.setCpf(txtCpf.getText());
			a.setDuracao(Float.parseFloat(txtDuracao.getText()));
			a.setNomePaciente(txtNome.getText());
			a.setDataNascimento(LocalDate.parse(txtDataNascimento.getText(),formatter));
			a.setTelefone(txtTelefone.getText());
			a.setTipo(cbxTipoConsulta.getSelectedItem().toString());
			a.setValorConsulta(Float.parseFloat(txtValorConsulta.getText()));
			a.setNomeProfissional(txtNomeProfissional.getText());
			a.setPorcDesconto(cbxDesconto.getSelectedIndex());
			a.setConvenio(cbxConvenio.getSelectedIndex());
			
			// Conferir se é Novo/Alterar e salvar
			AgendamentoDao aDao = new AgendamentoDao();
			if(txtId.getText().equals("")) { // Caso For NOVO
				aDao.inserir(a);
				JOptionPane.showMessageDialog(null, "Novo registro adicionado com sucesso.", "Adicionado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else { // Caso for ALTERAR
				a.setId(Integer.parseInt(txtId.getText()));
				aDao.alterar(a);
				JOptionPane.showMessageDialog(null, "Alterado com sucesso.", "Alterado com sucesso", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// Abrir Tela Inicial
			telaInicial Hscrn = new telaInicial();
			Hscrn.setVisible(true);
			this.dispose();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel salvar, verifique os dados ! Mais detalhes : " + e.toString(), "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
		}
	}
}
