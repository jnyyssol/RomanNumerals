
public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		
		romanNum = makeUppercase(romanNum);
		if(!testVLDRepeat(romanNum))
		{
			System.out.println("Virheellinen syöte. 'VLD'-kirjaimet eivät saa toistua.");
			return 0;
		}
		if(!testIXCMRepeat(romanNum))
		{
			System.out.println("Virheellinen syöte. 'IXCM'-kirjaimet eivät saa toistua neljästi peräkkäin.");
			return 0;
		}
		if(!checkImputLetters(romanNum))
		{
			System.out.println("Virheellinen syöte. Syöte sisältää sopimattomia kirjaimia.");
			return 0;
		}
		
		return calcIt(romanNum);
		
	}
	
	public boolean checkImputLetters(String str) {
		
		String allowed = "MDCLXVI";
		
		for(int j = 0; j < str.length(); j++) {
			if (allowed.indexOf(str.charAt(j)) == -1)
				return false;
		}
		
		return true;
	}
	
	public boolean testVLDRepeat(String str) {
		
		int counter = 0;
		String vld = "VLD";
		
		for(int l = 0; l < 3; l++) {
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == vld.charAt(l)) {
					counter++;
					if (counter > 1) return false;
				} else {
					counter = 0;
				}
			}
			counter = 0;
		}
		return true;
	}
	
	public boolean testIXCMRepeat(String str) {
		
		int counter = 0;
		String ixcm = "IXCM";
		
		for(int l = 0; l < 4; l++) {
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == ixcm.charAt(l)) {
					counter++;
					if (counter > 3) return false;
				} else {
					counter = 0;
				}
			}
			counter = 0;
		}
		return true;
	}
	
	public String makeUppercase(String str) {
		
		str = str.toUpperCase();
		
		return str;
	}
	
	public boolean testIXCSubstraction(String str) {
		
		String lcdm = "LCDM";
		String banned = "I";
		
		for(int l = 0; l < 4; l++) {
			
			if (lcdm.charAt(l) == 'D') {
				banned = "IX";
			}
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == lcdm.charAt(l) && j > 0) {
					if(banned.indexOf(str.charAt(j-1)) > -1 ) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean testVLDSubstraction(String str) {
		
		String vld = "VLD";
					
			for(int j = 0; j < str.length(); j++) {
				if(j > 0 && vld.indexOf(str.charAt(j-1)) > -1) {
					return false;
				}
			}		
		
		return true;
	}
	
	public int calcIt(String str) { 		//somethings don't work properly, but some imputs works
											
		int[] array = new int[18];		
		int current = 0;
		int totalminus = 0;
		int total = 0;
		
		String order = "MDCLXVI";
		
		for(int l = 0; l < 7; l++) {
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == order.charAt(l)) {
					current = translateChar(str.charAt(j));
					if (j > 0 && translateChar(str.charAt(j)) > translateChar(str.charAt(j-1))) {
						current = current - translateChar(str.charAt(j-1));
						totalminus = totalminus + translateChar(str.charAt(j-1));
					} else
					if(j > 0 && translateChar(str.charAt(j)) == translateChar(str.charAt(j-1))) {
						current = current+current;
					}
				}
			}
			array[l] = current;
			current = 0;
		}
		for(int i = 0; i<18; i++) {
			System.out.println(array[i]);
			total = total + array[i];
		}
		total = total - totalminus;
		
		return total;
	}
	
	public int translateChar(char c) {

		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}







