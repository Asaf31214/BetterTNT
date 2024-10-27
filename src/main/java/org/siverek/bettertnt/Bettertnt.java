package org.siverek.bettertnt;

import net.fabricmc.api.ModInitializer;
import org.siverek.bettertnt.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bettertnt implements ModInitializer {

    public static final String MOD_ID = "bettertnt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModItems.initialize();
        LOGGER.info("Hello Fabric world!");
    }
}
