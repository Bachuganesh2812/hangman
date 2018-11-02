package hangman_GUI;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HangmanPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mistakes;

	public HangmanPanel() {
		setLayout(null);
		mistakes = 6;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("X: " + e.getX() + " Y:" + e.getY());
			}
		});
	}

	public void setMistakes(int mistakes) {
		this.mistakes = mistakes;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		System.out.println("Paint Called");
		System.out.println(mistakes);
		// Draw Text
		g.drawLine(24, 258, 24, 22);
		g.drawLine(24, 22, 128, 22);
		g.drawLine(128, 22, 128, 50);

		if (mistakes <= 5) {
			g.drawOval(105, 50, 50, 50);
		}

		if (mistakes <= 4) {
			g.drawLine(128, 100, 128, 189);
		}

		if (mistakes <= 3) {
			g.drawLine(128, 120, 95, 150);
		}

		if (mistakes <= 2) {
			g.drawLine(128, 120, 160, 150);
		}

		if (mistakes <= 1) {
			g.drawLine(128, 189, 95, 245);
		}

	

		if (mistakes <= 0) {
			g.drawLine(128, 189, 160, 245);
			g.drawLine(113, 75, 123, 66);
			g.drawLine(113, 66, 123, 75);
			g.drawLine(138, 75, 148, 66);
			g.drawLine(138, 66, 148, 75);
			g.drawArc(113, 80, 35, 12, 0, 180);
		}

	}
}
