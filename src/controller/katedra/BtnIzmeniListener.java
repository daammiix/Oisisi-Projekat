package controller.katedra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.AppData;
import model.Katedra;
import util.Util;
import view.AppView;
import view.katedraDialogs.KatedreDialog;

public class BtnIzmeniListener implements MouseListener, ActionListener{
	private AppView view;
	private AppData data;
	
	public BtnIzmeniListener(AppView view, AppData data) {
		this.view = view;
		this.data = data;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Util.buttonEnteredColor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(null);
		btn.setEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton btn = (JButton)event.getSource();
		switch(btn.getActionCommand()) {
			case "Katedre":
				{
					KatedreDialog kd = AppView.getInstance().getKatedreDialog();
					int selectedRow = kd.getTable().getSelectedRow();
					if(selectedRow != -1) {
						Katedra katedra = AppData.getInstance().getKatedra().get(selectedRow);
						AppView.getInstance().getTrenutniSefKatedre().fillInSefKatedre(katedra);
						String textF = AppView.getInstance().getTrenutniSefKatedre().getTextField().getText();
						String text = textF.trim();
						if(text.equals("")) {
							AppView.getInstance().getTrenutniSefKatedre().getBtnMinus().setEnabled(false);
							AppView.getInstance().getTrenutniSefKatedre().getBtnPlus().setEnabled(true);
						} else {
							AppView.getInstance().getTrenutniSefKatedre().getBtnMinus().setEnabled(true);
							AppView.getInstance().getTrenutniSefKatedre().getBtnPlus().setEnabled(false);
						}
						AppView.getInstance().getSefKatedreDialog().clearTable();
						AppView.getInstance().getSefKatedreDialog().initTable();
						view.getTrenutniSefKatedre().setLocationRelativeTo(view.getFrame());
						view.getTrenutniSefKatedre().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(kd, "Niste oznacili katedru", "Error", 
								JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
			case "SefKatedre":
				{
					view.getSefKatedreDialog().setLocationRelativeTo(view.getFrame());
					view.getSefKatedreDialog().setVisible(true);
					break;
				}
		}
	}
}
