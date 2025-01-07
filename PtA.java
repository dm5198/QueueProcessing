package homework1;

public class PtA {
	
	public PtA() {}
	
	public int testA(String[] process) {
		
		int len = 0;
		int cycles = 0;
		
		// find length of each line (for boolean array size)
		for (int i = 0; i < process.length; i++) {
			len += process[i].length();
		}
        boolean[] processes = new boolean[len];

        // iterate through each process
        for (int i = 0; i < process.length; i++) {
        	
        	// find letters in each individual process
            String subStr = process[i].substring(process[i].indexOf("(")+1, process[i].indexOf(")"));
        	String[] letters = subStr.split(",");
            
            // iterate through letter(s) in process
            for (int j = 0; j < letters.length; j++) {
            	
            	// compute distance from 'A' to other letter(s) in process
            	char lett = letters[j].charAt(0);
                int index = lett - 'A'; 			
                
                // if letter is repeated --> new cycle --> repeat steps
                if (processes[index]) {
                	cycles++;
                	processes = new boolean[len];
                	
                	for (int k = 0; k < letters.length; k++) {
                		char lett2 = letters[k].charAt(0);
                		int index2 = lett2 - 'A';
                		processes[index2] = true;
                	}
                    break;
                }
                else
                	processes[index] = true;
            }
        }
        
        return ++cycles;
	}
}


