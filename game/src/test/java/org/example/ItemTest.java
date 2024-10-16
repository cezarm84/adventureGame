package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void testItemCreation() {
        Item item = new Item("Sword", "A sharp sword");
        assertEquals("Sword", item.name());
        assertEquals("A sharp sword", item.description());
    }
}