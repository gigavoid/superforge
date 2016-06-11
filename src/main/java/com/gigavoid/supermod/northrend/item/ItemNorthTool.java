package com.gigavoid.supermod.northrend.item;

import com.gigavoid.supermod.northrend.block.BlockNorthGlacialIce;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.*;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public class ItemNorthTool extends Item
{
    private Set effectiveBlocks;
    protected float efficiencyOnProperMaterial = 4.0F;
    /** Damage versus entities. */
    private float damageVsEntity;
    /** The material this tool is made from. */
    protected ToolMaterial toolMaterial;
    private static final String __OBFID = "CL_00000019";

    protected ItemNorthTool(float attackDamage, ToolMaterial material, Set effectiveBlocks)
    {
        this.toolMaterial = material;
        this.effectiveBlocks = effectiveBlocks;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.efficiencyOnProperMaterial = material.getEfficiencyOnProperMaterial();
        this.damageVsEntity = attackDamage + material.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabTools);
        if (this instanceof ItemNorthPickaxe)
        {
            toolClass = "pickaxe";
        }
        else if (this instanceof ItemNorthAxe)
        {
            toolClass = "axe";
        }
        else if (this instanceof ItemNorthShovel)
        {
            toolClass = "shovel";
        }
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return this.effectiveBlocks.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     *
     * @param target The Entity being hit
     * @param attacker the attacking entity
     */
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(2, attacker);
        return true;
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
        if ((double)blockIn.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(1, playerIn);
        }

        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    public ToolMaterial getToolMaterial()
    {
        return this.toolMaterial;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     *
     * @param toRepair The ItemStack to be repaired
     * @param repair The ItemStack that should repair this Item (leather for leather armor, etc.)
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.toolMaterial.getRepairItemStack();
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Tool modifier", (double)this.damageVsEntity, 0));
        return multimap;
    }

    /*===================================== FORGE START =================================*/
    private String toolClass;
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        int level = super.getHarvestLevel(stack, toolClass);
        if (level == -1 && toolClass != null && toolClass.equals(this.toolClass))
        {
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? com.google.common.collect.ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }

    @Override
    public float getDigSpeed(ItemStack stack, net.minecraft.block.state.IBlockState state)
    {
        for (String type : getToolClasses(stack))
        {
            if (state.getBlock().isToolEffective(type, state))
                return efficiencyOnProperMaterial;
        }
        return super.getDigSpeed(stack, state);
    }
    /*===================================== FORGE END =================================*/

    public static enum ToolMaterial {
        MITHRIL(3, 2061, 9.0F, 4.0F, 10),
        BONE(3, 3122, 10.5F, 6.0F, 10),
        ICE(3, 1561, 8.0F, 3.0F, 10);
        /**
         * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD)
         */
        private final int harvestLevel;
        /**
         * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
         */
        private final int maxUses;
        /**
         * The strength of this tool material against blocks which it is effective against.
         */
        private final float efficiencyOnProperMaterial;
        /**
         * Damage versus entities.
         */
        private final float damageVsEntity;
        /**
         * Defines the natural enchantability factor of the material.
         */
        private final int enchantability;

        private static final String __OBFID = "CL_00000042";

        //Added by forge for custom Tool materials.
        @Deprecated
        public Item customCraftingMaterial = null; // Remote in 1.8.1
        private ItemStack repairMaterial = null;

        private ToolMaterial(int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiencyOnProperMaterial = efficiency;
            this.damageVsEntity = damageVsEntity;
            this.enchantability = enchantability;
        }

        /**
         * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
         */
        public int getMaxUses() {
            return this.maxUses;
        }

        /**
         * The strength of this tool material against blocks which it is effective against.
         */
        public float getEfficiencyOnProperMaterial() {
            return this.efficiencyOnProperMaterial;
        }

        /**
         * Returns the damage against a given entity.
         */
        public float getDamageVsEntity() {
            return this.damageVsEntity;
        }

        /**
         * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
         */
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        /**
         * Return the natural enchantability factor of the material.
         */
        public int getEnchantability() {
            return this.enchantability;
        }

        @Deprecated // Use getRepairItemStack below
        public Item getRepairItem() {
            switch (this) {
                case MITHRIL:
                    return NorthrendItems.mithrilIngot;
                case BONE:
                    return NorthrendItems.dragonbone;
                case ICE:
                    return Item.getItemFromBlock(BlockNorthGlacialIce.instance);
                default:
                    return customCraftingMaterial;
            }
        }

        public ToolMaterial setRepairItem(ItemStack stack) {
            if (this.repairMaterial != null || customCraftingMaterial != null)
                throw new RuntimeException("Can not change already set repair material");
            if (this == MITHRIL || this == BONE || this == ICE)
                throw new RuntimeException("Can not change northrend tool repair materials");
            this.repairMaterial = stack;
            this.customCraftingMaterial = stack.getItem();
            return this;
        }

        public ItemStack getRepairItemStack() {
            if (repairMaterial != null) return repairMaterial;
            Item ret = this.getRepairItem();
            if (ret == null) return null;
            repairMaterial = new ItemStack(ret, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);
            return repairMaterial;
        }
    }
}

