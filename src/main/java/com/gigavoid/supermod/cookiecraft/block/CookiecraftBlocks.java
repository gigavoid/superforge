package com.gigavoid.supermod.cookiecraft.block;

import com.gigavoid.supermod.common.Register;

public class CookiecraftBlocks {
    public static final BlockCookieCrafter cookieCrafter = new BlockCookieCrafter();
    public static final BlockPortalCookiecraft portalCookiecraft = new BlockPortalCookiecraft();
    public static final BlockCookieBlock cookieBlock = new BlockCookieBlock();
    public static final BlockCookieDoughCollector cookieDoughCollector = new BlockCookieDoughCollector();
    public static final BlockBurntCookieBlock burntCookieBlock = new BlockBurntCookieBlock();

    public static void initializeBlocks(Register register) {
        register.registerBlock(cookieCrafter, "cookie_crafter");
        register.registerBlock(portalCookiecraft, "cookie_portal");
        register.registerBlock(cookieBlock, "cookie_block");
        register.registerBlock(cookieDoughCollector, "cookie_dough_collector");
        register.registerBlock(burntCookieBlock, "burnt_cookie_block");
    }
}
