import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test 
	public void testRomanNumerals_IXCMRepeat()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "III";
		
		boolean b = roman.testIXCMRepeat(testr);
		
		assertEquals(true, b);
		
		testr = "IIII";
		
		b = roman.testIXCMRepeat(testr);
		
		assertEquals(false, b);
	}
	
	@Test 
	public void testRomanNumerals_VLDRepeat()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "DCXIV";
		
		boolean b = roman.testVLDRepeat(testr);
		
		assertEquals(true, b);
		
		testr = "DCXIVV";
		
		b = roman.testVLDRepeat(testr);
		
		assertEquals(false, b);
	}
	
	@Test 
	public void testRomanNumerals_UpperCase()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "dxciv";
		
		testr = roman.makeUppercase(testr);
		
		assertEquals("DXCIV", testr);
	}
	
	@Test 
	public void testRomanNumerals_checkImputLetters()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "MDCLXVI";
		
		boolean b = roman.checkImputLetters(testr);
		
		assertEquals(true, b);
		
		testr = "MDCLXVIA";
		
		b = roman.checkImputLetters(testr);
		
		assertEquals(false, b);
	}
	
	@Test 
	public void testRomanNumerals_IXCSubstraction()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "MDCLXIV";
		
		boolean b = roman.testIXCSubstraction(testr);
		
		assertEquals(true, b);
		
		testr = "IMDCLXV";
		
		b = roman.testIXCSubstraction(testr);
		
		assertEquals(false, b);
	}
	
	@Test 
	public void testRomanNumerals_VLDSubstraction()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "VX";
		
		boolean b = roman.testVLDSubstraction(testr);
		
		assertEquals(false, b);
	}
	
	@Test 
	public void testRomanNumerals_checkCalc()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "MDCLXIV";
		
		int num = roman.calcIt(testr);
		
		assertEquals(num, 1664);
	}
	
	@Test 
	public void testRomanNumerals_checkTranslateChar()  {
		RomanNumerals roman = new RomanNumerals();
		
		char c = 'M';
		
		int i = roman.translateChar(c);
		
		assertEquals(1000, i);
	}
	
	@Test 
	public void testRomanNumerals_testConvertInteger()  {
		RomanNumerals roman = new RomanNumerals();
		
		String testr = "MMDCLXIV";
		
		int num = roman.calcIt(testr);
		
		assertEquals(num, 2664);
	}
	
}










