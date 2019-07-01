package ppartitur.lib;
import java.util.HashMap;
import java.util.Map;

final class PCset {
	Map<Integer, Pitch> pcset = new HashMap<Integer, Pitch>();
	Ppartitur p;
	PCset(Ppartitur p){
		this.p = p;
		pcset.put(0, new Pitch(0,-1, false, p));
	}
	protected void genPcset(Clef type) {
	    switch(type) {
	    case F15:
	      pcset.put(21, new Pitch(21, 10, false,p));//A0
	      pcset.put(22, new Pitch(22, 10, true,p));
	      pcset.put(23, new Pitch(23, 9, false,p));//B
	      pcset.put(24, new Pitch(24, 8, false,p));//C
	      pcset.put(25, new Pitch(25, 8, true,p));
	      pcset.put(26, new Pitch(26, 7, false,p));//D
	      pcset.put(27, new Pitch(27, 7, true,p));
	      pcset.put(28, new Pitch(28, 6, false,p));//E1
	      pcset.put(29, new Pitch(29, 5, false,p));//F
	      pcset.put(30, new Pitch(30, 5, true,p));
	      pcset.put(31, new Pitch(31, 4, false,p));//G
	      pcset.put(32, new Pitch(32, 4, true,p));
	      pcset.put(33, new Pitch(33, 3, false,p));//A
	      pcset.put(34, new Pitch(34, 3, true,p));
	      pcset.put(35, new Pitch(35, 2, false,p));//B
	      pcset.put(36, new Pitch(36, 1, false,p));//C
	      pcset.put(37, new Pitch(37, 1, true,p));
	      pcset.put(38, new Pitch(38, 0, false,p));//D
	      pcset.put(39, new Pitch(39, 0, true,p));  
	      break;
	    case F:
	      pcset.put(40, new Pitch(40, 13, false,p));//E2
	      pcset.put(41, new Pitch(41, 12, false,p));//F
	      pcset.put(42, new Pitch(42, 12, true,p));
	      pcset.put(43, new Pitch(43, 11, false,p));//G
	      pcset.put(44, new Pitch(44, 11, true,p));
	      pcset.put(45, new Pitch(45, 10, false,p));//A
	      pcset.put(46, new Pitch(46, 10, true,p));
	      pcset.put(47, new Pitch(47, 9, false,p));//B
	      pcset.put(48, new Pitch(48, 8, false,p));//C
	      pcset.put(49, new Pitch(49, 8, true,p));
	      pcset.put(50, new Pitch(50, 7, false,p));//D
	      pcset.put(51, new Pitch(51, 7, true,p));
	      pcset.put(52, new Pitch(52, 6, false,p));//E3
	      pcset.put(53, new Pitch(53, 5, false,p));//F
	      pcset.put(54, new Pitch(54, 5, true,p));
	      pcset.put(55, new Pitch(55, 4, false,p));//G
	      pcset.put(56, new Pitch(56, 4, true,p));
	      pcset.put(57, new Pitch(57, 3, false,p));//A
	      pcset.put(58, new Pitch(58, 3, true,p));
	      pcset.put(59, new Pitch(59, 2, false,p));//B3
	      break;
	    case G15:
	      pcset.put(84, new Pitch(84, 13, false,p));//C6
	      pcset.put(85, new Pitch(85, 13, true,p));
	      pcset.put(86, new Pitch(86, 12, false,p));//D
	      pcset.put(87, new Pitch(87, 12, true,p));
	      pcset.put(88, new Pitch(88, 11, false,p));//E
	      pcset.put(89, new Pitch(89, 10, false,p));//F
	      pcset.put(90, new Pitch(90, 10, true,p));
	      pcset.put(91, new Pitch(91, 9, false,p));//G
	      pcset.put(92, new Pitch(92, 9, true,p));
	      pcset.put(93, new Pitch(93, 8, false,p));//A
	      pcset.put(94, new Pitch(94, 8, true,p));
	      pcset.put(95, new Pitch(95, 7, false,p));//B

	      pcset.put(96, new Pitch(96, 6, false,p));//C7
	      pcset.put(97, new Pitch(97, 6, true,p));
	      pcset.put(98, new Pitch(98, 5, false,p));//D
	      pcset.put(99, new Pitch(99, 5, true,p));
	      pcset.put(100, new Pitch(100, 4, false,p));//E
	      pcset.put(101, new Pitch(101, 3, false,p));//F
	      pcset.put(102, new Pitch(102, 3, true,p));
	      pcset.put(103, new Pitch(103, 2, false,p));//G
	      pcset.put(104, new Pitch(104, 2, true,p));
	      pcset.put(105, new Pitch(105, 1, false,p));//A
	      pcset.put(106, new Pitch(106, 1, true,p));
	      pcset.put(107, new Pitch(107, 0, false,p));//B
	      break;
	    case C_G:
	      pcset.put(72, new Pitch(72, 6, false,p));//C5
	      pcset.put(73, new Pitch(73, 6, true,p));
	      pcset.put(74, new Pitch(74, 5, false,p));//D
	      pcset.put(75, new Pitch(75, 5, true,p));
	      pcset.put(76, new Pitch(76, 4, false,p));//E
	      pcset.put(77, new Pitch(77, 3, false,p));//F
	      pcset.put(78, new Pitch(78, 3, true,p));
	      pcset.put(79, new Pitch(79, 2, false,p));//G
	      pcset.put(80, new Pitch(80, 2, true,p));
	      pcset.put(81, new Pitch(81, 1, false,p));//A
	      pcset.put(82, new Pitch(82, 1, true,p));
	      pcset.put(83, new Pitch(83, 0, false,p));//B
	      break;
	    case G:
	      pcset.put(60, new Pitch(60, 13, false,p));//C4
	      pcset.put(61, new Pitch(61, 13, true,p));
	      pcset.put(62, new Pitch(62, 12, false,p));//D
	      pcset.put(63, new Pitch(63, 12, true,p));
	      pcset.put(64, new Pitch(64, 11, false,p));//E
	      pcset.put(65, new Pitch(65, 10, false,p));//F
	      pcset.put(66, new Pitch(66, 10, true,p));
	      pcset.put(67, new Pitch(67, 9, false,p));//G
	      pcset.put(68, new Pitch(68, 9, true,p));
	      pcset.put(69, new Pitch(69, 8, false,p));//A
	      pcset.put(70, new Pitch(70, 8, true,p));
	      pcset.put(71, new Pitch(71, 7, false,p));//B

	      pcset.put(72, new Pitch(72, 6, false,p));//C5
	      pcset.put(73, new Pitch(73, 6, true,p));
	      pcset.put(74, new Pitch(74, 5, false,p));//D
	      pcset.put(75, new Pitch(75, 5, true,p));
	      pcset.put(76, new Pitch(76, 4, false,p));//E
	      pcset.put(77, new Pitch(77, 3, false,p));//F
	      pcset.put(78, new Pitch(78, 3, true,p));
	      pcset.put(79, new Pitch(79, 2, false,p));//G
	      pcset.put(80, new Pitch(80, 2, true,p));
	      pcset.put(81, new Pitch(81, 1, false,p));//A
	      pcset.put(82, new Pitch(82, 1, true,p));
	      pcset.put(83, new Pitch(83, 0, false,p));//B
	      break;
	    case C:
	      pcset.put(48, new Pitch(48, 14, false,p));//C
	      pcset.put(49, new Pitch(49, 14, true,p));
	      pcset.put(50, new Pitch(50, 13, false,p));//D
	      pcset.put(51, new Pitch(51, 13, true,p));
	      pcset.put(52, new Pitch(52, 12, false,p));//E3
	      pcset.put(53, new Pitch(53, 11, false,p));//F
	      pcset.put(54, new Pitch(54, 11, true,p));
	      pcset.put(55, new Pitch(55, 10, false,p));//G
	      pcset.put(56, new Pitch(56, 10, true,p));
	      pcset.put(57, new Pitch(57, 9, false,p));//A
	      pcset.put(58, new Pitch(58, 9, true,p));
	      pcset.put(59, new Pitch(59, 8, false,p));//B3

	      pcset.put(60, new Pitch(60, 7, false,p));//C4
	      pcset.put(61, new Pitch(61, 7, true,p));
	      pcset.put(62, new Pitch(62, 6, false,p));//D
	      pcset.put(63, new Pitch(63, 6, true,p));
	      pcset.put(64, new Pitch(64, 5, false,p));//E
	      pcset.put(65, new Pitch(65, 4, false,p));//F
	      pcset.put(66, new Pitch(66, 4, true,p));
	      pcset.put(67, new Pitch(67, 3, false,p));//G
	      pcset.put(68, new Pitch(68, 3, true,p));
	      pcset.put(69, new Pitch(69, 2, false,p));//A
	      pcset.put(70, new Pitch(70, 2, true,p));
	      pcset.put(71, new Pitch(71, 1, false,p));//B
	      break;

	    default:
	      pcset.put(0, new Pitch(0, -1, false,p));
	      break;
	    }
	  }
	  Pitch pitch(int midi) {
	    return pcset.get(midi);
	  }

}
