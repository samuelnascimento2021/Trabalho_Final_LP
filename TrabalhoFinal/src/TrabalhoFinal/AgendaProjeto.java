package TrabalhoFinal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AgendaProjeto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField tfData;
	private static JTextField tfHora;
	private static JTextField tfDescricao;
	private static JTextField tfAcao;

	/**
	 * Create the panel.
	 */
	public AgendaProjeto() {
		setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(24, 31, 46, 14);
		add(lblData);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHora.setBounds(236, 31, 46, 14);
		add(lblHora);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setBounds(24, 101, 66, 14);
		add(lblDescricao);
		
		JLabel lblAcao = new JLabel("A\u00E7\u00E3o");
		lblAcao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAcao.setBounds(24, 191, 46, 14);
		add(lblAcao);
		
		tfData = new JTextField();
		tfData.setBounds(100, 28, 100, 20);
		add(tfData);
		tfData.setColumns(10);
		
		tfHora = new JTextField();
		tfHora.setBounds(292, 28, 94, 20);
		add(tfHora);
		tfHora.setColumns(10);
		
		tfDescricao = new JTextField();
		tfDescricao.setBounds(100, 73, 286, 71);
		add(tfDescricao);
		tfDescricao.setColumns(10);
		
		tfAcao = new JTextField();
		tfAcao.setBounds(100, 188, 153, 20);
		add(tfAcao);
		tfAcao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public static void escritorAgenda(String path) throws IOException {

			try {
				BufferedWriter escrever = new BufferedWriter(new FileWriter(path, true));
				
				ArrayList<String> agenda = new ArrayList<String>();
				
				if(tfData.getText().trim().isEmpty()
					|| tfHora.getText().trim().isEmpty()
					|| tfDescricao.getText().trim().isEmpty()
					|| tfAcao.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Por gentileza preencher todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
				else {		
						String Data = tfData.getText();
						String Hora = tfHora.getText();
						String Descricao = tfDescricao.getText();
						String Acao = tfAcao.getText();
						
					
						agenda.add("-----------------------------------------------"+"\r\n"+"Cadastro da agenda do projeto: " 
								+ "\r\n"+ "Data: " + Data + "\r\n"
								+ "Hora: " + Hora + "\r\n" 
								+ "Descrição: " + Descricao + "\r\n" 
								+ "Acao: " + Acao +"\r\n"
								);
								
						String agendaString = String.join(" ", agenda);
						
						escrever.append(agendaString);
						escrever.close();
						JOptionPane.showMessageDialog(null, "Agenda cadastrada com sucesso");
						
						tfData.setText("");
						tfHora.setText("");
						tfDescricao.setText("");
						tfAcao.setText("");
				}
				
			}
			catch(IOException e) {
					JOptionPane.showMessageDialog(null, "Erro!"+e.getMessage());
				}
			}
			
			public void actionPerformed(ActionEvent e) {
				String path="cadastro.txt";
				try {
					escritorAgenda(path.toString());
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente!");
				}
			}
				
			
		});
		btnSalvar.setBounds(111, 244, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfData.setText("");
				tfHora.setText("");
				tfDescricao.setText("");
				tfAcao.setText("");
			}
		});
		btnLimpar.setBounds(269, 244, 89, 23);
		add(btnLimpar);

	}
}
