package dynamic_beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if (DynamicBeat.game == null) {
			return;
		}
		if(Game.time < Game.changeTime) {
			if (e.getKeyCode() == KeyEvent.VK_S) {
				DynamicBeat.game.pressS();
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				DynamicBeat.game.pressD();
			}
			if (e.getKeyCode() == KeyEvent.VK_F) {
				DynamicBeat.game.pressF();
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				DynamicBeat.game.pressSpace();
			}
			if (e.getKeyCode() == KeyEvent.VK_J) {
				DynamicBeat.game.pressJ();
			}
			if (e.getKeyCode() == KeyEvent.VK_K) {
				DynamicBeat.game.pressK();
			}
			if (e.getKeyCode() == KeyEvent.VK_L) {
				DynamicBeat.game.pressL();
			}
		}
		else {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				DynamicBeat.game.pressS();
			}
			if (e.getKeyCode() == KeyEvent.VK_E) {
				DynamicBeat.game.pressD();
			}
			if (e.getKeyCode() == KeyEvent.VK_R) {
				DynamicBeat.game.pressF();
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				DynamicBeat.game.pressSpace();
			}
			if (e.getKeyCode() == KeyEvent.VK_U) {
				DynamicBeat.game.pressJ();
			}
			if (e.getKeyCode() == KeyEvent.VK_I) {
				DynamicBeat.game.pressK();
			}
			if (e.getKeyCode() == KeyEvent.VK_O) {
				DynamicBeat.game.pressL();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (DynamicBeat.game == null) {
			return;
		}
		if(Game.time < Game.changeTime) {
			if (e.getKeyCode() == KeyEvent.VK_S) {
				DynamicBeat.game.releaseS();
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
				DynamicBeat.game.releaseD();
			}
			if (e.getKeyCode() == KeyEvent.VK_F) {
				DynamicBeat.game.releaseF();
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				DynamicBeat.game.releaseSpace();
			}
			if (e.getKeyCode() == KeyEvent.VK_J) {
				DynamicBeat.game.releaseJ();
			}
			if (e.getKeyCode() == KeyEvent.VK_K) {
				DynamicBeat.game.releaseK();
			}
			if (e.getKeyCode() == KeyEvent.VK_L) {
				DynamicBeat.game.releaseL();
			}
		}
		else {
			if (e.getKeyCode() == KeyEvent.VK_W || Game.S == true) {
				DynamicBeat.game.releaseS();
			}
			if (e.getKeyCode() == KeyEvent.VK_E || Game.D == true) {
				DynamicBeat.game.releaseD();
			}
			if (e.getKeyCode() == KeyEvent.VK_R || Game.F == true) {
				DynamicBeat.game.releaseF();
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE || Game.Space == true) {
				DynamicBeat.game.releaseSpace();
			}
			if (e.getKeyCode() == KeyEvent.VK_U || Game.J == true) {
				DynamicBeat.game.releaseJ();
			}
			if (e.getKeyCode() == KeyEvent.VK_I || Game.K == true) {
				DynamicBeat.game.releaseK();
			}
			if (e.getKeyCode() == KeyEvent.VK_O || Game.L == true) {
				DynamicBeat.game.releaseL();
			}
		}
	}

}
