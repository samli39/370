package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }
    /**
     * testing if it return correct number of digit in string
     */
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }
    /**
     * testing if it is empty string and it return 0;
     */
    @Test
    public void testCountNumbers2() {
    	mycustomstring.setString("");
    	 assertEquals(0, mycustomstring.countNumbers());
    }
    /**
     * testing if it throw exception if the string is null
     */

    @Test(expected =NullPointerException.class)
    public void testCountNumbers3() {
    	assertEquals(7, mycustomstring.countNumbers());
    }
    /**
     * testing if it return 0 when there is no digit in string
     */
    @Test
    public void testCountNumbers4() {
    	 mycustomstring.setString("I'd better put some digits in this string, right?");
         assertEquals(0, mycustomstring.countNumbers());
    }
    /**
     * testing if it return 0 when the string is just long empty space with one digit
     */
    @Test
    public void testCountNumbers5() {
    	 mycustomstring.setString("              1             ");
         assertEquals(1, mycustomstring.countNumbers());

    }
    /**
     * testing if it have problem with one of 0-9 number
     */
    @Test
    public void testCountNumbers6() {
    	mycustomstring.setString("0a1b2c3d4e5q6w7e8r9t");
        assertEquals(10, mycustomstring.countNumbers());
    }
    /**
     * testing if it print out the right position from start
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }
    /**
     * testing if print out the right position from end
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    /**
     * testing the NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
    	assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    
    /**
     * testing the IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-100, true));
    }
    /**
     * testing empty string
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    /**
     * testing the word.length <n
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(100, true));
    }
    /**
     * testing if length of string is 1 and n is 1 from end
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString("I");
        assertEquals("I", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }
    /**
     * testing with long empty string
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("      ");
        assertEquals("  ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    /**
     * testing with getting symbol from start
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("!@#$%^");
        assertEquals("#^", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }
    /**
     * testing with getting symbol from end
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("&*()_+}{|?><:");
        assertEquals("*_{>", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    /**
     * testing if length of string is 1 and n is 1 from start
     */
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("I");
        assertEquals("I", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }


    /**
     * testing changing the digit to word in specific range
     */
    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /**
     * testing IllegalArgumentException
     */
    @Test(expected =IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
    	 mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
         mycustomstring.convertDigitsToNamesInSubstring(17, 12);
         assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /**
     * testing MyIndexOutOfBoundsException with startPosition < 1
     */
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
    	 mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
         mycustomstring.convertDigitsToNamesInSubstring(0, 23);
         assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /**
     * testing MyIndexOutOfBoundsException with endPosition < word.length
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
   	 mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
     mycustomstring.convertDigitsToNamesInSubstring(17, 100);
     assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /**
     * testing the NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /**
     * testing with MyIndexoutOfBoundsException with empty string
     */
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring6() {
    	mycustomstring.setString("");
        mycustomstring.convertDigitsToNamesInSubstring(1,3);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    /**
     * testing convert one position
     */
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
    	 mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
         mycustomstring.convertDigitsToNamesInSubstring(17, 17);
         assertEquals("I'd b3tt3r put sZerome d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    	/**
    	 * testing no digit need to be converted 
    	 */
    @Test
    public void testConvertDigitsToNamesInSubstring8() {
   	 	mycustomstring.setString("I'd better put some digits in this string, right?");
   	 mycustomstring.convertDigitsToNamesInSubstring(1, 44);
     assertEquals("I'd better put some digits in this string, right?", mycustomstring.getString());
    }

}
