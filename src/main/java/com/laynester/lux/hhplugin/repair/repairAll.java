package com.laynester.lux.hhplugin.repair;

import static com.laynester.lux.hhplugin.repair.repairModules.repairInstallation;

public class repairAll {
    public static void repairAll(String flags) throws Exception {
        System.out.println("Checking for errors and automatically repairing them automagically...");
        repairInstallation(flags);
        System.out.println("Repair finished");
    }
}
