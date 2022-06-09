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

public class CadastroDadosProjeto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField tfTitulo;
	private static JTextField tfObjetivo;
	private static JTextField tfEndereco;
	private static JTextField tfDataInicio;
	private static JTextField tfStatus;

	/**
	 * Create the panel.
	 * @param listaDadosProjeto 
	 */
	public CadastroDadosProjeto() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(24, 31, 47, 14);
		add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(108, 28, 155, 20);
		add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObjetivo.setBounds(24, 80, 57, 14);
		add(lblObjetivo);
		
		tfObjetivo = new JTextField();
		tfObjetivo.setBounds(108, 77, 253, 20);
		add(tfObjetivo);
		tfObjetivo.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereco.setBounds(24, 129, 65, 14);
		add(lblEndereco);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(108, 126, 253, 20);
		add(tfEndereco);
		tfEndereco.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data de in\u00EDcio");
		lblDataInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataInicio.setBounds(24, 178, 86, 14);
		add(lblDataInicio);
		
		tfDataInicio = new JTextField();
		tfDataInicio.setBounds(108, 175, 106, 20);
		add(tfDataInicio);
		tfDataInicio.setColumns(10);
		
		tfStatus = new JTextField();
		tfStatus.setBounds(108, 224, 127, 20);
		add(tfStatus);
		tfStatus.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(24, 227, 46, 14);
		add(lblStatus);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public static void escritorCadastro(String path) throws IOException {
				
			try {	
				BufferedWriter escrever = new BufferedWriter(new FileWriter(path, true));
				
				ArrayList<String> dados = new ArrayList<String>();
				
				if(tfTitulo.getText().trim().isEmpty()
						|| tfObjetivo.getText().trim().isEmpty()
						|| tfEndereco.getText().trim().isEmpty()
						|| tfDataInicio.getText().trim().isEmpty()
						|| tfStatus.getText().trim().isEmpty()) {
						
						JOptionPane.showMessageDialog(null, "Por gentileza preencher todos os campos", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				else {
					String Titulo = tfTitulo.getText();
					String Objetivo = tfObjetivo.getText();
					String Endereco = tfEndereco.getText();
					String DataInicio = tfDataInicio.getText();
					String Status = tfStatus.getText();
					
					
					dados.add("-----------------------------------------------"+"\r\n"+"Cadastro de dados do projeto: \r\n"
					+ "Título: " + Titulo + "\r\n"	
					+ "Objetivo: " + Objetivo + "\r\n"				
					+ "Endereço: " + Endereco + "\r\n"			
					+ "DataInicio: " + DataInicio + "\r\n"			
					+ "Status: " + Status+ "\r\n");
					
					String dadosString = String.join(" ", dados);
					
					escrever.append(dadosString);
											
					escrever.close();
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
					
					tfTitulo.setText("");
					tfObjetivo.setText("");
					tfEndereco.setText("");
					tfDataInicio.setText("");
					tfStatus.setText("");
				}
			}
			
			catch(IOException e2) 
			{
				JOptionPane.showMessageDialog(null, "Erro!"+e2.getMessage());
			}
			
		}
			
			public void actionPerformed(ActionEvent e) {
				String path="cadastro.txt";
				try {
					escritorCadastro(path.toString());
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente!");
				}
			}
		});
		
		btnSalvar.setBounds(125, 266, 89, 23);
		add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTitulo.setText("");
				tfObjetivo.setText("");
				tfEndereco.setText("");
				tfDataInicio.setText("");
				tfStatus.setText("");
			}
		});
		btnLimpar.setBounds(250, 266, 89, 23);
		add(btnLimpar);

	}

}
