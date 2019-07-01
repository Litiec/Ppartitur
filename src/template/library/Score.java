package ppartitur.lib;
import java.util.ArrayList;
import java.util.List;

import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PShape;

final class Score {
	private Ppartitur p;
	protected PGraphics score;
	private List<Staff> staffs;
	private String name;
	private PShape rule;
	private PShape velocity;
	private PGraphics dynamic;
	private int height = 80;
	protected Notation mynotation;
	protected Score(String name, Ppartitur p) {
		this.name = name;
		this.p = p;
		rule = p.applet.createShape(PConstants.GROUP);
		velocity = p.applet.createShape(PConstants.GROUP);
		for (int i = 0; i < p.node().hNode.length; i++) {
			PShape lines = p.applet.createShape(PConstants.LINE, p.node().hNode[i], 0, p.node().hNode[i], 79);
			rule.addChild(lines);
			if (i + 2 < p.node().hNode.length) {
				PShape vel = p.applet.createShape();
				vel.beginShape(PConstants.LINES);
				vel.vertex(p.node().hNode[i + 2], 79);
				vel.vertex(p.node().hNode[i + 2], 78);
				vel.endShape();
				velocity.addChild(vel);
			}
		}
		rule.setStroke(p.applet.color(255, 30));
		velocity.setStroke(p.applet.color(255, 0, 0, 150));
		velocity.setStrokeWeight(5);
		PFont dyn = Factory.bravuraFont(p, 25);
		dynamic = p.applet.createGraphics(p.applet.width, 80, PConstants.P2D);
		dynamic.beginDraw();
		dynamic.background(0, 0);
		dynamic.shape(rule, 0, 0);
		dynamic.fill(255);
		dynamic.textFont(dyn);
		dynamic.text("\uE52F", 90, 15);
		dynamic.text("\uE52B", 90, 73);
		dynamic.endDraw();
		staffs = new ArrayList<Staff>();
	}

	protected void createStaff(Clef clefType) {
		Staff s = new Staff(clefType, p, name);
		staffs.add(s);
		score = p.applet.createGraphics(p.applet.width, height += s.staticCtx().height, PConstants.P2D);
	}

	protected List<Staff> getStaff() {
		return staffs;
	}

	protected void update(Notation notation) {
		this.mynotation = notation;
		int y = 80;
		for (Parameter par : notation.getNotation()) {
			velocity.getChild(par.index - 2).setVertex(1, p.node().hNode[par.index], 80 - par.velocity);
		}
		for (Staff s : staffs) {
			s.update(notation);
		}
		score.beginDraw();
		score.background(255, 0);
		for (Staff s : staffs) {
			score.image(s.staticCtx(), 0, y);
			score.image(s.dynamicCtx(), 0, y);
			y += s.staticCtx().height;
		}
		score.image(dynamic, 0, 0);
		score.shape(velocity, 0, 0);
		score.endDraw();
	}
}
