//package com.teammetallurgy.agriculture.nei;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import net.minecraft.client.gui.inventory.GuiContainer;
//import net.minecraft.item.ItemStack;
//import codechicken.nei.PositionedStack;
//import codechicken.nei.recipe.TemplateRecipeHandler;
//
//import com.teammetallurgy.agriculture.gui.GUICounter;
//import com.teammetallurgy.agriculture.recipes.CounterRecipe;
//import com.teammetallurgy.agriculture.recipes.CounterRecipes;
//
//public class CounterHandler extends TemplateRecipeHandler {
//    class NEICounterRecipe extends CachedRecipe {
//
//        public ArrayList<PositionedStack> ingredients;
//        public PositionedStack result;
//
//        public NEICounterRecipe(final int width, final int height, final Object[] items, final ItemStack out, final ItemStack meh)
//        {
//            result = new PositionedStack(out, 135, 14);
//            ingredients = new ArrayList<PositionedStack>();
//            setIngredients(width, height, items, out);
//        }
//
//        @Override
//        public List<PositionedStack> getIngredients()
//        {
//            return getCycledIngredients(CounterHandler.this.cycleticks / 20, ingredients);
//        }
//
//        @Override
//        public PositionedStack getResult()
//        {
//            return result;
//        }
//
//        private void setIngredients(final int width, final int height, final Object[] items, final ItemStack out)
//        {
//
//            PositionedStack stack = new PositionedStack(items[0], 11, 14);
//            stack.setMaxSize(1);
//            ingredients.add(stack);
//
//            for (int x = 0; x < width; x++)
//            {
//                for (int y = 0; y < height; y++)
//                {
//                    if (x == 0 && y == 0)
//                    {
//                        continue;
//                    }
//
//                    if (x + y * width >= items.length)
//                    {
//                        continue;
//                    }
//
//                    if (items[x + y * width] == null)
//                    {
//                        continue;
//                    }
//
//                    stack = new PositionedStack(items[x + y * width], 14 + x * 18, 14 + y * 18);
//                    stack.setMaxSize(1);
//                    ingredients.add(stack);
//                }
//            }
//
//        }
//    }
//
//    @Override
//    public Class<? extends GuiContainer> getGuiClass()
//    {
//        return GUICounter.class;
//    }
//
//    @Override
//    public String getGuiTexture()
//    {
//        return "agriculture:textures/gui/CounterNEI.png";
//    }
//
//    @Override
//    public String getRecipeName()
//    {
//        return "Prepared Recipe";
//    }
//
//    @Override
//    public void loadCraftingRecipes(final ItemStack ingredient)
//    {
//        final ArrayList<CounterRecipe> allRecipes = CounterRecipes.getInstance().getRecipesFor(ingredient);
//
//        if (allRecipes == null) { return; }
//
//        for (final CounterRecipe recipe : allRecipes)
//        {
//            final NEICounterRecipe recipeT = new NEICounterRecipe(4, 2, recipe.getIngredients(), recipe.getCraftingResult(), ingredient);
//            arecipes.add(recipeT);
//        }
//    }
//
//    @Override
//    public void loadUsageRecipes(final ItemStack ingredient)
//    {
//        final ArrayList<CounterRecipe> allRecipes = CounterRecipes.getInstance().getRecipesUsing(ingredient);
//
//        if (allRecipes == null) { return; }
//
//        for (final CounterRecipe recipe : allRecipes)
//        {
//            final NEICounterRecipe recipeT = new NEICounterRecipe(4, 2, recipe.getIngredients(), recipe.getCraftingResult(), ingredient);
//            arecipes.add(recipeT);
//        }
//    }
//}
