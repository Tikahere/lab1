package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileModifyTest {


//    @Test
//    public void testGenerateNewText1() {   //测试一，用的时候取消注释
////        fail("Not yet implemented");
//        String re = "not the sun";
//        String yu = FileModify.generateNewText();
//        assertEquals(re, yu);
//    }
//    @Test
//    public void testGenerateNewText2() {//测试二，用的时候取消注释
////        fail("Not yet implemented");
//        String re = "   ";
//        String yu = FileModify.generateNewText();
//        assertEquals(re, yu);
//    }
    @Test
    public void testGenerateNewText3() {//测试三，用的时候取消注释
//        fail("Not yet implemented");
        String re = "if sun";
        String yu = FileModify.generateNewText();
        assertEquals(re, yu);
    }    
}
