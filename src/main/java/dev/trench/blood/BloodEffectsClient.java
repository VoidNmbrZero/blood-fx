package dev.trench.blood;

import com.google.gson.*;
import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BloodEffectsClient implements ClientModInitializer {
	public static final String MOD_ID = "blood-effects";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static JsonObject cfg;

	@Override
	public void onInitializeClient() {
		// nothing here...
	}
}