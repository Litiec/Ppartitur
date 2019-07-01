//In order to use this library you need to install "themidibus" library
// use ableton to send TIMING_CLOCK to you midi port::: set it to 60BMP

import ppartitur.lib.*;// Main Library
import themidibus.*;

MidiBus bus;
Ppartitur partitur;

void setup(){
  size(1000,750, P2D);
  partitur = new Ppartitur(this, "Clarinet Bb");// Create the enviroment
  // add staffs with a clef using the enum Clef
  partitur.createStaff(Clef.G);// from 60 to 83 
  partitur.createStaff(Clef.F);// from 40 to 59 
  
  // Insert the notation - parameter: float speed, int[][] pitch, int[] bandMaster, int[]duration,int[]velocity
  //speed - BPM of the current slot sequencer
  // pitch - can be a serie of single notes (e.g. int[][]{{60},{67},{60}})  or chord(eg.int[][]{{60,65},{67,70},{60,65}}
  // bandMaster - define the pulse of the virtual conductor/basnMaster(e.g. 1,2 3 or 4);
  //the sum of the array most be equal to the total single notes or chord in the current slot sequencer
  partitur.insertData(60,new int[][]{{60},{57},{80}},new int[]{1,1,1},new int[]{60,60,60},new int[]{10,30,60});
  partitur.insertData(60,new int[][]{{60},{57},{80}, {80,60} },new int[]{1,1,1,1},new int[]{60,60,60,20},new int[]{10,30,60,127});
  bus = new MidiBus(this, "Bus 1", -1);
}

void draw(){
  partitur.display();
}

void rawMidi(byte[]data){
  if (data[0] == (byte)0xF8) partitur.play();/// the method must be called every single clockMidi tick;
}
