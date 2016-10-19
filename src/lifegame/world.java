package lifegame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class world extends JPanel{
	private final int length_square=20;
	private int rows=42,cols=52;
	private int height,width;
	int allNum[][]=new int[42][52];
	private int allNextNum[][]=new int[42][52];
	
	public world(){
		height=(rows-2)*length_square;
		width=(cols-2)*length_square;
		this.setSize(new Dimension(width,height));
		init();
	}
	public void init(){
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++){
				allNum[i][j]=0;
				allNextNum[i][j]=0;
			}
	}
	
	public void setRandom(){
		init();
		double randomNum;
		for(int i=1;i<rows-1;i++)
			for(int j=1;j<cols-1;j++){
				randomNum=Math.random();
				if(randomNum<=0.1)
					allNum[i][j]=1;
				else 
					allNum[i][j]=0;
			}
		repaint();
		Timer timer=new Timer(500,new TimerListener());
		timer.start();
	}
	
	public void setSquare(){
		init();
		for(int i=10;i<30;i++)
		{
			allNum[i][16]=1;
			allNum[i][35]=1;
		}
		for(int i=16;i<35;i++)
		{
			allNum[10][i]=1;
			allNum[29][i]=1;
		}
		repaint();
		Timer timer=new Timer(500,new TimerListener());
		timer.start();
	}
	
	public void setRectangle(){
		init();
		allNum[10][20]=1;
		for(int i=1;i<=10;i++)
		{
			allNum[10+i][20+i]=1;
			allNum[10+i][20-i]=1;
		}
		for(int i=0;i<20;i++)
		{
			allNum[20][10+i]=1;
		}
		repaint();
		Timer timer=new Timer(500,new TimerListener());
		timer.start();
	}
	
	private boolean isAlive(int i,int j){
		int num_Alive;
		num_Alive=allNum[i-1][j-1]
				 +allNum[i-1][j]
				 +allNum[i-1][j+1]
				 +allNum[i][j-1]
				 +allNum[i][j+1]
				 +allNum[i+1][j-1]
				 +allNum[i+1][j]
				 +allNum[i+1][j+1];
		if(num_Alive==3){
			return true;
		}
		else if(num_Alive==2){
			if(allNum[i][j]==1)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public void nextState(){
		for(int i=1;i<rows-1;i++)
			for(int j=1;j<cols-1;j++){
				if(isAlive(i,j))
					allNextNum[i][j]=1;
				else
					allNextNum[i][j]=0;
			}
		for(int i=1;i<rows-1;i++)
			for(int j=1;j<cols-1;j++)
				allNum[i][j]=allNextNum[i][j];
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		for(int i=0;i<=rows-2;i++)
			g.drawLine(0, i*length_square, width, i*length_square);
		for(int i=0;i<=cols-2;i++)
			g.drawLine(i*length_square, 0, i*length_square, height);
		for(int i=1;i<rows-1;i++)
			for(int j=1;j<cols-1;j++)
				if(allNum[i][j]==1)
					g.fillRect((j-1)*length_square, (i-1)*length_square,length_square, length_square);
	}
	
	class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			nextState();
			repaint();
		}
	}
}