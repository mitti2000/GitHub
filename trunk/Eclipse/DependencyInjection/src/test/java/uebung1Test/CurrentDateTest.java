package uebung1Test;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import uebung1.CurrentDate;
import uebung1.FakeDateGenerator;

import static junit.framework.TestCase.assertTrue;

public class CurrentDateTest {

    @Test
    public void getDate_withStub_returnTrue(){
        //Arrage
        FakeDateGenerator fakeDateGenerator = new FakeDateGenerator();
        CurrentDate sut = new CurrentDate(fakeDateGenerator);

        //act
        String result = sut.getCurrentDate();

        //assert
        assertThat(result, is("01.01.1990"));
    }
}
