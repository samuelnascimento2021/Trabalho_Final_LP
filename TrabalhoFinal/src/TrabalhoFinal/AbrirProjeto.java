package TrabalhoFinal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AbrirProjeto extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AbrirProjeto() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			
			public static void leitor(String path) throws IOException {
			
				try {	
				
				BufferedReader buffRead = new BufferedReader(new FileReader(path));
				String linha = "";
				String n="";
								
				while (true) {
					if (linha != null) {
						try {
							n = n + linha + "\n";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else
						break;
					linha = buffRead.readLine();
				}
				buffRead.close();
				
				JTextArea textArea = new JTextArea(n);
				JScrollPane scrollPane = new JScrollPane(textArea);  
				textArea.setLineWrap(true);  
				textArea.setWrapStyleWord(true); 
				scrollPane.setPreferredSize( new Dimension( 300, 300 ) );
				JOptionPane.showMessageDialog(null, scrollPane, "Resultado"+n, JOptionPane.INFORMATION_MESSAGE);
				}
				
				catch (IOException e) {
					
					JOptionPane.showMessageDialog(null, "Erro", "Ocorreu um erro, tente novamente!", JOptionPane.ERROR_MESSAGE);
					
				}
			}
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String path="cadastro.txt";
					leitor(path.toString());
				
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Erro", "Ocorreu um erro, tente novamente!", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			}
		);
		btnNewButton.setBounds(157, 203, 120, 49);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Clique no bot\u00E3o abaixo\r\n\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(99, 35, 220, 54);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("para abrir o registro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(119, 81, 214, 36);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("de voluntariado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(140, 128, 160, 23);
		add(lblNewLabel_2);

	}
}
