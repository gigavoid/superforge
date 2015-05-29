package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.common.Register;

public class CookiecraftBlocks {
    public static final BlockCookieCrafter cookieCrafter = new BlockCookieCrafter();
    public static final BlockPortalCookiecraft portalCookiecraft = new BlockPortalCookiecraft();
    public static final BlockCookieBlock cookieBlock = new BlockCookieBlock();
    public static final BlockCookieDoughCollector cookieDoughCollector = new BlockCookieDoughCollector();
    public static final BlockBurntCookieBlock burntCookieBlock = new BlockBurntCookieBlock();
    public static final BlockPortalConnector portalConnector = new BlockPortalConnector();
    public static final BlockCookieLavaConverter lavaConverter = new BlockCookieLavaConverter();
    public static final BlockCookieMoonlightReflector monlightReflector = new BlockCookieMoonlightReflector();
    public static final BlockCookieStorage cookieStorage = new BlockCookieStorage();
    public static final BlockCoockiePortalActivator activator = new BlockCoockiePortalActivator();
    public static final BlockCookiePipe pipe = new BlockCookiePipe();

    public static void initializeBlocks(Register register) {
        register.registerBlock(cookieCrafter, "cookie_crafter");
        register.registerBlock(portalCookiecraft, "cookie_portal");
        register.registerBlock(cookieBlock, "cookie_block");
        register.registerBlock(cookieDoughCollector, "cookie_dough_collector");
        register.registerBlock(burntCookieBlock, "cookie_burnt_block");
        register.registerBlock(portalConnector, "cookie_portal_connector");
        register.registerBlock(lavaConverter, "cookie_lava_converter");
        register.registerBlock(monlightReflector, "cookie_moonlight_reflector");
        register.registerBlock(cookieStorage, "cookie_storage");
        register.registerBlock(activator, "cookie_portal_activator");
        register.registerBlock(pipe, "cookie_pipe");
    }
}
