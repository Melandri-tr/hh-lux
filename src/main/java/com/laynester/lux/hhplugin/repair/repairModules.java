package com.laynester.lux.hhplugin.repair;

import com.laynester.lux.hhplugin.installer.Registry;

import static com.laynester.lux.hhplugin.loadAll.loadAll;

public class repairModules {
    public static void repairInstallation(String flags) throws Exception {
        Registry.load(true,true, "rerun");
    }
}
