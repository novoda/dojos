package com.bowling;

import org.junit.Test;

public class FrameFactoryShould {



    @Test
    public void provideSpareFrameOnSpare(){
                     FrameFactory.roll(10).strike()
                             FrameFactory.roll(1).spare()
    }

    @Test
    public void provideStrikeFrameOnStrike() {

    }

    @Test void provideNonStrikeOrSpareFrameOtherwise(){

    }

}
