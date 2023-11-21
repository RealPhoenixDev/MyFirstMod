package net.phoenixdev.myfirstmod.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.phoenixdev.myfirstmod.Block.Wireless_Reciever;

public class Wireless_Scanner extends Item {

    public Wireless_Scanner(Settings settings) {
        super(settings);
    }
    public static BlockPos coordinates;


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            coordinates = context.getBlockPos();
            context.getPlayer().sendMessage(Text.literal(coordinates.toString()), false);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient && coordinates != null){
            world.setBlockState(coordinates, world.getBlockState(coordinates).with(Properties.POWERED,true));
            world.scheduleBlockTick(coordinates, world.getBlockState(coordinates).getBlock(),2);
            coordinates = null;
        }


        return super.use(world, user, hand);
    }

}
