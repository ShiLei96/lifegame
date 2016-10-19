package lifegame;

import java.awt.event.*;

import javax.swing.*;

public class main_frame extends JFrame{
	private world game=new world();
	private JMenuBar menu=new JMenuBar();
	private JMenu options=new JMenu("Options");
	private JMenu help=new JMenu("Help");
	private JMenuItem randomChoice=new JMenuItem("Random");
	private JMenuItem squareChoice=new JMenuItem("Square");
	private JMenuItem rectChoice=new JMenuItem("Rectangle");
	private JMenuItem quitChoice=new JMenuItem("Quit");
	private JMenuItem copyRight=new JMenuItem("CopyRight");
	
	public main_frame(){
		randomChoice.addActionListener(new RandomListener());
		squareChoice.addActionListener(new SquareListener());
		rectChoice.addActionListener(new RectListener());
		quitChoice.addActionListener(new QuitListener());
		copyRight.addActionListener(new CopyRightListener());
		menu.add(options);
		menu.add(help);
		options.add(randomChoice);
		options.add(squareChoice);
		options.add(rectChoice);
		options.add(quitChoice);
		help.add(copyRight);
		this.setJMenuBar(menu);
		this.add(game);
	}
	
	class RandomListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.setRandom();
		}
	}
	
	
	class SquareListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.setSquare();
		}
	}
	
	class RectListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			game.setRectangle();
		}
	}

	class QuitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}

	class CopyRightListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null,"@copyright Ê¯ÀÚ/ÁõÎ°Î°  2016/8/31 edition 1.0",
					"copyright",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	public static void main(String[] args){
   		main_frame frame = new main_frame();
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 855);
        frame.setTitle("Game of Life");
        frame.setVisible(true);
        frame.setResizable(false);
	}

}
