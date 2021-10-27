package dynamic_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;

	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S") || noteType.equals("SD") || noteType.equals("SJL") || 
				noteType.equals("SDJL") || noteType.equals("SDJK") || noteType.equals("SDKL") || noteType.equals("SDK")) {
			x = 228;
		}
		if(noteType.equals("D") || noteType.equals("DF") || noteType.equals("DK") ||noteType.equals("DKS") ||
				noteType.equals("DKJS") || noteType.equals("DFK") || noteType.equals("DFJK") || noteType.equals("DJKS")) {// D-S = 104
			x = 332;
		}
		if(noteType.equals("F")) {
			x = 436;
		}
		if(noteType.equals("Space")) {
			x = 540;
		}
		if(noteType.equals("J") || noteType.equals("JK") || noteType.equals("JL") || noteType.equals("JKL")){
			x = 744;
		}
		if(noteType.equals("K") || noteType.equals("KL")) {
			x = 848;
		}
		if(noteType.equals("L")) {// L-J = 208
			x = 952;
		}
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if(noteType.contentEquals("SD")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+104, y, null);
		}
		else if(noteType.contentEquals("SJL")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 744, y, null);
			g.drawImage(noteBasicImage, 952, y, null);
		}
		else if(noteType.contentEquals("SDK")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 332, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
		}
		else if(noteType.contentEquals("SDJK")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 332, y, null);
			g.drawImage(noteBasicImage, 744, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
		}
		else if(noteType.contentEquals("SDKL")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 332, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
			g.drawImage(noteBasicImage, 952, y, null);
		}
		else if(noteType.contentEquals("SDJL")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 332, y, null);
			g.drawImage(noteBasicImage, 744, y, null);
			g.drawImage(noteBasicImage, 952, y, null);
		}
		else if(noteType.contentEquals("DKS")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+208, y, null);
			g.drawImage(noteBasicImage, x+300, y, null);
			g.drawImage(noteBasicImage, x+516, y, null);
		}
		else if(noteType.contentEquals("DJKS")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 744, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
			g.drawImage(noteBasicImage, 540, y, null);
			g.drawImage(noteBasicImage, 640, y, null);
		}
		else if(noteType.contentEquals("DFK")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 436, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
		}
		else if(noteType.contentEquals("DFJK")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 436, y, null);
			g.drawImage(noteBasicImage, 744, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
		}
		else if(noteType.contentEquals("DK")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
		}
		else if(noteType.contentEquals("DF")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+104, y, null);
		}
		else if(noteType.contentEquals("JK")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
		}
		else if(noteType.contentEquals("JL")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 952, y, null);
		}
		else if(noteType.contentEquals("JKL")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 848, y, null);
			g.drawImage(noteBasicImage, 952, y, null);
		}
		else if(noteType.contentEquals("KL")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, 952, y, null);
		}
		else if(noteType.contentEquals("Space")){
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
		else {
			g.drawImage(noteBasicImage, x, y, null);
		}
	}

	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 620) {
			System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		if(y >= 587) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 573) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y >= 565) {
			System.out.println("Good");
			close();
			return "Good";
		}
		return "None";
	}
	
	public int getY() {
		return y;
	}
}
