package com.laynester.lux.hhplugin;

import com.laynester.lux.hhplugin.installer.Registry;
import com.laynester.lux.hhplugin.load.loadConsoleCommands;
import com.laynester.lux.hhplugin.load.loadEvents;
import com.laynester.lux.hhplugin.load.loadPlayerCommands;
import com.laynester.lux.hhplugin.load.loadThreads;

public class loadAll {
    public static void loadAll(boolean repairMode) throws Exception {
        Registry.load(repairMode, true, "");
        loadEvents.loadEvents();
        loadPlayerCommands.loadPlayerCommands();
        loadConsoleCommands.loadConsoleCommands();
        loadThreads.loadThreads();
    }
}
