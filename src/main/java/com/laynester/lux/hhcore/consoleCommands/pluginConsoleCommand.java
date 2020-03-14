package com.laynester.lux.hhcore.consoleCommands;

import com.eu.habbo.core.consolecommands.ConsoleCommand;
import com.laynester.lux.hhcore.checkIntegrity;
import com.laynester.lux.hhcore.log.generic;
import com.laynester.lux.hhplugin.repair.repairAll;
import com.laynester.lux.hhplugin.repair.repairModules;

import static com.laynester.lux.Lux.*;
import static com.laynester.lux.hhplugin.loadAll.loadAll;

public class pluginConsoleCommand
        extends ConsoleCommand
{
    public pluginConsoleCommand() { super(pluginShort, "Hackerman.tech plugin command for " + pluginName); }
    public void handle(String[] args) throws Exception {
       if (args.length < 2 || args[1].equalsIgnoreCase("help")) {
           System.out.println("\nListing console commands for " + pluginName  + ":");
           System.out.println("      " + pluginName + " about");
           System.out.println("      " + pluginName + " reload");
           System.out.println("      " + pluginName + " update");
           System.out.println("      " + pluginName + " report");
           System.out.println("      " + pluginName + " repair <module>\n");
           return;
       }

       // About
        if (args[1].equalsIgnoreCase("about")) {
            System.out.println("\nInformation about `" + pluginName + "` (ID: " + productId  + "):" +
                    "\n      Plugin Author: " + pluginAuthor +
                    "\n      Plugin Version: " + version +
                    "\n      Latest Version: " + checkIntegrity.latestVersion + "\n");
            return;
        }

        // Repair system
        if (args[1].equalsIgnoreCase("repair")) {
            if (args.length < 3) {
                System.out.println("\nRepair Modules:");
                System.out.println("      " + pluginName + " repair all [flag]");
                System.out.println("      " + pluginName + " repair install [flag]");
                System.out.println("\n\nFlags:");
                System.out.println("      -a                Automatically repair any errors found (default)");
                System.out.println("      -v[version]       Repair errors for a certain Lux version\n");
                return;
            }
            // Flag system
            StringBuilder flags = new StringBuilder();
            for (int i = 3; i < args.length; i++) {
                flags.append(args[i]).append(" ");
            }

            System.out.println("FLAGS: " + flags.toString());

            if (args[2].equalsIgnoreCase("all")) {
                repairAll.repairAll(String.valueOf(flags));
                return;
            }
            if (args[2].equalsIgnoreCase("install")) {
                repairModules.repairInstallation(String.valueOf(flags));
                return;
            }
            System.out.println("\nUnknown sub-command. Type \"" + pluginShort + " " + args[1] + " help\" 'for help.");
            return;
        }


        if (args[1].equalsIgnoreCase("reload")) {
            generic.logMessage("Reloading...");
            loadAll(false);
            generic.logMessage("Reloaded.");
            return;
        }
        if (args[1].equalsIgnoreCase("update")) {
            System.out.println("Coming soon");
            return;
        }
        if (args[1].equalsIgnoreCase("report")) {
            System.out.println("Coming soon");
            return;
        }
       System.out.println("\nUnknown command. Type \"" + pluginShort + " help\" 'for help.");
    }
}

