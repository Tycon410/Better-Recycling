package com.tycon.better_recycling;  // 对应文件夹路径

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterRecycling implements ModInitializer {
	public static final String MOD_ID = "better-recycling";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ModItems.SUSPICIOUS_SUBSTANCE.getClass();
		// 这行代码会触发 ModItems 中所有 static final 字段的初始化（即物品注册）
		LOGGER.info("注册成功");

		// 添加到创造模式物品栏（需要 Fabric API）
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((output) -> {
			output.accept(new ItemStack(ModItems.SUSPICIOUS_SUBSTANCE));
		});
		LOGGER.info("已加入创造物品栏");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}


