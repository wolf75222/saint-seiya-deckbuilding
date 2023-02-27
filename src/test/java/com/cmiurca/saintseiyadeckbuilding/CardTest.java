package com.cmiurca.saintseiyadeckbuilding;

import org.junit.Test;
import static org.junit.Assert.*;
import com.cmiurca.saintseiyadeckbuilding.saintseiya.Card;

public class CardTest {
    @Test
    public void testCardWithValidId() {
        Card card = new Card(1);
        assertEquals(1, card.getId());


    }

}