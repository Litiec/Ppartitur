package ppartitur.lib;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PShape;

final class Staff {
	private PGraphics staticCtx;
	private PGraphics dynamicCtx;
	private PGraphics clef;
	private PShape lines;
	private PShape staff;
	private PShape endLoop;
	protected int max, min;
	private Ppartitur p;
	Staff(Clef clefType, Ppartitur p, String name){
		this.p = p;
		this.max = clefType.max;
		this.min = clefType.min;
		staticCtx = p.applet.createGraphics(p.applet.width, 100, PConstants.P2D);
		dynamicCtx = p.applet.createGraphics(p.applet.width, 100, PConstants.P2D);
		endLoop = p.applet.createShape(PConstants.RECT,0,0,staticCtx.width, staticCtx.height);
		endLoop.setFill(p.applet.color(0, 150));
		clef = p.applet.createGraphics(40, 100,PConstants.P2D);
		PFont clefextend = Factory.bravuraFont(p, 40);
		clef.beginDraw();
		clef.background(255,0);
		clef.fill(0);
		clef.textFont(clefextend);
		clef.text(clefType.ref, clefType.pos[0], clefType.pos[1]);
		clef.endDraw();
		lines = p.applet.createShape(PConstants.GROUP);
		for(int y = p.node().vNode.length-4; y > 2; y--) {
			if(y%2==1) {
				PShape line = p.applet.createShape(PConstants.LINE,0, p.node().vNode[y],staticCtx.width, p.node().vNode[y]);
				lines.addChild(line);
			}
		}
		staff = p.applet.createShape(PConstants.GROUP);
		staff.addChild(lines);
		staticCtx.beginDraw();
		staticCtx.background(255);
		staticCtx.shape(staff,0,15);
		staticCtx.fill(0);
		staticCtx.textSize(10);
		staticCtx.text(name,35, 15);
		staticCtx.image(clef,0,0);
		staticCtx.endDraw();
	}
	protected PGraphics staticCtx() {
		return staticCtx;
	}
	protected PGraphics dynamicCtx() {
		return dynamicCtx;
	}
	protected final void update(Notation notation) {
		PShape duration = p.applet.createShape(PConstants.GROUP);
		PShape dur = p.applet.createShape();
		int index = 0;
		dynamicCtx.beginDraw();
		dynamicCtx.background(255,0);
		for(Parameter par: notation.getNotation()) {
			for(Pitch pitch: par.chord) {
				if(pitch.ordinal>=min&&pitch.ordinal<=max||pitch.ordinal==0) {
					dynamicCtx.shape(pitch.pitchShape, p.node().hNode[par.index], 15);
					if(pitch.ordinal!=0) {
						dur = p.applet.createShape(PConstants.LINE, p.node().hNode[par.index]+12,p.node().vNode[pitch.nodeIndex],
								p.node().hNode[par.index]+par.duration-12, p.node().vNode[pitch.nodeIndex]);
						duration.addChild(dur);
					}
				}
			}
			index=par.index;
		}
		index++;
		duration.setStroke(p.applet.color(21,148,101,175));
		duration.setStrokeWeight(4);
		dynamicCtx.shape(duration,0,15);
		if(index<p.node().hNode.length) dynamicCtx.shape(endLoop, p.node().hNode[index],0);
		dynamicCtx.endDraw();
	}
}
