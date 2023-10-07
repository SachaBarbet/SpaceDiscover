package io.github.spacediscover.data;

import io.github.spacediscover.SpaceDiscover;
import io.github.spacediscover.block.ModBlocks;
import io.github.spacediscover.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ALUMINUM_SMELTABLES = List.of(ModItems.RAW_ALUMINUM.get(),
            ModBlocks.ALUMINUM_ORE.get(), ModBlocks.DEEPSLATE_ALUMINUM_ORE.get());
    private static final List<ItemLike> NICKEL_SMELTABLES = List.of(ModItems.RAW_NICKEL.get(),
            ModBlocks.NICKEL_ORE.get(), ModBlocks.DEEPSLATE_NICKEL_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        // Smelting Ores
        oreSmelting(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.7f, 200, "aluminum_ingot");
        oreBlasting(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.7f, 100, "aluminum_ingot");
        oreSmelting(pWriter, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL_INGOT.get(), 1.0f, 200, "nickel_ingot");
        oreBlasting(pWriter, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL_INGOT.get(), 1.0f, 100, "nickel_ingot");

        // Compact / Split Ores
        nineBlockStorageRecipes(pWriter, ModItems.RAW_ALUMINUM.get(), ModBlocks.RAW_ALUMINUM_BLOCK.get());
        nineBlockStorageRecipes(pWriter, ModItems.ALUMINUM_INGOT.get(), ModBlocks.ALUMINUM_BLOCK.get());
        nineBlockStorageRecipes(pWriter, ModItems.RAW_NICKEL.get(), ModBlocks.RAW_NICKEL_BLOCK.get());
        nineBlockStorageRecipes(pWriter, ModItems.NICKEL_INGOT.get(), ModBlocks.NICKEL_BLOCK.get());

        // Storm Firework Rocket
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.STORM_FIREWORK_ROCKET.get(), 3)
                .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
                .requires(Items.GUNPOWDER, 3)
                .requires(Items.PAPER)
                .requires(Items.BLAZE_ROD)
                .requires(Items.BLUE_ICE)
                .save(pWriter);

        // Custom blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRON_ROD.get()).define('#', Items.IRON_INGOT)
                .pattern(" # ").pattern(" # ").pattern(" # ")
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WIRED_IRON_ROD.get())
                .define('I', ModBlocks.IRON_ROD.get()).define('W', ModItems.COPPER_WIRE.get())
                .pattern(" W ").pattern("WIW").pattern(" W ")
                .unlockedBy(getHasName(ModBlocks.IRON_ROD.get()), has(ModBlocks.IRON_ROD.get())).save(pWriter);

        // Custom items
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_KNIFE.get())
                .define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .pattern(" I ").pattern(" S ")
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_WIRE.get(), 4)
                .requires(Items.COPPER_INGOT).requires(ModItems.IRON_KNIFE.get())
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pWriter);

        // MACHINERY
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGNETIZED_GENERATOR.get())
                .define('A', ModItems.ALUMINUM_INGOT.get()).define('R', Items.REDSTONE).define('M', ModBlocks.MAGNETIZED_IRON_ROD.get()).define('W', ModItems.COPPER_WIRE.get())
                .pattern("ARA").pattern("MWM").pattern("ARA")
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(pWriter);
    }

    protected static void nineBlockStorageRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike pFromItemLike, ItemLike pToBlockItemLike) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pFromItemLike, 9).requires(pToBlockItemLike)
                .unlockedBy(getHasName(pToBlockItemLike), has(pToBlockItemLike)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pToBlockItemLike).define('#', pFromItemLike)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(pFromItemLike), has(pFromItemLike)).save(pFinishedRecipeConsumer);
    }

    protected static void oreSmelting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pRecipeName) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pRecipeName, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pRecipeName) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pRecipeName, "_from_blasting");
    }

    protected static void oreCooking(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, SpaceDiscover.MOD_ID + ":" +
                    getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}