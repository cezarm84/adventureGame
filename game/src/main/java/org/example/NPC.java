package org.example;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private String name;
    private Map<String, String> dialogues;

    public NPC(String name) {
        this.name = name;
        this.dialogues = new HashMap<>();
    }

    public void addDialogue(String key, String response) {
        dialogues.put(key.toLowerCase(), response);
    }

    public String talk(String key) {
        return dialogues.getOrDefault(key.toLowerCase(), "I don't understand.");
    }

    public String getName() {
        return name;
    }
}