package ppartitur.lib;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

final class Sequencer {
	private List<Notation> listNotation;
	Ppartitur p;
	private int index = -1;
	private int bar = 0;
	
	public Sequencer(Ppartitur p) {
		this.p = p;
		p.listen(this);
		
	}
	protected boolean finish() {
		boolean finish = false;
		if(bar<listNotation.size()) finish = false;
		else finish = true;
		return finish;
	}
	protected void popNotation() {
		if(listNotation!=null) {
			p.update(listNotation.get(bar++));
		}
		else {
			PApplet.println("Sequencer.java NotationNotFoundException");
			throw new NullPointerException();
		}
	}
	private void createEmptyNotation(float speed) {
		if(!p.score[0].getStaff().isEmpty()) {
			if(listNotation==null) listNotation = new ArrayList<Notation>();
			listNotation.add(new Notation(p, speed));
			index++;	
		}
		else {
			PApplet.println("Sequencer.java StaffNotFoundException");
			throw new NullPointerException();
		}
	}
	private void addParameter(int duration,int velocity, int...chord) {
		if(listNotation!=null) {
			listNotation.get(index).create(duration, velocity, chord);	
		}
		else {
			PApplet.println("Sequencer.java NotationNotFoundException");
			throw new NullPointerException();
		}
	}
	private void createBandmaster(int...gesture) {
		if(listNotation!=null) {
			listNotation.get(index).setBandmaster(gesture);
		}
		else {
			PApplet.println("Sequencer.java NotationNotFoundException");
			throw new NullPointerException();
		}
	}
	protected void insertData(float speed, int[][] pitch, int[] bandMaster, int[]duration,int[]velocity) {
		createEmptyNotation(speed);
		for(int i = 0; i < pitch.length; i++) {
			addParameter(duration[i],velocity[i], pitch[i]);
		}
		createBandmaster(bandMaster);
	}
	protected List<Notation> listNotation() {
		return listNotation;
	}

}
