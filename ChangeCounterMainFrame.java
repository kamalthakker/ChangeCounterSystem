import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;



public class ChangeCounterMainFrame extends JFrame {
	
	private final boolean              SUCCESS = true;
	private String                     title   = "Change Counter System";

	private Container                  contentPane;
	private JMenuBar			       menuBar;
	private JMenu                      fileMenu;
	private JMenuItem                  fileOpen;
	private JPanel                     filePanel;
	private JPanel                     outputPanel;
	private ActionListenerHandler      actionListener;
	
	private class ActionListenerHandler implements ActionListener
	{
		private JFrame frame;
		
		public ActionListenerHandler(JFrame parent)
		{
			frame = parent;
		}

		public void actionPerformed(ActionEvent event) {
			
			if(event.getActionCommand().equals("fileopen")) {
				FileOpen();
			}
			
		}
	}
	
	
	public ChangeCounterMainFrame() {
		
		setTitle("Change Counter System");
		
		contentPane = getContentPane( );
		
		Toolkit toolkit = Toolkit.getDefaultToolkit( );
		Dimension screenSize = toolkit.getScreenSize( );
		setSize((int)(screenSize.width * 0.75), (int)(screenSize.height * 0.75));
		setLocation((int)((screenSize.getWidth() - getWidth()) / 2), (int)((screenSize.getHeight() - getHeight()) / 2));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionListener = new ActionListenerHandler(this);
		
		// File Menu
		menuBar = new JMenuBar( );
		fileMenu = new JMenu("File");
		fileOpen = new JMenuItem("Open");
		fileOpen.setActionCommand("fileopen");
		fileOpen.addActionListener(actionListener);
		fileMenu.add(fileOpen);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		//Panels
		filePanel = new JPanel(new GridLayout());
		filePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Files"),
				                                                BorderFactory.createEmptyBorder(20, 200, 20, 200)));
		filePanel.setBackground(Color.white);
//		filePanel.setPreferredSize(new Dimension(400, 50));
		outputPanel = new JPanel(new GridBagLayout());
		outputPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Output"),
				                                                       BorderFactory.createEmptyBorder(40, 400, 40, 400)));
		outputPanel.setBackground(Color.white);
//		filePanel.setPreferredSize(new Dimension(200, 50));
		
		contentPane.add(filePanel, BorderLayout.WEST);
		contentPane.add(outputPanel, BorderLayout.EAST);
		
		SwingUtilities.updateComponentTreeUI(this);
		
		setVisible(true);
	}
	
	private boolean FileOpen( )
	{
		JFileChooser fileChooser = new JFileChooser( );
		fileChooser.showOpenDialog(this);
		File selectedFile = fileChooser.getSelectedFile( );
		return true;
	}
}
