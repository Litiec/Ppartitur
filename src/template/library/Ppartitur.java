package ppartitur.lib;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
public final class Ppartitur{
	protected PApplet applet;
	private PGraphics frame;
	private Node node;
	Score[] score;
	PCset pcset;
	private int bar = 0;
	private int indexScore = 0;
	private int indexNode;
	private float speed;
	private int clock;
	private float percent;
	private int iswitch;
	private boolean gate;
	Sequencer seq;
	
	public Ppartitur(PApplet applet, String name){
		this.applet = applet;
		node = new Node(applet);
		pcset = new PCset(this); 
		frame = applet.createGraphics(applet.width, applet.height, PConstants.P2D);
		score = new Score[2];
		score[0] = new Score(name, this);
		score[1] = new Score(name, this);
		seq = new Sequencer(this);
	}
	protected void listen (Sequencer seq) {
		this.seq = seq;
	}
	
	public void createStaff(Clef clefType) {
		score[0].createStaff(clefType);
		score[1].createStaff(clefType);
		pcset.genPcset(clefType);
	}
	public void insertData(float speed, int[][] pitch, int[] bandMaster, int[]duration,int[]velocity) {
		boolean init = false;
		if(seq.listNotation()== null) {
			seq.insertData(60,new int[][]{{0},{0},{0}},new int[]{1,1,1},new int[]{1,1,1},new int[]{1,1,1});
			init = true;
		} 
		seq.insertData(speed, pitch, bandMaster, duration, velocity);
		if(init)initScore();
	}
	protected Node node() {
		return node;
	}
	protected PCset pcset() {
		return pcset;
	}
	public void display() {
		frame.beginDraw();
		frame.fill(0,30);
		frame.noStroke();
		frame.rect(0, 0, frame.width, frame.height);
		for(int i = 0; i < score.length; i++) {
			frame.image(score[i].score,0,i*score[i].score.height);
		}
		displaybandMaster();
		frame.fill(0,255,0);
		frame.textSize(10);
		frame.text("Bar "+Integer.toString(bar), 0, 15);
		frame.endDraw();
		applet.image(frame, 0, 0);
	}
	protected void update(Notation notation) {
		int i = modulos(iswitch,2);
		score[i].update(notation);
		iswitch++;
	}
	private void initScore() {
		for(int i = 0; i < seq.listNotation().size();i++) {
			seq.popNotation();
		}
		iswitch = 0;
	}
	private void displaybandMaster() {
		if(gate) { 
			if(!seq.finish()) seq.popNotation();
			gate = false;
		}
		int i = modulos(indexScore,2);
		int size = score[i].mynotation.getBandmaster().size();
		float posX = (PApplet.lerp(node.hNode[indexNode], node.hNode[indexNode]+60, percent));
		float y = score[i].mynotation.getBandmaster().get(modulos((int)posX,size));
		frame.stroke(0, 255,0);
		frame.strokeWeight(12);
		frame.point(posX+120, (i*score[i].score.height+(80+y)));
	}
	public void play() {
		int i = modulos(indexScore,2);
		float div = (float)60.0/score[i].mynotation.speed;
		speed = (float)Math.floor(24*div);
		int size = score[i].mynotation.getBandmaster().size();
		int edge = size/60;
		clock++;
		percent = (clock % speed)/speed;
		if(clock == speed) {
			clock = 0;
			indexNode++;
		}
		if(indexNode == edge) {
			bar++;
			indexNode = 0;
			gate = true;
			indexScore++;
		}
	}
	protected int modulos(long value, int mod) {
		int q = (int) (value/mod);
		int p = q*mod;
		int m = (int) (value-p);
		return m;
	}
}

