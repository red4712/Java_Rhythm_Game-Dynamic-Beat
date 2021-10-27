package dynamic_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();

	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpaceImage1 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpaceImage2 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	static public int time;
	static public int changeTime = 12000;
	static public boolean S = false;
	static public boolean D = false;
	static public boolean F = false;
	static public boolean Space = false;
	static public boolean J = false;
	static public boolean K = false;
	static public boolean L = false;
	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpaceImage1, 540, 30, null);
		g.drawImage(noteRouteSpaceImage2, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.BOLD, 26));	//Font.PLAIN
		//g.setColor(Color.DARK_GRAY);
		if(Game.time < changeTime) {
			g.drawString("S", 270, 609);// 270 609
			g.drawString("D", 374, 609);
			g.drawString("F", 478, 609);
			g.drawString("SPACE BAR", 565, 609);
			g.drawString("J", 784, 609);
			g.drawString("K", 889, 609);
			g.drawString("L", 993, 609);
		}
		else {
			g.drawString("W", 270, 609);
			g.drawString("E", 374, 609);
			g.drawString("R", 478, 609);
			g.drawString("SPACE BAR", 565, 609);
			g.drawString("U", 784, 609);
			g.drawString("I", 889, 609);
			g.drawString("O", 993, 609);
		}
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		//g.drawString("000000", 565, 702);
		g.drawImage(blueFlareImage, 460, 450, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		S = true;
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		S = false;
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		D = true;
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		D = false;
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		F = true;
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		F = false;
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpaceImage1 = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpaceImage2 = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		Space = true;
	}

	public void releaseSpace() {
		noteRouteSpaceImage1 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpaceImage2 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		Space = false;
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		J = true;
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		J = false;
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		K = true;
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		K = false;
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("buttonEntered.mp3", false).start();
		L = true;
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		L = false;
	}

	@Override
	public void run() {
		dropNotes();
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes() {
		Beat[] beats = null;
		int gap = 500;
		if(titleName.equals("Interstellar OST - First Step")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(1000, "DF"),
					new Beat(4000, "K"),
					new Beat(4400, "J"),
					new Beat(4750, "K"),
					new Beat(5100, "J"),
					new Beat(5450, "K"),
					new Beat(5800, "J"),
					new Beat(6150, "K"),
					new Beat(6500, "J"),
					new Beat(6850, "K"),
					new Beat(7200, "J"),
					new Beat(7550, "K"),
					new Beat(7900, "J"),
					new Beat(8450, "K"),
					new Beat(8800, "J"),
					new Beat(9150, "K"),
					new Beat(9500, "J"),
					new Beat(9850, "DJKS"),//K
					new Beat(10200, "J"),
					new Beat(10550, "K"),
					new Beat(10900, "J"),
					new Beat(11250, "K"),
					new Beat(11600, "J"),
					new Beat(11950, "K"),
					new Beat(12300, "J"),
					new Beat(12650, "DKS"),
					new Beat(13000, "J"),
					new Beat(13350, "K"),
					new Beat(13700, "J"),
					new Beat(14050, "K"),
					new Beat(14400, "J"),
					new Beat(14750, "DKS"),
					new Beat(15100, "J"),
					new Beat(15450, "K"),
					new Beat(15800, "J"),
					new Beat(16150, "K"),
					new Beat(17500, "J"),
					new Beat(17850, "K"),
					new Beat(18200, "J"),
					new Beat(18550, "K"),
					new Beat(18900, "J"),
					new Beat(19250, "K"),
					new Beat(19600, "J"),
					new Beat(19950, "DKS"),
					new Beat(20300, "J"),
					
					//350
					/*new Beat(19950, "DKS"),
					new Beat(20300, "J"),
					new Beat(19950, "DKS"),
					new Beat(20300, "J"),
					new Beat(19950, "DKS"),
					new Beat(20300, "J"),
					new Beat(19950, "DKS"),
					new Beat(20300, "J"),
					new Beat(19950, "DKS"),
					new Beat(20300, "J"),
					new Beat(19950, "DKJS"),
					new Beat(15100, "J"),
					new Beat(15450, "K"),
					new Beat(15800, "J"),
					new Beat(16150, "K"),
					new Beat(17500, "J"),
					new Beat(19950, "DKS"),
					new Beat(20000, "J"),
					new Beat(15450, "K"),
					new Beat(15800, "J"),
					new Beat(16150, "K"),
					new Beat(15100, "J"),
					new Beat(15450, "K"),
					new Beat(15800, "J"),
					new Beat(16150, "K"),
					new Beat(15100, "J"),
					new Beat(15450, "K"),
					new Beat(15800, "J"),
					new Beat(15800, "DFK"),
					new Beat(15800, "J"),
					new Beat(15800, "JK"),
					new Beat(15800, "J"),
					new Beat(15800, "K"),
					new Beat(15800, "J"),
					new Beat(15800, "DFK"),
					new Beat(15800, "J"),
					new Beat(15800, "JK"),
					new Beat(15800, "J"),
					new Beat(15800, "K"),
					new Beat(15800, "J"),
					new Beat(15800, "DFJK"),
					new Beat(15800, "J"),
					new Beat(15800, "JK"),
					new Beat(15800, "J"),
					new Beat(15800, "DK"),
					new Beat(15800, "J"),
					new Beat(15800, "DFJK"),
					new Beat(15800, "J"),
					new Beat(15800, "JK"),
					new Beat(15800, "J"),
					new Beat(15800, "DK"),
					new Beat(15800, "J"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "AJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "ADJL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "JL"),
					new Beat(15800, "AD"),
					new Beat(15800, "ADJL"),
					new Beat(15800, "J"),
					new Beat(15800, "JL"),
					new Beat(15800, "K"),
					new Beat(15800, "J"),
					new Beat(15800, "K"),
					new Beat(15800, "J"),
					new Beat(15800, "ADJK"),
					new Beat(15800, "J"),
					new Beat(15800, "JKL"),
					new Beat(15800, "J"),
					new Beat(15800, "DK"),
					new Beat(15800, "J"),
					new Beat(15800, "ADJK"),
					new Beat(15800, "J"),
					new Beat(15800, "KL"),
					new Beat(15800, "JKL"),
					new Beat(15800, "J"),
					new Beat(15800, "DK"),
					new Beat(15800, "J"),
					new Beat(15800, "ADKL"),
					new Beat(15800, "J"),
					new Beat(15800, "JKL"),
					new Beat(15800, "J"),
					new Beat(15800, "ADK")*/
			};
		}
		else if(titleName.equals("Lunar")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap, "D"),
					new Beat(startTime + gap * 3, "J")
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
				time = beats[i].getTime();
				System.out.println(time);
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch(Exception e) {
					//e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgemiss.png")).getImage();
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgegood.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeperfect.png")).getImage();
		}
	}
}
