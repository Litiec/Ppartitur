//In order to use this library you need to install "themidibus" library
// use ableton to send TIMING_CLOCK to you midi port::: set it to 60BMP

import ppartitur.lib.*;// Main Library
import themidibus.*;

MidiBus bus;
Ppartitur partitur;

void setup(){
  size(1000,750, P2D);
   partitur = new Ppartitur(this, "Piano");// Create the enviroment
   partitur.createStaff(Clef.G);// from 60 to 83 
   partitur.createStaff(Clef.F);// from 40 to 59 
   //Try out with different bandmaster:
   partitur.insertData(100,new int[][]{{0},{0},{0},{0},{0},{0},{0}},new int[]{1,1,1,1,1,1,1},new int[]{0,0,0,0,0,0,0},new int[]{0,0,0,0,0,0,0});
   //partitur.insertData(100,new int[][]{{0},{0},{0},{0},{0},{0},{0}},new int[]{3,4},new int[]{0,0,0,0,0,0,0},new int[]{0,0,0,0,0,0,0});
   //partitur.insertData(100,new int[][]{{0},{0},{0},{0},{0},{0},{0}},new int[]{3,2,2},new int[]{0,0,0,0,0,0,0},new int[]{0,0,0,0,0,0,0});
   //partitur.insertData(100,new int[][]{{0},{0},{0},{0},{0},{0},{0}},new int[]{3,1,3},new int[]{0,0,0,0,0,0,0},new int[]{0,0,0,0,0,0,0});
   bus = new MidiBus(this, "Bus 1", -1);
}

void draw(){
  partitur.display();
}

void rawMidi(byte[]data){
  if (data[0] == (byte)0xF8) partitur.play();/// the method must be called every single clockMidi tick;
}
