package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NPCTest {
    @Test
    public void testNPCDialogue() {
        NPC npc = new NPC("Alice");
        npc.addDialogue("hello", "Hi there!");
        npc.addDialogue("quest", "I need you to find a golden key.");

        assertEquals("Hi there!", npc.talk("hello"));
        assertEquals("I need you to find a golden key.", npc.talk("quest"));
        assertEquals("I don't understand.", npc.talk("goodbye"));
    }
}